package com.trugent.games.poker.fivecard.cards;

/**
 *
 * @author SenzoM
 */
public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;
    private boolean utf8Suit;

    public boolean isUtf8Suit() {
        return utf8Suit;
    }

    public void setUtf8Suit(boolean utf8Suit) {
        this.utf8Suit = utf8Suit;
    }
        
    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Card(final Rank rank,
            final Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.utf8Suit=false;
    }

    /**
     * Suit can be represented in UTF8
     *
     * @param utf8
     * @return
     */
    public String getSuit(boolean utf8) {
        String suitString = null;
        if (utf8 && null != this.suit) {
            switch (this.suit) {
                case C -> suitString = "♣"; // could be written in UTF8 as \u2663
                case D -> suitString = "♦"; // could be written in UTF8 as \u2666
                case H -> suitString = "♥"; // could be written in UTF8 as \u2665
                case S -> suitString = "♠"; // could be written in UTF8 as \u2660
                default -> {
                }

            }
        }else{
            return this.suit.toString();
        }
        return suitString;
    }

    @Override
    public String toString() {
        String card = "";
        switch (this.rank) {
            case Q, K, J, A ->
                card += this.rank;
            default ->
                card += this.rank.getRankValue();
        }
        card = card + this.getSuit(this.utf8Suit);
        return card;
    }

    @Override
    public int compareTo(final Card o) {
        final int rankComparison = Integer.compare(this.rank.getRankValue(), o.rank.getRankValue());
        return rankComparison != 0 ? rankComparison : Integer.compare(this.suit.getSuitValue(), o.suit.getSuitValue());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Card card = (Card) o;
        return this.rank == card.rank && this.suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = this.rank != null ? this.rank.hashCode() : 0;
        result = 31 * result + (this.suit != null ? this.suit.hashCode() : 0);
        return result;
    }

}
