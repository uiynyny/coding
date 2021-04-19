package com.leetcode.problems;

class PokerGame {

    public static void main(String[] args) {
        PokerGame obj = new PokerGame();
        int[] cards = new int[] { 2, 2, 2, 3, 4, 5, 7, 1 };
        int[] cards1 = new int[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 };
        int ans = obj.getAns(cards1);
        System.out.println(ans);
    }

    private int count = 9;
    private int straight = 5;
    private int min = Integer.MAX_VALUE;

    public int getAns(int[] cards) {
        int[] deck = new int[count];
        for (int f : cards)
            deck[f - 1]++;
        dfs(deck, 0);
        return min;
    }

    void dfs(int[] cards, int step) {
        // find the length of a straight
        int start = 0, end = 0;
        for (end = 0; end < cards.length; end++) {
            if (cards[end] == 0) {
                start = end;
            }
            if (end - start + 1 >= straight)
                break;
        }

        // theres no straight > minimal require
        if (end - start + 1 < straight) {
            int multipleOftheSame = 0;
            for (int i = 0; i < cards.length; i++) {
                if (cards[i] != 0)
                    multipleOftheSame++;
            }
            min = Math.min(min, step + multipleOftheSame);
            return;
        }
        // find all straight and try to play the card
        A: for (int i = 0; i <= cards.length - straight; i++) {
            int j = i;
            int len = 0;
            // find the length of a straight
            for (; j < cards.length; j++) {
                // current card is missing and current straight length < require
                if (cards[j] == 0 && j - i < straight)
                    continue A;
                // current card is missing and current straight >= require
                if (cards[j] == 0) {
                    len = j - i;
                    break;
                // this is the last card, update length of card
                } else if (j == cards.length - 1) {
                    len = j - i + 1;
                }
            }

            while (len > straight - 1) {
                for (int k = i; k < i + len; k++)
                    cards[k]--;
                dfs(cards, 1 + step);
                for (int k = i; k < i + len; k++)
                    cards[k]++;
                len--;
            }
        }
    }
}