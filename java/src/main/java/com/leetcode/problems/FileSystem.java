package com.leetcode.problems;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {
    class File {
        boolean isFile = false;
        Map<String, File> files = new TreeMap<>();
        String content = "";
    }

    File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File t = root;
        List<String> res = new ArrayList<>();
        if (!path.equals("/")) {
            String[] p = path.split("/");
            for (String d : p) {
                t = t.files.get(d);
            }
            if (t.isFile) {
                res.add(p[p.length - 1]);
                return res;
            }
        }
        res.addAll(t.files.keySet());
        return res;
    }

    public void mkdir(String path) {
        File t = root;
        String[] p = path.split("/");// "/a/b"->"","a","b";
        for (int i=1;i<p.length;i++) {
            if (!t.files.containsKey(p[i]))
                t.files.put(p[i], new File());
            t = t.files.get(p[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] p = filePath.split("/");
        for (int i=1;i<p.length;i++) {
            if (!t.files.containsKey(p[i]))
                t.files.put(p[i], new File());
            t = t.files.get(p[i]);
        }
        t.isFile = true;
        t.content += content;
    }

    public String readContentFromFile(String filePath) {
        File t = root;
        String[] p = filePath.split("/");
        for (int i=1;i<p.length;i++) {
            if (!t.files.containsKey(p[i]))
                return "";
            t = t.files.get(p[i]);
        }
        return t.content;
    }

    /**
     * Your FileSystem object will be instantiated and called as such: FileSystem
     * obj = new FileSystem(); List<String> param_1 = obj.ls(path); obj.mkdir(path);
     * obj.addContentToFile(filePath,content); String param_4 =
     * obj.readContentFromFile(filePath);
     */
    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        List<String> param_1 = obj.ls("/");
        obj.mkdir("/a/b/c");
        obj.addContentToFile("/a/b/c/d","hello");
        obj.ls("/");
        String param_4 = obj.readContentFromFile("/a/b/c/d");
    }
}