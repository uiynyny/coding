package com.ood.school;

public class School {
    private String name;

    public School() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() == 0) return;
        this.name = name;
    }
}
