package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class TextJustification {
    private static Logger logger = Logger.getLogger(TextJustification.class.getName());

    public static void main(String[] args) {
        TextJustification obj = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words1 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] words2 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        logger.info(obj.fullJustify(words, 16).toString());
        logger.info(obj.fullJustify(words1, 16).toString());
        logger.info(obj.fullJustify(words2, 20).toString());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        Deque<String> row = new LinkedList<>();
        int wordLength = 0;
        int space = 0;
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            if (wordLength + space + words[i].length() > maxWidth) {
                res.add(compileLine(maxWidth, row, wordLength));
                wordLength = space = 0;
            } else {
                wordLength += words[i].length();
                space += 1;
                row.add(words[i]);
                i++;
            }
        }
        res.add(compileLine2(maxWidth, row));
        return res;
    }

    private String compileLine(int maxWidth, Deque<String> row, int wordLength) {
        int spaces = maxWidth - wordLength;
        int spacePlace = row.size() - 1;
        StringBuilder sb = new StringBuilder();
        while (!row.isEmpty()) {
            sb.append(row.removeFirst());
            if (spacePlace == 0) spacePlace = 1;
            int curSpace = spaces / spacePlace + (spaces % spacePlace > 0 ? 1 : 0);
            for (int k = 0; k < curSpace; k++) sb.append(" ");
            spaces -= curSpace;
            spacePlace -= 1;
        }
        return sb.toString();
    }

    private String compileLine2(int maxWidth, Deque<String> row) {
        StringBuilder sb = new StringBuilder();
        while (!row.isEmpty()) {
            sb.append(row.removeFirst());
            if (sb.length() < maxWidth) sb.append(" ");
        }
        while (sb.length() < maxWidth) sb.append(" ");
        return sb.toString();
    }
}
