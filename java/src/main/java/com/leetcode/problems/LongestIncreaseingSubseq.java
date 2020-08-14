package com.leetcode.problems;

public class LongestIncreaseingSubseq {
    public static void main(String[] args) {
        LongestIncreaseingSubseq obj = new LongestIncreaseingSubseq();
        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        obj.lengthOfLIS(a);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            //binary search
            int l = 0, r = len;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (dp[m] < n) l = m + 1;
                else r = m;
            }
            dp[l] = n;
            if (l == len) ++len;
        }
        return len;
    }
}
