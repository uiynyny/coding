package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supp = new HashSet<>();
        for (String s : supplies)
            supp.add(s);

        // in degree for food
        int[] in = new int[recipes.length];
        for (int i = 0; i < ingredients.size(); i++) {
            Set<String> ing = new HashSet<>(ingredients.get(i));
            for (String r : recipes) {
                if (ing.contains(r)) {
                    in[i]++;
                }
            }
        }

        // sort and generate
        Queue<Integer> q = new LinkedList<>();
        boolean[] seens = new boolean[recipes.length];
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.add(i);
                seens[i] = true;
            }
        }
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer recp = q.poll();
            if (supp.containsAll(ingredients.get(recp))) {
                res.add(recipes[recp]);
                supp.add(recipes[recp]);
                for (int i = 0; i < in.length; i++) {
                    if (ingredients.get(i).contains(recipes[recp])) {
                        in[i]--;
                    }
                    if (in[i] == 0 && !seens[i]){
                        q.add(i);
                        seens[i] = true;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllPossibleRecipes s = new FindAllPossibleRecipes();
        String[] recipes = { "bread", "sandwich", "burger" };
        String[] supplies = { "yeast", "flour", "meat" };
        List<List<String>> ingredients = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "meat"),
                Arrays.asList("sandwich", "meat", "bread"));
        s.findAllRecipes(recipes, ingredients, supplies);
    }
}
