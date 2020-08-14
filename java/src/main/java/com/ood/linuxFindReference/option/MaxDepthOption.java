package com.ood.linuxFindReference.option;

import com.ood.linuxFindReference.ExecutionContext;

// 查找时的最大深度，例如：
// -maxdepth 10
public class MaxDepthOption extends Option {
    private int maxDepth;
    public MaxDepthOption(int maxDepth) {
        this.maxDepth = maxDepth;
    }
    @Override
    public void setup(ExecutionContext context) {
        context.setMaxDepth(maxDepth);
    }
}
