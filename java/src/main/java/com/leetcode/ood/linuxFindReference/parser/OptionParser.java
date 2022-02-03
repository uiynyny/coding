package com.leetcode.ood.linuxFindReference.parser;

import com.leetcode.ood.linuxFindReference.PlanNode;

import java.util.Stack;

// Option/Filter/Action的解析器基类
public abstract class OptionParser {
    // 该解析器所处理的参数名，例如"maxdepth"，"type"，"size"
    public abstract String getName();

    // 解析逻辑的实现
    public abstract PlanNode parse(Stack<String> args);
}
