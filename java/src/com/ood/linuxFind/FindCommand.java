package com.ood.linuxFind;

import com.ood.linuxFind.filter.Filter;

import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.List;

public class FindCommand {
    public void findFileWithFilter(File directory, List<Filter> filters) throws NotDirectoryException {
        if (!directory.isDirectory()) {
            throw new NotDirectoryException(directory.getName());
        }
        List<File> output = new ArrayList<>();
        findWithFilter(directory, filters, output);
    }

    private void findWithFilter(File directory, List<Filter> filters, List<File> output) {
        if (directory.directoryListFile().size() == 0) return;
        for(File file: directory.directoryListFile()){
            if(file.isDirectory()){
                findWithFilter(file,filters,output);
            }else{
                boolean valid=false;
                for(Filter f:filters){
                    valid=f.apply(file);
                }
                if(valid) {
                    output.add(file);
                }
            }
        }
    }

    public void parseCommand(String input) {

    }
}
