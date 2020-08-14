package com.leetcode.problems;

import java.util.Arrays;

public class MaxCoins {
    public static void main(String[] args) {
        MaxCoins o = new MaxCoins();
        int[][] a = new int[][]{{0, 0},
                {0, 1},
                {1, 2},
                {4, 3},
                {8, 3},
                {4, 6},
                {7, 6}};
        int i = o.maximizeCoins(a);
    }

    int maximizeCoins(int[][] coins) {
        Arrays.sort(coins,(a,b)->a[0]==b[0] ? a[1]-b[1]:a[0]-b[0]);
        int x=LIS(coins,1);
        Arrays.sort(coins,(a, b)->a[1]==b[1] ? a[0]-b[0]:a[1]-b[1]);
        int y=LIS(coins,0);
        return Math.max(x,y);
    }

    int LIS(int[][] a, int i) {
        int[] dp = new int[a.length];
        int len = 0;
        for (int[] n : a) {
            int l = 0, r = len;
            //binsearch
            while (l < r) {
                int m = l + (r - l) / 2;
                // n >= middle = allow 1122 ow 12
                if (n[i]>=dp[m]) l = m + 1;
                // n < middle
                else r = m;
            }
            //update ind l to n
            dp[l] = n[i];
            if (l == len) len++;
        }
        return len;
    }

}
