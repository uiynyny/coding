package com.leetcode.problems.google;

public class BrickWays {
    public static void main(String[] args) {
        BrickWays o = new BrickWays();
        o.countBrick(10, new int[]{1, 2, 3, 4, 5});
    }

    //dp[i][j] ways to make to j with 0 - i bricks
    public int countBrick(int w, int[] bricks) {
        int[][] dp = new int[bricks.length][w + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= w; j++) {
            if (j % bricks[0] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= dp[i].length; j++) {
                int temp = 0;
                for (int k = 0; k * bricks[i] <= j; k++) {
                    temp += dp[i - 1][j - k * bricks[i]];
                }
                dp[i][j] = temp;
            }
        }
        return dp[dp.length - 1][w];
    }
}
