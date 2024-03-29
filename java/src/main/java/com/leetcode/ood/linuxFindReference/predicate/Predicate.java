package com.leetcode.ood.linuxFindReference.predicate;

import com.leetcode.ood.linuxFindReference.ExecutionContext;
import com.leetcode.ood.linuxFindReference.PlanNode;
import com.leetcode.ood.linuxFindReference.PlanNodeKind;

// 继承这个类以添加一个新的Predicate
public abstract class Predicate extends PlanNode {
    // 每个Predicate需要实现evaluate()方法以过滤当前访问的文件或目录
    public abstract boolean evaluate(ExecutionContext context);

    @Override
    public PlanNodeKind getKind() {
        return PlanNodeKind.PREDICATE;
    }
}
