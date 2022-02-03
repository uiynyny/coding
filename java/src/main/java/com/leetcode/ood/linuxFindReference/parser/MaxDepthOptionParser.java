package com.leetcode.ood.linuxFindReference.parser;

import com.leetcode.ood.linuxFindReference.PlanNode;
import com.leetcode.ood.linuxFindReference.option.MaxDepthOption;

import java.util.Stack;

public class MaxDepthOptionParser extends OptionParser {
    @Override
    public String getName() {
        return "maxdepth";
    }

    @Override
    public PlanNode parse(Stack<String> args) {
        return new MaxDepthOption(Integer.parseInt(args.pop()));
    }
}
