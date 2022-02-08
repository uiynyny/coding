package com.leetcode.problems;

public class RegExp {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1])
                dp[0][i + 1] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // if pattern is . or p==s, then a match now and succeed prev result
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // pattern is *, look up prev p
                if (p.charAt(j) == '*') {
                    // prev p != s, then prev p + p is ignored. match current to current-2 char
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else // prev p == s or p is . a match happened, treat * as repeat more than one, repeat once, never repeat
                        dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegExp s = new RegExp();
        s.isMatch("aa", "a*");
    }
}
