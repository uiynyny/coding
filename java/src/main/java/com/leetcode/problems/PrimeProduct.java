package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * leetcode.PrimeProduct
 */
public class PrimeProduct {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(PrimeProduct.class.getName());
        PrimeProduct test = new PrimeProduct();
        int[] nums = {2, 3, 5, 7}; // 1 is not a prime.
        int[] nums1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        logger.info("" + test.primeProduct(nums));
        logger.info("" + test.primeProduct(nums1));
    }

    public List<Integer> primeProduct(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        btDup(nums, ans, 1, 0);
        return ans;
    }

    private void bt(int[] nums, List<Integer> ans, int product, int i) {
        if (product != 1) {
            ans.add(product);
        }
        for (; i < nums.length; i++) {
            product *= nums[i];
            bt(nums, ans, product, i + 1);
            product /= nums[i];
        }
    }

    private void btDup(int[] nums, List<Integer> ans, int product, int i) {
        if (product != 1)
            ans.add(product);

        for (; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {// skip dup
                continue;
            }
            product *= nums[i];
            btDup(nums, ans, product, i + 1);
            product /= nums[i];
        }
    }
}