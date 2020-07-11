package com.ood.linuxFind.filter;

import com.ood.linuxFind.File;

public class SizeFilter extends Filter {
    private final long size;
    private final OperatorType operator;

    public SizeFilter(int size, OperatorType op) {
        this.size = size;
        this.operator = op;
    }

    @Override
    public boolean apply(File file) {
        return switch (this.operator) {
            case EQUAL -> file.getSize() == this.size;
            case GREATER_EQUAL -> file.getSize() >= this.size;
            case LESS_EQUAL -> file.getSize() <= this.size;
        };
    }

    public enum OperatorType {
        EQUAL, GREATER_EQUAL, LESS_EQUAL;
    }
}
