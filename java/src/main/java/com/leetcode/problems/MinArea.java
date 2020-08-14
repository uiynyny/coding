package com.leetcode.problems;

class MinArea {
    public int minArea(int[] H) {
        int[] left = new int[H.length];
        int[] right = new int[H.length];

        int max = H[0];
        for (int i = 0; i < H.length; i++) {
            if (i == 0)
                left[i] = 0;
            else {
                max = Math.max(max, H[i - 1]);
                left[i] = max;
            }
        }
        max = H[H.length - 1];
        for (int i = H.length - 1; i >= 0; i--) {
            max = Math.max(max, H[i]);
            right[i] = max;

        }
        int area = Integer.MAX_VALUE;
        for (int i = 0; i < H.length; i++) {
            area = Math.min(area, left[i] * i + right[i] * (H.length - i));
        }

        return area;
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 4 };
        MinArea ma = new MinArea();
        System.out.println(ma.minArea(a));
    }
}