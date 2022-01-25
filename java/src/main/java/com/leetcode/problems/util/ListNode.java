package com.leetcode.problems.util;

public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode(T x) {
        value = x;
    }

    @Override
    public String toString() {
        String nvalue = next == null ? "" : next.value.toString();
        return "ListNode{" + "value=" + value + ", next=" + nvalue + '}';
    }
}
