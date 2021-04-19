package com.leetcode.problems;

/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (54.69%)
 * Total Accepted:    122.7K
 * Total Submissions: 221.5K
 * Testcase Example:  '[5,2,13]'
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * Example:
 * 
 * 
 * Input: The root of a Binary Search Tree like this:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * Output: The root of a Greater Tree like this:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
 * Note: This question is the same as 1038:
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import com.leetcode.problems.util.TreeNode;

import java.util.ArrayDeque;

class Solution {
    public TreeNode<Integer> convertBST(TreeNode<Integer> root) {
        TreeNode<Integer> cur=root;
        ArrayDeque<TreeNode> stk=new ArrayDeque<>();
        int topup=0;
        while(!stk.isEmpty()||cur!=null){
            while(cur!=null){
                stk.push(cur);
                cur=cur.right;
            }
            cur=stk.pop();
            int temp= cur.val;
            cur.val += topup;
            topup+=temp;
            cur=cur.left;
        }
        return root;
    }
}
