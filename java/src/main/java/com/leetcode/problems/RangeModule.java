package com.leetcode.problems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class RangeModule {
    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if(right<=left)return;
        Integer prev = map.floorKey(left);
        Integer next = map.floorKey(right);
        if (prev == null && next == null) map.put(left, right);
        else if (prev != null && map.get(prev) >= left) { //overlap start<=left and start ending >=left
            map.put(prev, Math.max(map.get(next), Math.max(right, map.get(prev))));
        }else{
            map.put(left,Math.max(map.get(next),right));
        }

        Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
        Set<Integer> set=new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        Integer pre=map.floorKey(left);
        if(pre==null) return false;
        return map.get(pre)>=right;
    }

    public void removeRange(int left, int right) {
        if(right<=left)return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        map.keySet().removeAll(subMap.keySet());
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */