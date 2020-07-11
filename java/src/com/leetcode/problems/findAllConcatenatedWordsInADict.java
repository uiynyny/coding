package com.leetcode.problems;
import java.util.LinkedList;
import java.util.List;

class findAllConcatenatedWordsInADict {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public String toString() {
            String r = "{isWord=" + isWord + " children=";
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    r += (char) (i + 'a') + " ";
                }
            }
            return r + "}";
        }
    }

    TrieNode root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        for (String w : words) {
            addWord(w, root);
        }
        List<String> result = new LinkedList<>();
        for (String w : words) {
            if (testWord(w, 0, root, 0)) {
                result.add(w);
            }
        }
        return result;
    }

    private boolean testWord(String w, int i, TrieNode cur, int count) {
        for (; i < w.length(); i++) {
            if (cur.children[w.charAt(i) - 'a'] == null)
                return false;
            if (cur.children[w.charAt(i) - 'a'].isWord) {
                if (i == w.length() - 1)
                    return count >= 1;
                if (testWord(w, i + 1, root, count + 1))
                    return true;
            }
            cur = cur.children[w.charAt(i) - 'a'];
        }
        return false;
    }

    private void addWord(String word, TrieNode root) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public static void main(String[] args) {
        String[] ss = new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat" };
        findAllConcatenatedWordsInADict find = new findAllConcatenatedWordsInADict();
        System.out.println(find.findAllConcatenatedWordsInADict(ss));
    }
}