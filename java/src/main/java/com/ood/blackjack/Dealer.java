package com.ood.blackjack;

public class Dealer extends Gamer {
    private BlackJackStrategy mStrategy = new DealerStrategy();
    private CardBox mCardBox;
}
