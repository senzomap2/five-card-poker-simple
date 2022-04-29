package com.trugent.games.poker.fivecard.cards;
/**
 * The Suit enumerator. Represented by numbers 1: Diamonds, 2: Clubs, 3: Hearts,
 * 4: Spades. This is not relevant in the Poker game.
 * @author SenzoM
 */
public enum Suit {
    D(1),
    C(2),
    H(3),
    S(4);

    private final int suitValue;

    Suit(final int suitValue) {
        this.suitValue = suitValue;
    }

    public int getSuitValue() {
        return this.suitValue;
    }
}
