package com.ood.linuxFindReference.parser;

import com.ood.linuxFindReference.PlanNode;
import com.ood.linuxFindReference.filter.FileTypeFilter;

import java.util.Stack;

public class FileTypeFilterParser extends OptionParser {
    @Override
    public String getName() {
        return "type";
    }
    @Override
    public PlanNode parse(Stack<String> args) {
        final String param = args.pop();
        switch (param) {
            case "f":
                return new FileTypeFilter(FileTypeFilter.FileType.FILE);
            case "d":
                return new FileTypeFilter(FileTypeFilter.FileType.DIRECTORY);
        }
        throw new RuntimeException("Unsupport file type: " + param);
    }
}
