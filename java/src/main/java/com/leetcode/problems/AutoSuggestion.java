package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class AutoSuggestion {
    static class TrieNode {
        boolean isWord;
        List<String> word;
        TrieNode[] children;

        public TrieNode() {
            isWord = false;
            word = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    private TrieNode trie;

    AutoSuggestion(String[] words) {
        trie = new TrieNode();
        for (String w : words) {
            add(w);
        }
    }

    private void add(String word) {
        TrieNode root = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null)
                root.children[c - 'a'] = new TrieNode();
            root.word.add(word);
            root = root.children[c - 'a'];
        }
        root.isWord = true;
    }

    public List<String> query(String prefix) {
        TrieNode root = trie;
        for (char c : prefix.toCharArray()) {
            root = root.children[c - 'a'];
            if (root == null)
                return new ArrayList<>();
        }
        return root.word;
    }

    public static void main(String[] args) {
        String[] words = { "apple", "apply", "bake", "cake", "dog", "good", "google" };
        AutoSuggestion s = new AutoSuggestion(words);
        System.out.println(s.query("b"));
    }
}
