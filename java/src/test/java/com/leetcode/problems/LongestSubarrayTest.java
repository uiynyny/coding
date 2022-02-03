package com.leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubarrayTest {
    @Test
    public void test() {
        LongestSubarray s=new LongestSubarray();
        int i = s.longestSubarray(new int[]{8,4,2,7}, 4);
        assertEquals(2,i);
    }
}