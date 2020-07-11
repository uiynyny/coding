package com.leetcode.problems;

public class MiddleStack {

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int v) {
            val = v;
        }

        Node() {
        };
    }

    private Node head;
    private Node mid;
    int count;

    public MiddleStack() {
        head = null;
        mid = null;
        count = 0;
    }

    public void push(int val) {
        // create new node
        Node t = new Node(val);
        t.next = head;
        // assign t ->head
        count++;

        // if stack is empty then mid is current one
        if (count == 1)
            mid = t;
        else {// assign t<-head and update mid if len is odd
            head.prev = t;
            if (count % 2 == 1) {
                mid = mid.prev;
            }
        }
        head = t;
    }

    public int pop() {
        if (count == 0)
            return -1;
        Node pop = head;
        head = head.next;
        count--;
        if (count % 2 == 0) {
            mid = mid.next;
        }
        return pop.val;
    }

    public int getMid() {
        return mid==null ? -1:mid.val;
    }

    public int removeMid() {
        if (count == 0)
            return -1;

        // retrieve mid value
        int ret = mid.val;

        Node pre = mid.prev;
        Node nex = mid.next;

        if (count == 1) {
            head = null;
            mid = null;
        } else if (count <= 2) {
            pre.next = mid.next;
        } else {
            // remove mid node
            pre.next = mid.next;
            nex.prev = mid.prev;
        }
        count--;
        // if current size is odd, then move mid pointer -1
        if (count % 2 == 1) {
            mid = pre;
        } else {// even +1
            mid = nex;
        }
        return ret;
    }

    public static void main(String[] args) {
        MiddleStack s = new MiddleStack();
        s.push(1);
        s.push(2);
        int a = s.removeMid();
        a = s.removeMid();
        a = s.pop();
        s.push(11);
        a = s.getMid();
        a = s.pop();
        a = s.pop();
        a = s.pop();
    }
}