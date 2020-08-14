package com.leetcode.problems;

import java.util.*;

public class FavoriteGenre {
    public static void main(String[] args) {
        Map<String, List<String>> userSongs=new HashMap<>();
        Map<String, List<String>> songGenres=new HashMap<>();
        userSongs.put("David",Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        songGenres.put("Rock",Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep",Arrays.asList("song7"));
        songGenres.put("Techno",Arrays.asList("song2", "song4"));
        songGenres.put("Pop",Arrays.asList("song5", "song6"));
        songGenres.put("Jazz",Arrays.asList("song8", "song9"));
        System.out.println(favorite(userSongs,songGenres));
    }

    public static Map<String,List<String>> favorite(Map<String,List<String>> userSongs,Map<String,List<String>> songGenres){
        // traverse and generate song to genre map;
        Map<String,String> songToGenre=new HashMap<>();
        for(String genre:songGenres.keySet()){
            List<String> songs=songGenres.get(genre);
            for(String song:songs)
                songToGenre.put(song, genre);
        }

        // traverse through users and count how many genre in their list
        Map<String,List<String>> res=new HashMap<>();
        for(String user:userSongs.keySet()){
            res.put(user,new LinkedList<>());
            List<String> songs=userSongs.get(user);
            Map<String,Integer> stat=new HashMap<>();
            int max=0;
            // loop songs and aggregae genre info to stat
            for(String song:songs){
                String gen=songToGenre.get(song);
                int count=stat.getOrDefault(gen, 0)+1;
                stat.put(gen,count);
                max=Math.max(count,max);
            }
            //loop stat to get the song genre with count >=max
            // List<String> cur_user_fav=new LinkedList<>();
            for(String g:stat.keySet()){
                int n=stat.get(g);
                if(n>=max){
                    res.get(user).add(g);
                }
            }
        }
        return res;
    }
}