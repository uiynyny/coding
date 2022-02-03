package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class RangeQueryTree {
    static class Node {
        char[] chars;
        int num;
        boolean isLeaf;

        public Node(int num, char[] chars) {
            this.num = num;
            this.chars = chars;
            isLeaf = true;
        }

        public Node(int num) {
            this.num = num;
            this.chars = null;
            isLeaf = false;
        }
    }

    static class Tree {
        Node val;
        Tree left;
        Tree right;

        public Tree(Node n) {
            val = n;
            left = null;
            right = null;
        }
    }

    public char findNthChar(Tree t, int n) {
        if (t == null) return 0;
        if (t.val.isLeaf) {
            return t.val.chars[n - 1];
        }
        if (t.val.num >= n) {
            if (t.left.val.num >= n) {
                return findNthChar(t.left, n);
            }
            return findNthChar(t.right, n - t.left.val.num);
        }
        return 0;
    }

    public List<Character> findMNthChar(Tree t, int n, int m) {
        if (t == null) return new ArrayList<>();
        if (t.val.isLeaf) {
            List<Character> ret = new ArrayList<>();
            for (int i = 0; i < t.val.chars.length; i++) {
                ret.add(t.val.chars[i]);
            }
            return ret;
        }
        return new ArrayList<>();
    }
}
