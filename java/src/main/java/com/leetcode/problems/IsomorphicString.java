package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {
    public static void main(String[] args) {
        String a = "egg";
        String b = "add";
        IsomorphicString obj = new IsomorphicString();
        System.out.println(obj.isIsomerphic(a, b));
    }

    public boolean isIsomerphic(String a, String b) {
        if (a.length() != b.length())
            return false;

        // a -> b
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2)
                    return false;
            } else {
                map.put(c1, c2);
            }
        }
        // b->a, if there is any value in a mapped to the same char in b, this will fail
        HashSet<Character> set = new HashSet<>(map.values());
        return set.size() == map.values().size();
    }
}
