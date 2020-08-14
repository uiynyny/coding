package com.leetcode.problems;

import java.util.*;

class SummaryRanges {
    TreeMap<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        map = new TreeMap();
    }

    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        int[] a = {6, 6, 0, 4, 8, 7, 6, 4, 7, 5};
        for (int t : a) {
            obj.addNum(t);
            int[][] x = obj.getIntervals();
            for (int[] c : x) {
                System.out.print(Arrays.toString(c));
            }
            System.out.println();
        }
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer l = map.floorKey(val);
        Integer h = map.ceilingKey(val);
        if (l != null && h != null && map.get(l) + 1 == val && val + 1 == h) {
            map.put(l, map.get(h));
            map.remove(h);
        } else if (l != null && map.get(l) + 1 >= val) {
            map.put(l, Math.max(map.get(l), l));
        } else if (h != null && val + 1 == h) {
            map.put(val, map.get(h));
            map.remove(h);
        } else {
            map.put(val, val);
        }
    }

    public int[][] getIntervals() {
        List<int[]> ans = new ArrayList<>();
        for (Integer k : map.keySet()) {
            int v = map.get(k);
            ans.add(new int[]{k, v});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */