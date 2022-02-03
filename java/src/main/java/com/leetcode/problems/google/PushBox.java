package com.leetcode.problems.google;

import java.util.LinkedList;
import java.util.Queue;

public class PushBox {

    private char[][] map;

    public PushBox(char[][] map) {
        this.map = map;
    }

    public static void main(String[] args) {
        char[][] map = {
                {'0', '0', '0'},
                {'0', '#', '0'},
                {'@', '0', '0'}
        };
        PushBox obj = new PushBox(map);
        int bfs = obj.bfs(0, 0, 1, 2);
        System.out.println(bfs);
    }

    public int bfs(int px, int py, int bx, int by) {
        int[][][][] step = new int[map.length][map[0].length][map.length][map[0].length];
        step[px][py][bx][by] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{px, py, bx, by});
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (map[poll[2]][poll[3]] == '@') return step[poll[0]][poll[1]][poll[2]][poll[3]] - 1;
            for (int[] d : dirs) {
                int newpx = poll[0] + d[0];
                int newpy = poll[1] + d[1];
                if (bound(newpx, newpy)) continue;// invalid person move
                if (newpx == poll[2] && newpy == poll[3]) {//person collide box
                    if (bound(poll[2] + d[0], poll[3] + d[1])) continue;//invalid box move
                    step[newpx][newpy][poll[2] + d[0]][poll[3] + d[1]] = step[poll[0]][poll[1]][poll[2]][poll[3]] + 1;//update steps required
                    q.add(new int[]{newpx, newpy, poll[2] + d[0], poll[3] + d[1]});
                } else {
                    //no collision
                    if (step[newpx][newpy][poll[2]][poll[3]] != 0) continue;
                    step[newpx][newpy][poll[2]][poll[3]] = step[poll[0]][poll[1]][poll[2]][poll[3]] + 1;//update steps required
                    q.add(new int[]{newpx, newpy, poll[2], poll[3]});
                }
            }
        }
        return -1;
    }

    private boolean bound(int px, int py) {
        return (px < 0 || py < 0 || px >= map.length || py >= map[px].length || map[px][py] == '#');
    }
}
