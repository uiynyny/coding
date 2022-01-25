package com.leetcode.problems;

public class AlmostTetris {
    public static void main(String[] args) {
        int[] figure = new int[]{4, 2, 1, 3};
        AlmostTetris s = new AlmostTetris();
        s.almostTetris(4, 4, figure);
    }

    int[][] almostTetris(int m, int n, int[] figure) {
        int[][] g = new int[m][n];
        int acc = 0;
        for (int f : figure) {
            int[][] s = shape(f, ++acc);
            l:
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (fit(g, s, i, j)) {
                        put(g, s, i, j);
                        break l;//after put, break loop
                    }
                }
        }
        return g;
    }

    void put(int[][] g, int[][] s, int r, int c) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                g[r + i][c + j] |= s[i][j];
            }
        }
    }

    private boolean fit(int[][] ans, int[][] shape, int r, int c) {
        boolean fit = true;
        for (int i = 0; i < shape.length; i++)
            for (int j = 0; j < shape[i].length; j++) {
                if (r + i >= ans.length || c + j >= ans[i].length) return false;
                // ans[r][c] is 0 or shape[i][j] is 0
                fit &= ans[r + i][c + j] == 0 || shape[i][j] == 0;
            }
        return fit;
    }

    int[][] shape(int i, int n) {
        switch (i) {
            case 1:
                return new int[][]{{n}};
            case 2:
                return new int[][]{{n, n, n}};
            case 3:
                return new int[][]{{n, n}, {n, n}};
            case 4:
                return new int[][]{{n, 0}, {n, n}, {n, 0}};
            case 5:
                return new int[][]{{0, n, 0}, {n, n, n}};
            default:
                return null;
        }
    }
}
