package com.leetcode.problems;

public class ReduceMAE {
    public static void main(String[] args) {
        ReduceMAE o = new ReduceMAE();
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int i = o.minDiff(a, b);
    }

    public int minDiff(int[] a, int[] b) {
        int amax = a[0];
        for (int x : a) amax = Math.max(amax, x);
        // maxof: a[i]- min(b[i],amax)
        int ind=0;
        int dist=Math.abs(a[0]-b[0]);
        for(int i=0;i<a.length;i++){
            int curDist=Math.abs(a[i]-Math.min(amax,b[i]));
            if (dist <curDist){
                dist=curDist;
                ind=i;
            }
        }
        int[] d = calcDiff(a, b);
        return 0;
    }

    int[] calcDiff(int[] a, int[] b) {
        int sum = 0;
        int[] d = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(b[i] - a[i]);
            d[i] = Math.abs(b[i] - a[i]);
        }
        return d;
    }
}
