package com.leetcode.ood.linuxFind.filter;

import com.leetcode.ood.linuxFind.File;

public class TypeFiler extends Filter {
    private final FileType fileType;

    public TypeFiler(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean apply(File file) {
        switch (fileType) {
            case DIRECTORY:
                return file.isDirectory();
            case FILE:
                return file.isFile();
        }
        throw new RuntimeException("Unsupported file type " + fileType.name());
    }

    public enum FileType {
        DIRECTORY, FILE
    }
}
