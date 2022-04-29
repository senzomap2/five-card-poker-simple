package com.trugent.games.poker.fivecard.cards;
/**
 * The Rank enum. Can be extended to include Joker Wildcard 
 * @author SenzoM
 */
public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(11),
    Q(12),
    K(13),
    A(14);

    private final int rankValue;

    Rank(final int rankValue) {
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return this.rankValue;
    }
}
