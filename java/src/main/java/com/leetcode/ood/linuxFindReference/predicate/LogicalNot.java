package com.leetcode.ood.linuxFindReference.predicate;

import com.leetcode.ood.linuxFindReference.ExecutionContext;

// 逻辑“非”
public class LogicalNot extends Predicate {
    private final Predicate operand;

    public LogicalNot(Predicate operand) {
        this.operand = operand;
    }

    // “非”操作返回true当且仅当子谓词返回false
    @Override
    public boolean evaluate(ExecutionContext context) {
        return !operand.evaluate(context);
    }
}
