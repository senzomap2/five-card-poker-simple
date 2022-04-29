package com.trugent.games.poker.fivecard.play;

import com.trugent.games.poker.fivecard.shared.FiveCardPokerHand;
import com.trugent.games.poker.fivecard.cards.Card;
import com.trugent.games.poker.fivecard.cards.Deck;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

/**
 *
 * @author SenzoM
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        final Deck deck = new Deck();
        deck.shuffleDeck();
        // set hand size. Game can be extended to include other variants of Poker
        int handSize = 5;

        // specifically for the five hand Poker
        FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();
        for (int i = 0; i < handSize; i++) {
            Optional<Card> deal = deck.deal();
            Card card = deal.get();
            // if for some reason we can display UTF-8 characters. Most likely
            // on the web
            card.setUtf8Suit(true);
            builder.addCard(deal);
        }

        final FiveCardPokerHand hand = builder.build(handSize);
        System.out.println("Your hand: " + hand.getHandAnalyzer().getCards());
        System.out.println(hand.getHandAnalyzer().getClassification().getClassificationRank().toString().replace("_", " "));

    }

}
