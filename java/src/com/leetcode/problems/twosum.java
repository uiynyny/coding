package com.leetcode.problems;

import java.util.HashMap;
import java.util.Arrays;

public class twosum {
    public static void main(String[] args) {
        int[] nums1 = { 1, 10, 25, 35, 60 };
        int target1 = 90;
        System.out.println(Arrays.toString(Find2Sum(nums1, target1 - 30)));
        int[] nums2 = { 20, 50, 40, 25, 30, 10 };
        int target2 = 90;
        System.out.println(Arrays.toString(Find2Sum(nums2, target2 - 30)));
        int[] nums3 = { 50, 20, 10, 40, 25, 30 };
        int target3 = 90;
        System.out.println(Arrays.toString(Find2Sum(nums3, target3 - 30)));
        int[] nums4 = { 1, 2 };
        int target4 = 90;
        System.out.println(Arrays.toString(Find2Sum(nums4, target4 - 30)));
    }

    private static int[] Find2Sum(int[] nums, int target) {
        if (nums.length == 0)
            return null;
        int[] res = new int[] { -1, -1 };
        int diff=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem=target-nums[i];
            if (hm.containsKey(rem)) {
                int j=hm.get(rem);
                if(Math.abs(nums[j]-nums[i])>diff){
                    diff=Math.abs(nums[j]-nums[i]);
                    res[0]=j;
                    res[1]=i;
                }
            }
            hm.put(nums[i],i);
        }
        return res;
    }
}