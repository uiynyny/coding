package com.leetcode.problems;

import java.util.Arrays;

public class BoardGame {
    public static void main(String[] args) {
        String[] b = new String[] { ".....A", "......", "..A...", "...B..", "......", "......" };
        String[] b1 = new String[] { "AAAA", "A.BA", "A..A", "AAAA" };
        String[] b2 = new String[] { "..", ".." };
        String[] b3 = new String[] { "BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB",
                ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.",
                ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...." };
        String[] b4 = new String[] { "..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBBA", "AABBBABABBAA", "...BABABABBA",
                "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A",
                "A..AAA.AAA.A" };
        String[] b5 = new String[] { "B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A",
                "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A" };

        BoardGame obj = new BoardGame();
        obj.solve(b);
        obj.solve(b1);
        obj.solve(b2);
        obj.solve(b3);
        obj.solve(b4);
        obj.solve(b5);
    }

    public int solve(String[] board) {
        int n = board.length;
        int center = n / 2;
        int[] result = new int[n / 2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                int row = i < center ? center - i - 1 : i - center;
                int col = j < center ? center - j - 1 : j - center;
                int layer = Math.max(row, col);
                if (board[i].charAt(j) == 'A')
                    result[layer]++;
                else if (board[i].charAt(j) == 'B')
                    result[layer]--;
            }
        }
        System.out.println(Arrays.toString(result));

        for (int j : result) {
            if (j != 0) {
                return j;
            }
        }
        return 0;
    }
}