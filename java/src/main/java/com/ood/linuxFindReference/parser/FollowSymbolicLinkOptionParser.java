package com.ood.linuxFindReference.parser;

import com.ood.linuxFindReference.PlanNode;
import com.ood.linuxFindReference.option.FollowSymbolicLinkOption;

import java.util.Stack;

public class FollowSymbolicLinkOptionParser extends OptionParser {
    @Override
    public String getName() {
        return "L";
    }
    @Override
    public PlanNode parse(Stack<String> args) {
        return new FollowSymbolicLinkOption();
    }
}
