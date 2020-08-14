package com.leetcode.problems;

public class ProductExpectSelf {
    public static void main(String[] args) {
        ProductExpectSelf obj = new ProductExpectSelf();
        int[] a = new int[]{5, 8, 6, 3, 2};
        int m = 8;
        int modulo = obj.productExceptSelf(a, m);
    }

    int productExceptSelf(int[] nums, int m) {
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (ans[i - 1] == m || nums[i - 1] == m) ans[i] = 0;
            else ans[i] = (ans[i - 1] * nums[i - 1]) % m;
        }

        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = (ans[i]*product)%m;
            product = (product * nums[i]) % m;
        }

        int res = 0;
        for (int i = 0; i < ans.length; i++) {
            res += (int) ans[i] % m;
        }
        return res % m;
    }

}
