package com.trugent.games.poker.fivecard.shared;


import com.trugent.games.poker.fivecard.cards.Card;
import com.trugent.games.poker.fivecard.cards.Rank;
import com.trugent.games.poker.fivecard.cards.Suit;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestFiveCardHandIdentification {

    @Test
    public void testIdentifyPair() {

        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.TEN, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.PAIR);
    }

    @Test
    public void testIdentifyTwoPairs() {

        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.TEN, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.TEN, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.TWO_PAIR);
    }

    @Test
    public void testIdentifySet() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.TEN, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.SET);
    }

    @Test
    public void testIdentifyStraight() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.THREE, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.FOUR, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.FIVE, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.SIX, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.STRAIGHT);
    }

    @Test
    public void testIdentifyWheel() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.THREE, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.FOUR, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.FIVE, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.WHEEL);
    }

    @Test
    public void testIdentifyFlush() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.K, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.FIVE, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.SIX, Suit.S)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.FLUSH);
    }

    @Test
    public void testIdentifyFullHouse() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.K, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.K, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.C)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.FULL_HOUSE);
    }

    @Test
    public void testIdentifyFourOfAKind() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.K, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.C)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.D)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.FOUR_OF_A_KIND);
    }

    @Test
    public void testIdentifyStraightFlush() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.THREE, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.FOUR, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.FIVE, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.SIX, Suit.D)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.STRAIGHT_FLUSH);
    }

    @Test
    public void testIdentifyRoyalFlush() {
        
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.TEN, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.K, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.D)));

        final FiveCardPokerHand hand = builder.build(5);

        assertEquals(hand.getHandAnalyzer().getClassification().getClassificationRank(), ClassificationRank.ROYAL_FLUSH);
    }
    
}