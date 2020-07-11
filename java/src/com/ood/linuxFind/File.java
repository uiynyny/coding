package com.ood.linuxFind;

import com.ood.linuxFind.filter.TypeFiler;

import java.util.List;

public class File {
    private String name;
    private boolean isDirectory;
    private boolean isFile;
    private int size;
    private TypeFiler.FileType type;

    public boolean isFile() {
        return isFile;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TypeFiler.FileType getType() {
        return type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> directoryListFile() {
        return null;
    }

    public File getFile() {
        return null;
    }

    public void setFile(boolean file) {
        isFile = file;
    }
}
