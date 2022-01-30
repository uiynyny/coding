package com.leetcode.problems;/*
Given two adjacent screenshots, find the maximum possible overlap between them.
Implement : int maxOverlap(firstScreenshot, secondScreenshot)

for example:
firstScreenshot={{1,1,1},
{2,2,2},
{3,3,3}}
secondScreenshot={{2,2,2},
{3,3,3},
{4,4,4}}
maxOverlap(firstScreenshot, secondScreenshot) -> 2

firstScreenshot={{1,1,1},
{1,1,1},
{1,1,1}}
secondScreenshot={{1,1,1},
{1,1,1},
{1,1,1}}
maxOverlap(firstScreenshot, secondScreenshot) -> 3

firstScreenshot={{1,1,1},
{2,2,2},
{3,3,3}}
secondScreenshot={{1,1,1},
{2,2,2},
{4,4,4}}
maxOverlap(firstScreenshot, secondScreenshot) -> 0
*/

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class ScreenShot {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(ScreenShot.class.getName());
        int[][] firstScreenshot = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] secondScreenshot = {{2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        logger.info("" + maxOverlap(firstScreenshot, secondScreenshot));
    }

    public static int maxOverlap(int[][] pic1, int[][] pic2) {
        List<String> hashforPic1 = new ArrayList<>();
        List<String> hashforPic2 = new ArrayList<>();
        for (int i = 0; i < pic1.length; i++) {//{m,n} {x,y} m*n + x*y
            StringBuilder sb = new StringBuilder();
            //hash for pic1 row i
            for (int j = 0; j < pic1[i].length; j++) {
                sb.append(pic1[i][j]);
            }
            hashforPic1.add(sb.toString());
            //hash for pic2 row i
            sb = new StringBuilder();
            for (int j = 0; j < pic2[i].length; j++) {
                sb.append(pic2[i][j]);
            }
            hashforPic2.add(sb.toString());
        }
        Logger logger = Logger.getLogger(ScreenShot.class.getName());
        logger.info("" + hashforPic1);
        logger.info("" + hashforPic2);


//[111, 222, 333]
//.         [222, 333, 444]
        int matchedRow = 0;
        int pointerI = hashforPic1.size() - 1;
        while (pointerI >= 0) {
            int currentMatchedRow = 0;
            int j = 0;
            int i = pointerI;
            boolean isMatch = true;
            while (j < hashforPic2.size() && i < hashforPic1.size()) {
                if (!hashforPic1.get(i).equals(hashforPic2.get(j))) {
                    currentMatchedRow = 0;
                    pointerI--;
                    isMatch = false;
                    break;
                }
                currentMatchedRow++;
                isMatch = true;
                j++;
                i++;
            }
            if (isMatch) {
                matchedRow = Math.max(matchedRow, currentMatchedRow);
            } else {
                pointerI--;
            }
        }
        return matchedRow;
    }
}


