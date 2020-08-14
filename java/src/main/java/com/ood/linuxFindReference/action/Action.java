package com.ood.linuxFindReference.action;

import com.ood.linuxFindReference.ExecutionContext;
import com.ood.linuxFindReference.PlanNode;
import com.ood.linuxFindReference.PlanNodeKind;

// 继承这个类以添加一个新的Action
public abstract class Action extends PlanNode {
    // 每个Action需要实现invoke()方法以针对当前访问的文件或目录作出对应操作
    public abstract void invoke(ExecutionContext context);
    public void initialize() {}
    public void finalize() {}
    @Override
    public PlanNodeKind getKind() {
        return PlanNodeKind.ACTION;
    }
}
