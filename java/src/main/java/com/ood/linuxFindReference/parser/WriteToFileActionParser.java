package com.ood.linuxFindReference.parser;

import com.ood.linuxFindReference.PlanNode;
import com.ood.linuxFindReference.action.WriteToFileAction;

import java.util.Stack;

public class WriteToFileActionParser extends OptionParser {
    @Override
    public String getName() {
        return "writetofile";
    }
    @Override
    public PlanNode parse(Stack<String> args) {
        return new WriteToFileAction(args.pop());
    }
}
