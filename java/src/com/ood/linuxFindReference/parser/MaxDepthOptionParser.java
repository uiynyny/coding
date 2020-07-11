package com.ood.linuxFindReference.parser;

import com.ood.linuxFindReference.option.MaxDepthOption;
import com.ood.linuxFindReference.PlanNode;

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
