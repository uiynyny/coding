package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumRectangles {

    public static void main(String[] args) {
        // you can write to stdout for debugging purposes, e.g.
        int[][] t = {{0, 0}, {1, 0}, {0, 1}, {0, 2}, {1, 2}, {1, 1}, {0, 0}};
        numOfRectangles(t);
    }

    // (n,2)
    public static int numOfRectangles(int[][] points) {
        // p1 p2. dist(p1,p2)
        // diag1 =  diag2. intesect at middle point
        // length,middlepoint
        Set<String> pointsSet = new HashSet<>();
        List<int[]> uniquePoints = new ArrayList<>();
        for (int[] point : points) {
            if (pointsSet.add(point[0] + "-" + point[1])) {
                uniquePoints.add(point);
            }
        }


        int res = 0;
        for (int i = 0; i < uniquePoints.size(); i++) {
            for (int j = i + 1; j < uniquePoints.size(); j++) {
                int[] p1 = uniquePoints.get(i);
                int[] p2 = uniquePoints.get(j);
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    int[] p3 = new int[]{p1[0], p2[1]};
                    int[] p4 = new int[]{p2[0], p1[1]};
                    if (pointsSet.contains(p3[0] + "-" + p3[1]) && pointsSet.contains(p4[0] + "-" + p4[1])) {
                        res++;
                    }
                }
            }
        }
        return res / 2;
    }
}
