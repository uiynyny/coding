package com.leetcode.problems;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessLogAnyTime {
    public int processLog(String filename,int t) {
        List<int[]> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(getClass().getClassLoader().getResource(filename).toURI())))) {
            String s = br.readLine();
            while (s != null) {
                String[] s1 = s.split(" ");
                int start = Integer.parseInt(s1[0]);
                int end = Integer.parseInt(s1[1]);
                res.add(new int[]{start, end});
                s = br.readLine();
            }
            Collections.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count=0;
        for(int[] log: res){
            if(log[0]<=t && t<=log[1]){
                count++;
            }
        }
        return count;
    }
}
