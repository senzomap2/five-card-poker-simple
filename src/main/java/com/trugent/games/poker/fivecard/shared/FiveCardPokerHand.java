package com.trugent.games.poker.fivecard.shared;


import com.trugent.games.poker.fivecard.shared.Hand;
import com.trugent.games.poker.fivecard.cards.Card;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * source: https://github.com/amir650/MyCardGame/blob/master/src/com/cardgames/poker/fivecardpoker/
 * @author amir.afghani
 */
public class FiveCardPokerHand implements Hand {

    private final FiveCardHandAnalyzer handAnalyzer;

    private int handSize;

    FiveCardPokerHand(final Builder builder) {
        this.handAnalyzer = new FiveCardHandAnalyzer(builder.cards);
    }

    public FiveCardPokerHand(final Builder builder, int handSize) {
        this.handSize=handSize;
        this.handAnalyzer = new FiveCardHandAnalyzer(builder.cards);
    }
    
    
    @Override
    public FiveCardHandAnalyzer getHandAnalyzer() {
        return this.handAnalyzer;
    }

    @Override
    public String toString() {
        return this.getHandAnalyzer().getCards().toString();
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    public static class Builder {

        private SortedSet<Card> cards;

        public Builder() {
            this.cards = new TreeSet<>();
        }

        public Builder addCard(final Optional<Card> card) {
            this.cards.add(card.orElseThrow(IllegalStateException::new));
            return this;
        }

        public FiveCardPokerHand build(int size) {
            if (this.cards.size() != size) {
                throw new RuntimeException("Invalid hand size for hand " + this.cards.toString());
            }
            return new FiveCardPokerHand(this);
        }

    }
}
