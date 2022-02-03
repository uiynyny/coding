package com.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubarray {
    /* Longest continuous subarray with abs diff <= limit,
     * need to know first, second min, max.... monotonic queue required
     * when window expand, knowing current min and max and next min, max is a must
     */
    public int longestSubarray(int[] A, int l) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j = 0;
        for (j = 0; j < A.length; j++) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > l) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}
