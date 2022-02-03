package com.leetcode.ood.linuxFindReference.parser;

import com.leetcode.ood.linuxFindReference.PlanNode;
import com.leetcode.ood.linuxFindReference.filter.FileNameFilter;

import java.nio.file.FileSystems;
import java.util.Stack;

public class FileNameFilterParser extends OptionParser {
    @Override
    public String getName() {
        return "name";
    }

    @Override
    public PlanNode parse(Stack<String> args) {
        return new FileNameFilter(FileSystems.getDefault().getPathMatcher("glob:" + args.pop()));
    }
}
