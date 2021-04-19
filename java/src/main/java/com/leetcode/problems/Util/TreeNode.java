package com.leetcode.problems.util;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T v){
        val=v;
    }

    @Override
    public String toString() {
        return "TreeNode{ value=" + val+" left="+left+" right="+right+"}";
    }
}