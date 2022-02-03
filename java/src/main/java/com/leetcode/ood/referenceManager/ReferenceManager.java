package com.leetcode.ood.referenceManager;

public class ReferenceManager {
    private Node node;

    public ReferenceManager() {
        this.node = null;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void copyValue(Node obj) {
        if(obj==null)return;
        if(node==null)
            node = new Node(obj.getValue());
        node.setValue(obj.getValue());
    }

    public void copyReference(Node obj) {
        if(obj==null)return;
        node = obj;
    }
}
