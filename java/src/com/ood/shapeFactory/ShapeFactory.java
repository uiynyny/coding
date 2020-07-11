package com.ood.shapeFactory;

public class ShapeFactory {
    public ShapeFactory() {
    }

    public Shape getShape(ShapeConstant sc) {
        switch (sc) {
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            case TRIANGLE:
                return new Triangle();
            default:
                return null;
        }
    }
}
