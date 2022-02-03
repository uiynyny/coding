package com.leetcode.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindAllPossibleRecipeTest {

    @Test
    public void test() {
        FindAllPossibleRecipe s = new FindAllPossibleRecipe();
        String[] recipes = {"burger", "sandwich", "bread"};
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("sandwich", "meat", "bread"),
                Arrays.asList("bread", "meat"),
                Arrays.asList("yeast", "flour"));
        String[] sup = {"yeast", "flour", "meat"};
        s.findAllRecipes(recipes, lists, sup);
    }
}