package com.leetcode.problems;

public class EggDrop {
    public static void main(String[] args) {
        EggDrop o = new EggDrop();
        System.out.println(o.drop(100, 2));
    }

    public int drop(int N, int K) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            m++;
            for(int k=1;k<=K;k++) dp[m][k]=1+dp[m-1][k-1]+dp[m-1][k];
        }
        return m;
    }
}
