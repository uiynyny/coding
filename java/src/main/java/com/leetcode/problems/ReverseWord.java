package com.leetcode.problems;

/**
 * reverseWord
 */
public class ReverseWord {
    public static void main(String[] args) {
        String test = "the     sky is   blue";
        ReverseWord obj = new ReverseWord();
        System.out.println(obj.reverseWords(test));
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
        }
        // one more to reverse the last word
        reverse(arr, i, arr.length - 1);
        // reverse the whole string
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }

    void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}