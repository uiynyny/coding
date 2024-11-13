import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LongestStringChain
 */
public class LongestStringChain {
    /**
     * @param words: the list of word.
     * @return: the length of the longest string chain.
     */
    public int longestStrChain(String[] words) {
        // dfs, find length of each sequence and get longest

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            result = Math.max(dfs(words, new HashSet<>(), words[i]), result);
        }
        return result;
    }

    private int dfs(String[] words, Set<String> seen, String cur) {
        seen.add(cur);
        int maxDepth = 1;
        for (String str : words) {
            int max = 0;
            if (!seen.contains(str) && str.length() == cur.length() + 1) {
                int p1 = 0;
                int p2 = 0;
                int diff = 0;
                while (p1 < cur.length() && p2 < str.length()) {
                    if (cur.charAt(p1) != str.charAt(p2)) {
                        diff++;
                        p2++;
                    } else {
                        p1++;
                        p2++;
                    }
                }
                if (diff > 1)
                    continue; // skip the word
                max = 1 + dfs(words, seen, str);
            }
            maxDepth = Math.max(maxDepth, max);
        }
        return maxDepth;
    }

    public int LongestStringChainDP(String[] words) {
        Arrays.sort(words);
        int[] dp = new int[words.length];
        int ans = 0;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }

    private boolean isConnected(String a, String b) {
        if (a.length() + 1 == b.length()) {
            int i = 0, j = 0;
            while (i < a.length() && j < b.length()) {
                if (a.charAt(i) == b.charAt(j))
                    i++;
                j++;
            }
            return i == a.length();
        }
        return false;
    }

    public static void main(String[] args) {
        LongestStringChain s = new LongestStringChain();
        String[] t = { "a", "ba", "abc", "adf" };
        int a = s.longestStrChain(t);
        System.out.println(a);
    }

}