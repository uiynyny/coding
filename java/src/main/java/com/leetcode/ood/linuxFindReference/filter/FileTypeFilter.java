package com.leetcode.ood.linuxFindReference.filter;

import com.leetcode.ood.linuxFindReference.ExecutionContext;

// 设定查找的是文件还是目录，例如：
// -type f
// -type d
public class FileTypeFilter extends Filter {
    private final FileType targetFileType;

    public FileTypeFilter(FileType targetFileType) {
        this.targetFileType = targetFileType;
    }

    @Override
    public boolean evaluate(ExecutionContext context) {
        switch (targetFileType) {
            case FILE:
                return context.getBasicFileAttributes().isRegularFile();
            case DIRECTORY:
                return context.getBasicFileAttributes().isDirectory();
        }
        throw new RuntimeException("Unsupported enum value: " + targetFileType.name());
    }

    public enum FileType {
        DIRECTORY, FILE
    }
}
