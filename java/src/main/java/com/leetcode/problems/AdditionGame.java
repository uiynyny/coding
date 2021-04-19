package com.leetcode.problems;

public class AdditionGame {
    public static void main(String[] args) {
        AdditionGame o = new AdditionGame();
        System.out.println(o.solve(8,2,6,13));
    }

    int solve(int a, int b, int c, int n) {
        int res = 0;
        int[] arr = new int[] { a, b, c };
        while (n-- > 0) {
            int max = 0;
            int ind = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    ind = i;
                }
            }
            res += max;
            if (arr[ind] > 0)
                arr[ind]--;
        }
        return res;
    }
}
