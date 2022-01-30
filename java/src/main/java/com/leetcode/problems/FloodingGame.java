package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class FloodingGame {
    public static void main(String[] args) {
        FloodingGame obj = new FloodingGame();
        char[][] g = new char[][]{
                {'r', 'g', 'g'},
                {'g', 'r', 'r'},
        };
        obj.minStep(g);
    }

    public int minStep(char[][] grid) {
        int[][] steps = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                steps[i][j] = Integer.MAX_VALUE;
            }
        }
        steps[0][0] = 0;
        List<int[]> res = new ArrayList<>();
        dfs(grid, steps, 0, grid[0][0], 0, 0, res);
        //dfs to count current grid and mark all with step
        return 0;
    }

    private void dfs(char[][] grid, int[][] steps, int step, char color, int r, int c, List<int[]> res) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != color && steps[r][c] >= step)
            return;
        grid[r][c] = '0';
        res.add(new int[]{r, c});
        dfs(grid, steps, step, color, r + 1, c, res);
        dfs(grid, steps, step, color, r - 1, c, res);
        dfs(grid, steps, step, color, r, c + 1, res);
        dfs(grid, steps, step, color, r, c - 1, res);
    }
}
