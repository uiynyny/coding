package com.leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeQueryTreeTest {

    @Test
    public void test(){
        /*    5
        *   2   4
        * a b  c 3
        *       d ef*/
        RangeQueryTree r=new RangeQueryTree();
        RangeQueryTree.Node n1=new RangeQueryTree.Node(1,new char[]{'a'});
        RangeQueryTree.Node n2=new RangeQueryTree.Node(1,new char[]{'b'});
        RangeQueryTree.Node n3=new RangeQueryTree.Node(1,new char[]{'c'});
        RangeQueryTree.Node n4=new RangeQueryTree.Node(1,new char[]{'d'});
        RangeQueryTree.Node n5=new RangeQueryTree.Node(2,new char[]{'e','f'});
        RangeQueryTree.Node n6=new RangeQueryTree.Node(3);
        RangeQueryTree.Node n7=new RangeQueryTree.Node(2);
        RangeQueryTree.Node n8=new RangeQueryTree.Node(4);
        RangeQueryTree.Node n9=new RangeQueryTree.Node(6);
        RangeQueryTree.Tree t1=new RangeQueryTree.Tree(n1);
        RangeQueryTree.Tree t2=new RangeQueryTree.Tree(n2);
        RangeQueryTree.Tree t3=new RangeQueryTree.Tree(n3);
        RangeQueryTree.Tree t4=new RangeQueryTree.Tree(n4);
        RangeQueryTree.Tree t5=new RangeQueryTree.Tree(n5);
        RangeQueryTree.Tree t6=new RangeQueryTree.Tree(n6);
        RangeQueryTree.Tree t7=new RangeQueryTree.Tree(n7);
        RangeQueryTree.Tree t8=new RangeQueryTree.Tree(n8);
        RangeQueryTree.Tree t9=new RangeQueryTree.Tree(n9);
        t9.left=t7;
        t9.right=t8;
        t7.left=t1;
        t7.right=t2;
        t8.left=t3;
        t8.right=t6;
        t6.left=t4;
        t6.right=t5;

        char nthChar = r.findNthChar(t9, 6);
        assertEquals('f',nthChar);
    }
}