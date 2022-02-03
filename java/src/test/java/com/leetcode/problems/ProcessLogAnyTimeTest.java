package com.leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessLogAnyTimeTest {

    @Test
    public void test() {
        ProcessLogAnyTime s = new ProcessLogAnyTime();
        int log = s.processLog("log", 6);
        assertEquals(4, log);
    }
}