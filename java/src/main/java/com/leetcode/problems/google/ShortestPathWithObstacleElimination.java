package com.leetcode.problems.google;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstacleElimination {
    //grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
    public static void main(String[] args) {
        int[][] g = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        ShortestPathWithObstacleElimination obj = new ShortestPathWithObstacleElimination();
        obj.shortestPath(g, 1);
    }

    public int shortestPath(int[][] grid, int k) {
        // grid i,j with currently k obs removed
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[0][0][0] = true;
        q.add(new int[]{0, 0, 0});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                if (p[0] == grid.length - 1 && p[1] == grid[p[0]].length - 1) return step;
                for (int[] d : dirs) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    int curK = p[2];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) continue;
                    if (grid[x][y] == 1) {
                        curK++;
                    }
                    if (curK <= k && !visited[x][y][curK]) {
                        visited[x][y][curK] = true;
                        q.add(new int[]{x, y, curK});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
