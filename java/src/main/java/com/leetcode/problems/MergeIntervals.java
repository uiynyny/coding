package com.leetcode.problems;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals o = new MergeIntervals();
        List<int[]> test=new ArrayList<>();
        test.add(new int[]{1,3});
        test.add(new int[]{2,6});
        test.add(new int[]{8,10});
        test.add(new int[]{15,18});
        
        var c= o.merge(test);
    }

    public List<int[]> merge(List<int[]> intervals) {
        Collections.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> res=new ArrayList<>();
        int[] prev=intervals.get(0);
        for(int[] in:intervals){
            if(in[0]<=prev[1]){
                prev[1]=Math.max(in[1],prev[1]);
            }else{
                res.add(prev);
                prev=in;
            }
        }
        res.add(prev);
        return res;
    }
}
