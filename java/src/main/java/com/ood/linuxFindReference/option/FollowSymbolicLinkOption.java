package com.ood.linuxFindReference.option;

import com.ood.linuxFindReference.ExecutionContext;

// 是否处理symbolic link：
// -L
public class FollowSymbolicLinkOption extends Option {
    @Override
    public void setup(ExecutionContext context) {
        context.setFollowSymbolicLink();
    }
}
