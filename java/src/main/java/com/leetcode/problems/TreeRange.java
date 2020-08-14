package com.leetcode.problems;

import java.util.HashMap;

class TreeRange {
    public int solution(int[] T) {
        int l = T.length;
        int res = 0;
        for (int i = 0; i < l-1; i++) {
            // neighbor for current i
            HashMap<Integer, Integer> bad = new HashMap<>();
            int count = 1;
            // node i linked to other node
            if (T[i] != i) {
                bad.put(T[i], 1);
            }

            for (int j = i + 1; j < l; j++) {
                //j is neighbor of i
                if (bad.containsKey(j)) {
                    count -= bad.get(j);
                    bad.remove(j);
                }
                //j connect to a node out of range of (i,j)
                if (T[j] < i || T[j] > j) {
                    bad.put(T[j], bad.getOrDefault(T[j], 0) + 1);
                    count += 1;
                } else if (T[j] == j)// T[j] node conect to itself
                    count += 1;

                if (count <= 1) {
                    res += 1;
                }
            }
        }
        return res + T.length;
    }

    public static void main(String[] args) {
        int[] T = { 2, 0, 2, 2, 1, 0 };
        TreeRange v = new TreeRange();
        System.out.println(v.solution(T));
    }
}