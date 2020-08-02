package com.leetcode.problems;

import com.leetcode.problems.Util.ListNode;

import java.util.Arrays;
import java.util.List;

public class ReverseNodesInKGroups {
    public static void main(String[] args) {
        ReverseNodesInKGroups obj = new ReverseNodesInKGroups();
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        ListNode<Integer> a = null, c = null;
        for (int i : l) {
            if (a == null) {
                a = new ListNode<Integer>(i);
                c = a;
            } else {
                c.next = new ListNode<Integer>(i);
                c = c.next;
            }
        }
        obj.reverseNodesInKGroups(a, 2);
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        ListNode<Integer> dummy = new ListNode(-1);
        dummy.next = l;
        ListNode<Integer> start = dummy;
        int dis = 0;
        while (l != null) {
            dis++;
            if (dis % k == 0) {
                start = reverse(start, l.next);
                l = start.next;
            } else
                l = l.next;
        }
        return dummy.next;
    }

    ListNode<Integer> reverse(ListNode<Integer> start, ListNode<Integer> end) {
        ListNode<Integer> cur = start.next, pre = null, tail = cur;
        while (cur != end) {
            ListNode<Integer> temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }
        start.next = pre;
        tail.next = cur;
        return tail;
    }


}
