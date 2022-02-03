package com.leetcode.ood;

import com.leetcode.ood.referenceManager.Node;
import com.leetcode.ood.referenceManager.ReferenceManager;
import com.leetcode.ood.shapeFactory.Shape;
import com.leetcode.ood.shapeFactory.ShapeConstant;
import com.leetcode.ood.shapeFactory.ShapeFactory;
import com.leetcode.ood.singleton.Mouse;

public class Main {
    public static void main(String[] args) {
        ReferenceManager referenceManager=new ReferenceManager();
        Node t1=new Node(1);
        referenceManager.copyValue(t1);
        referenceManager.getNode().getValue();
        referenceManager.getNode();
        referenceManager.copyReference(t1);
        referenceManager.getNode();

        ShapeFactory sf=new ShapeFactory();
        Shape s=sf.getShape(ShapeConstant.RECTANGLE);
        s.draw();
        s=sf.getShape(ShapeConstant.TRIANGLE);
        s.draw();
        s=sf.getShape(ShapeConstant.SQUARE);
        s.draw();

        Mouse m1=Mouse.getMouse();
        Mouse m2=Mouse.getMouse();
    }
}
