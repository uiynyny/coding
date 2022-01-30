package com.leetcode.problems;// find all the number needs underline indicator from 1 - 650
// solve(1,650) -> {6,9,16,18,19,61,66,68,86,89....}  exception 1 6 8 9  isValid(68)->true reverse(68)->89 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        Map<Integer, Integer> reversableDigit = new HashMap<>();
        reversableDigit.put(0, 0);
        reversableDigit.put(1, 1);
        reversableDigit.put(6, 9);
        reversableDigit.put(8, 8);
        reversableDigit.put(9, 6);

        logger.info("" + underLinedNumbers(1, 650, reversableDigit));
    }

    public static List<Integer> underLinedNumbers(int begin, int end, Map<Integer, Integer> map) {
        List<Integer> result = new ArrayList<>();
        for (int i = begin; i <= end; i++) {//O(n*2*m)
            if (isReversable(i, map)) {//O(m)
                int reversedNum = reverse(i, map);//o(m)
                if (reversedNum == i || String.valueOf(reversedNum).length() != String.valueOf(i).length() || reversedNum > end) {
                    continue;
                }
                result.add(i);
            }
        }
        return result;
    }

    //O(m)
    public static boolean isReversable(int num, Map<Integer, Integer> map) {
        while (num != 0) {
            int lsd = num % 10;
            num /= 10;
            if (!map.containsKey(lsd)) {
                return false;
            }
        }
        return true;
    }

    //8619 -> 6198
    //O(m)
    public static int reverse(int num, Map<Integer, Integer> map) {
        int result = 0;
        while (num != 0) {
            int lsd = num % 10;
            int currentDigit = map.get(lsd);
            result = result * 10 + currentDigit;
            num /= 10;
        }
        return result;
    }
}
