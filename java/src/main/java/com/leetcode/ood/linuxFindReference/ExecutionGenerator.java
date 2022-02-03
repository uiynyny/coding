package com.leetcode.ood.linuxFindReference;

import com.leetcode.ood.linuxFindReference.action.Action;
import com.leetcode.ood.linuxFindReference.option.Option;
import com.leetcode.ood.linuxFindReference.parser.*;
import com.leetcode.ood.linuxFindReference.predicate.LogicalAnd;
import com.leetcode.ood.linuxFindReference.predicate.LogicalNot;
import com.leetcode.ood.linuxFindReference.predicate.LogicalOr;
import com.leetcode.ood.linuxFindReference.predicate.Predicate;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// 解析参数并生成执行器 //////////////////////////////
////////////////////////////////////////////////////////////////////////////////
class ExecutionGenerator {
    private static Map<String, OptionParser> optionParserRegistry = new HashMap<>();

    // 在这里注册所有的OptionParser子类
    static {
        Register(new MaxDepthOptionParser());
        Register(new FollowSymbolicLinkOptionParser());
        Register(new FileTypeFilterParser());
        Register(new FileNameFilterParser());
        Register(new FileSizeFilterParser());
        Register(new WriteToFileActionParser());
    }

    private Stack<String> tokens;

    private static void Register(OptionParser parser) {
        optionParserRegistry.put(parser.getName(), parser);
    }

    // 给定输入参数，生成执行器
    // 这里包含了一个简易的LL(1) recursive descent parser
    public Executor generateExecutor(String[] args) {
        tokens = new Stack<String>();
        for (int i = args.length - 1; i >= 0; --i) {
            tokens.push(args[i]);
        }

        if (tokens.empty()) {
            throw new RuntimeException("Requires at least one path argument");
        }
        final Path filePath = Paths.get(tokens.pop());

        ArrayList<Option> options = new ArrayList<>();
        ArrayList<Predicate> predicates = new ArrayList<>();
        ArrayList<Action> actions = new ArrayList<>();

        while (!tokens.empty()) {
            PlanNode node = parseOr();
            switch (node.getKind()) {
                case OPTION:
                    options.add((Option) node);
                case PREDICATE:
                    predicates.add((Predicate) node);
                case ACTION:
                    actions.add((Action) node);
                default:
                    throw new RuntimeException("Unsupport enum value " + node.getKind().name());
            }
        }

        Predicate filterPredicate = null;
        if (predicates.size() == 1) {
            filterPredicate = predicates.get(0);
        } else if (predicates.size() > 1) {
            filterPredicate = new LogicalAnd(predicates);
        }

        tokens = null;
        return new Executor(filePath, options, filterPredicate, actions);
    }

    // 解析 "... -or ..." 这样的输入
    private PlanNode parseOr() {
        ArrayList<PlanNode> operands = new ArrayList<>();
        operands.add(parseAnd());
        while (nextTokenIs("-or") || nextTokenIs("-o")) {
            tokens.pop();
            operands.add(parseAnd());
        }
        if (operands.size() == 1) {
            return operands.get(0);
        }
        ArrayList<Predicate> predicates = new ArrayList<>();
        for (PlanNode node : operands) {
            if (node.getKind() != PlanNodeKind.PREDICATE) {
                throw new RuntimeException("Logical OR can only be applied to predicates");
            }
            predicates.add((Predicate) node);
        }
        return new LogicalOr(predicates);
    }

    // 解析 "... -and ..." 这样的输入
    private PlanNode parseAnd() {
        ArrayList<PlanNode> operands = new ArrayList<>();
        operands.add(parseNot());
        while (nextTokenIs("-and") || nextTokenIs("-a")) {
            tokens.pop();
            operands.add(parseNot());
        }
        if (operands.size() == 1) {
            return operands.get(0);
        }
        ArrayList<Predicate> predicates = new ArrayList<>();
        for (PlanNode node : operands) {
            if (node.getKind() != PlanNodeKind.PREDICATE) {
                throw new RuntimeException("Logical AND can only be applied to predicates");
            }
            predicates.add((Predicate) node);
        }
        return new LogicalAnd(predicates);
    }

    // 解析 "-not ..." 这样的输入
    private PlanNode parseNot() {
        boolean negate = false;
        if (nextTokenIs("-not") || nextTokenIs("-n")) {
            tokens.pop();
            negate = true;
        }
        PlanNode operand = parseAtom();
        if (!negate) {
            return operand;
        }
        if (operand.getKind() != PlanNodeKind.PREDICATE) {
            throw new RuntimeException("Logical NOT can only be applied to a predicate");
        }
        return new LogicalNot((Predicate) operand);
    }

    // 解析括号表达式 "( ... )" 或者是基础的 Option / Filter / Action
    private PlanNode parseAtom() {
        if (nextTokenIs("(")) {
            tokens.pop();
            PlanNode node = parseOr();
            if (!nextTokenIs(")")) {
                throw new RuntimeException("Unmatched parenthesis");
            }
            tokens.pop();
            return node;
        }
        if (tokens.isEmpty()) {
            throw new RuntimeException("Unexpected end of input stream");
        }
        if (!tokens.peek().startsWith("-")) {
            throw new RuntimeException("Unexpected token " + tokens.peek());
        }
        // 这个name就是参数名，例如-type的"type"，-size的"size"
        final String name = tokens.pop().substring(1);
        // 在registry中找到与参数名对应的parser
        final OptionParser parser = optionParserRegistry.get(name);
        if (parser == null) {
            throw new RuntimeException("Unrecognized option " + name);
        }
        // Parser各自的parse()方法用于解析参数的arguments
        // 例如 -size +1M，那么"size"所对应的parser应当知道如何解析"+1M"
        return parser.parse(tokens);
    }

    private boolean nextTokenIs(String value) {
        return !tokens.isEmpty() && value.equals(tokens.peek());
    }
}
