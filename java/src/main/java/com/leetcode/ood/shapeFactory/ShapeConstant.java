package com.leetcode.ood.shapeFactory;

public enum ShapeConstant {
    TRIANGLE("TRIANGLE"), SQUARE("SQUARE"), RECTANGLE("RECTANGLE");
    private final String shape;
    ShapeConstant(String shape){
        this.shape=shape;
    }
    public String getShape() {
        return shape;
    }
}
