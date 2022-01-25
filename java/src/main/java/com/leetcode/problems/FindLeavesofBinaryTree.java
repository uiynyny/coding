package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.problems.util.TreeNode;

public class FindLeavesofBinaryTree {
    public List<List<Integer>> solve(TreeNode<Integer> t) {
        if (t == null) return new ArrayList<>();
        List<List<Integer>> left = solve(t.left);
        List<List<Integer>> right = solve(t.right);
        List<Integer> cur = new ArrayList<>();
        cur.add(t.val);
        List<List<Integer>> ans;
        if (left == null && right == null) {
            //t is leaf
            ans = new ArrayList<>();
        } else if (left == null || right == null) {
            // t has one child
            ans = left == null ? right : left;
        } else {
            ans = right.size() > left.size() ? merge(right, left) : merge(left, right);
        }
        ans.add(cur);
        return ans;
    }

    private List<List<Integer>> merge(List<List<Integer>> l, List<List<Integer>> r) {
        for (int i = 0; i < r.size(); i++) {
            l.get(i).addAll(r.get(i));
        }
        return l;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> depth(TreeNode<Integer> r) {
        find(r);
        return res;
    }

    private int find(TreeNode<Integer> r) {
        if (r == null) return -1;

        int depth = Math.max(find(r.left), find(r.right)) + 1;
        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(r.val);
        return depth;
    }
}
