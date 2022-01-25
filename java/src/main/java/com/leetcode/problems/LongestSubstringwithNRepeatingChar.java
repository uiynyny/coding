package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringwithNRepeatingChar {
    public static void main(String[] args) {
        LongestSubstringwithNRepeatingChar o = new LongestSubstringwithNRepeatingChar();
        System.out.println(o.solve("aabbabac", 4));
    }

    public int solve(String s, int n) {
        int ans = 0;
        // for (int unique = 1; unique <= 26; unique++) {
        //     ans = Math.max(ans, longestSubstringwithNRepeatingChar(s, n, unique));
        // }
        return longestSubstring(s, n);
        // return ans;
    }


    private int longestSubstring(String s, int k) {
        // char -> int
        HashMap<Character, Integer> count = new HashMap<>();
        // count the number of appearance of each char
        for (char c : s.toCharArray())
            count.put(c, count.getOrDefault(c, 0) + 1);

        // count char appear less than k
        HashSet<Character> lessThanK = new HashSet<>();
        for (Map.Entry<Character, Integer> c : count.entrySet()) {
            if (c.getValue() < k) {
                lessThanK.add(c.getKey());
            }
        }
        // all char in current s longer than k
        if (lessThanK.isEmpty())
            return s.length();

        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (lessThanK.contains(c)) {// c appear less than k times
                // i!=j try if s(i,j) is valid or not
                if (i != j)
                    max = Math.max(max, longestSubstring(s.substring(i, j), k));
                // update i pointer to j+1
                i = j + 1;
            }
            j++;
        }
        // j reached the end and update max
        if (i != j)
            max = Math.max(max, longestSubstring(s.substring(i, j), k));
        return max;
    }

    private int longestSubstringwithNRepeatingChar(String s, int k, int unique) {
        int[] map = new int[128];
        int numUnique = 0;
        int numNoLessK = 0;
        int begin = 0;
        int end = 0;
        int ans = 0;
        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0)
                numUnique++;
            if (map[s.charAt(end++)] == k)
                numNoLessK++;

            while (numUnique > unique) {
                if (map[s.charAt(begin)]-- == k)
                    numNoLessK--;
                if (map[s.charAt(begin++)] == 0)
                    numUnique--;
            }
            if (unique == numNoLessK)
                ans = Math.max(end - begin, ans);
        }
        return ans;
    }

}
