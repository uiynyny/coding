package com.leetcode.problems;

public class CountWays {
    public static void main(String[] args) {
        CountWays obj = new CountWays();
        int i = obj.countWays(5, 2);
    }

    int countWays(int n, int k) {
        final int MOD = (int) 1e9 + 7;

        int[][] c_nk = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                c_nk[i][j] = 0;

        c_nk[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if(j==0||j==n)
                    c_nk[i+1][j]=1;
                else
                    c_nk[i+1][j]=c_nk[i][j]+c_nk[i][j-1];
            }
        }
        return c_nk[n][k];
    }
}
