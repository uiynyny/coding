package com.leetcode.problems;

import java.util.Arrays;
import java.util.List;

import com.leetcode.problems.util.ListNode;

class IsListPalindrome {
    // Singly-linked lists are already defined with this interface:


    public static void main(String[] args) {
        IsListPalindrome obj = new IsListPalindrome();
        List<Integer> l = Arrays.asList(1, 1000000000, -1000000000, -1000000000, 1000000000, 1);
        ListNode<Integer> h = new ListNode<>(0);
        ListNode<Integer> c=h;
        for(int i:l){
            c.next=new ListNode<>(i);
            c=c.next;
        }
        obj.isListPalindrome(h.next);
    }

    boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> slow = l, fast = l;
        // slow point to mid fast to end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast=l;
        while(fast!=null&&slow!=null){
            if(fast.value!=slow.value)return false;
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }

    ListNode<Integer> reverse(ListNode<Integer> cur) {
        ListNode<Integer> pre = null;
        while (cur != null) {
            ListNode<Integer> next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}