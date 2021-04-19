package com.leetcode.problems;

import java.util.Arrays;
import java.util.List;

import com.leetcode.problems.util.ListNode;

public class AddTwoHugeNumbers {
    public static void main(String[] args) {
        AddTwoHugeNumbers obj = new AddTwoHugeNumbers();
        List<Integer> aa = Arrays.asList(9876, 5432, 1999);
        List<Integer> ba = Arrays.asList(1, 8001);
        ListNode<Integer> a = null;
        ListNode<Integer> b = null;
        ListNode<Integer> c = null;
        for (int i : aa) {
            if (a == null) {
                a = new ListNode<Integer>(i);
                c = a;
            } else {
                c.next = new ListNode<Integer>(i);
                c = c.next;
            }
        }

        for (int i : ba) {
            if (b == null) {
                b = new ListNode<Integer>(i);
                c = b;
            } else {
                c.next = new ListNode<Integer>(i);
                c = c.next;
            }
        }
        obj.addTwoHugeNumbers(a, b);
    }

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> ra = reverseList(a);
        ListNode<Integer> rb = reverseList(b);
        ListNode<Integer> ans = new ListNode(0);
        ListNode<Integer> cur = ans;
        int carry = 0;
        while (ra != null || rb != null || carry != 0) {
            int sum = carry;
            if(ra!=null){
                sum+=ra.value;
                ra=ra.next;
            }
            if(rb!=null){
                sum+=rb.value;
                rb=rb.next;
            }
            carry = sum / 10000;
            cur.next = new ListNode<Integer>(sum % 10000);
            cur = cur.next;
        }
        return ans;
    }

    ListNode<Integer> reverseList(ListNode<Integer> head) {
        ListNode<Integer> pre = null, cur = head;
        while (cur != null) {
            ListNode<Integer> next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
