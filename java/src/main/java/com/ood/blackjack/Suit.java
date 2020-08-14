package com.ood.blackjack;

public enum Suit {
    Club(0),
    Diamond(1),
    Spade(2),
    Heart(3);

    private final int mValue;
    private Suit(int value){
        mValue=value;
    }

    public int getmValue() {
        return mValue;
    }

    public static Suit getSuitFromValue(int value){
        switch(value){
            case 0: return Suit.Club;
            case 1: return Suit.Diamond;
            case 2: return Suit.Spade;
            case 3: return Suit.Heart;
            default: return null;
        }
    }
}
