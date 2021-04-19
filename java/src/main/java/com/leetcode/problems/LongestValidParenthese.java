package com.leetcode.problems;

import java.util.Stack;

public class LongestValidParenthese {
    public static void main(String[] args) {
        LongestValidParenthese o = new LongestValidParenthese();
        System.out.println(o.longestValidParentheses("()((())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int len=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') stk.push(i); //push current index
            else { // ) pop last index and update result if possible
                stk.pop();
                if(stk.isEmpty()) stk.push(i);
                else len=Math.max(len, i-stk.peek());
            }
        }
        return len;
    }
}
