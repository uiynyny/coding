package com.ood.blackjack;

import java.util.List;

public abstract class Gamer {
    private int mID;
    private String mName;
    private int mToken;
    private List<Card> mHandCard;
    private BlackJackStrategy mStrategy;
}
