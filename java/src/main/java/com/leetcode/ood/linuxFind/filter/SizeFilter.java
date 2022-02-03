package com.leetcode.ood.linuxFind.filter;

import com.leetcode.ood.linuxFind.File;

public class SizeFilter extends Filter {
    private final long size;
    private final OperatorType operator;

    public SizeFilter(int size, OperatorType op) {
        this.size = size;
        this.operator = op;
    }

    @Override
    public boolean apply(File file) {
        switch (this.operator) {
            case EQUAL:
                return file.getSize() == this.size;
            case GREATER_EQUAL:
                return file.getSize() >= this.size;
            case LESS_EQUAL:
                return file.getSize() <= this.size;
            default:
                return false;
        }
    }

    public enum OperatorType {
        EQUAL, GREATER_EQUAL, LESS_EQUAL;
    }
}
