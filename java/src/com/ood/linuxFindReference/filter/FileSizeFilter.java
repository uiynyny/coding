package com.ood.linuxFindReference.filter;

import com.ood.linuxFindReference.ExecutionContext;
import com.ood.linuxFindReference.filter.Filter;

// 过滤文件size，例如：
// -size 1MB
// -size +1KB
// -size -1GB
public class FileSizeFilter extends Filter {
    private final long targetFileSize;
    private final OpType op;
    public FileSizeFilter(OpType op, long targetFileSize) {
        this.op = op;
        this.targetFileSize = targetFileSize;
    }

    @Override
    public boolean evaluate(ExecutionContext context) {
        long fileSize = context.getBasicFileAttributes().size();
        switch (op) {
            case EQUAL:
                return fileSize == targetFileSize;
            case GREATER_EQUAL:
                return fileSize >= targetFileSize;
            case LESS_EQUAL:
                return fileSize <= targetFileSize;
        }
        throw new RuntimeException("Unsupported enum value: " + op.name());
    }

    public enum OpType {
        EQUAL, GREATER_EQUAL, LESS_EQUAL
    }
}
