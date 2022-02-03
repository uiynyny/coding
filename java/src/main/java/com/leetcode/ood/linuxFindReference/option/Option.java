package com.leetcode.ood.linuxFindReference.option;

import com.leetcode.ood.linuxFindReference.ExecutionContext;
import com.leetcode.ood.linuxFindReference.PlanNode;
import com.leetcode.ood.linuxFindReference.PlanNodeKind;

// 继承这个类以添加一个新的Option
public abstract class Option extends PlanNode {
    // 每个Option需要实现setup()方法以配置ExecutionContext
    public abstract void setup(ExecutionContext context);

    @Override
    public PlanNodeKind getKind() {
        return PlanNodeKind.OPTION;
    }
}
