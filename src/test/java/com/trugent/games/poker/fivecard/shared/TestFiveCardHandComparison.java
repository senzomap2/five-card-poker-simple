package com.trugent.games.poker.fivecard.shared;


import com.trugent.games.poker.fivecard.cards.Card;
import com.trugent.games.poker.fivecard.cards.Rank;
import com.trugent.games.poker.fivecard.cards.Suit;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestFiveCardHandComparison {

    @Test
    public void testPairVsPair() {
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.TEN, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        final FiveCardPokerHand.Builder builder2 = new FiveCardPokerHand.Builder();

        builder2.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder2.addCard(Optional.of(new Card(Rank.J, Suit.D)));
        builder2.addCard(Optional.of(new Card(Rank.TEN, Suit.S)));
        builder2.addCard(Optional.of(new Card(Rank.J, Suit.C)));
        builder2.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand otherHand = builder2.build(5);
        final PokerHandComparator comparator = new PokerHandComparator();

        final int result = comparator.compare(hand, otherHand);

        assertEquals(result, 1);
    }

    @Test
    public void testTwoPairVsTwoPair() {
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.A, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        final FiveCardPokerHand.Builder builder2 = new FiveCardPokerHand.Builder();

        builder2.addCard(Optional.of(new Card(Rank.A, Suit.S)));
        builder2.addCard(Optional.of(new Card(Rank.A, Suit.D)));
        builder2.addCard(Optional.of(new Card(Rank.K, Suit.S)));
        builder2.addCard(Optional.of(new Card(Rank.K, Suit.C)));
        builder2.addCard(Optional.of(new Card(Rank.Q, Suit.H)));

        final FiveCardPokerHand otherHand = builder2.build(5);
        final PokerHandComparator comparator = new PokerHandComparator();

        final int result = comparator.compare(hand, otherHand);

        assertEquals(result, -1);
    }

    @Test
    public void testFlushVsFlush() {
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.NINE, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.K, Suit.S)));

        final FiveCardPokerHand hand = builder.build(5);

        final FiveCardPokerHand.Builder builder2 = new FiveCardPokerHand.Builder();

        builder2.addCard(Optional.of(new Card(Rank.TWO, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.NINE, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.FIVE, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.K, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.THREE, Suit.H)));

        final FiveCardPokerHand otherHand = builder2.build(5);
        final PokerHandComparator comparator = new PokerHandComparator();

        final int result = comparator.compare(hand, otherHand);

        assertEquals(result, 1);

    }

    @Test
    public void testSetOverSet() {
        //[TWO of D, TWO of C, TWO of S, FIVE of H, Q of S] vs
        //[THREE of D, EIGHT of D, EIGHT of C, EIGHT of S, NINE of D]
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.C)));
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.FIVE, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.S)));

        final FiveCardPokerHand hand = builder.build(5);

        final FiveCardPokerHand.Builder builder2 = new FiveCardPokerHand.Builder();
        builder2.addCard(Optional.of(new Card(Rank.THREE, Suit.D)));
        builder2.addCard(Optional.of(new Card(Rank.EIGHT, Suit.D)));
        builder2.addCard(Optional.of(new Card(Rank.EIGHT, Suit.C)));
        builder2.addCard(Optional.of(new Card(Rank.EIGHT, Suit.S)));
        builder2.addCard(Optional.of(new Card(Rank.NINE, Suit.D)));

        final FiveCardPokerHand otherHand = builder2.build(5);
        final PokerHandComparator comparator = new PokerHandComparator();
        final int result = comparator.compare(hand, otherHand);

        assertEquals(result, -1);

    }

    @Test
    public void testQuadsOverQuads() {
        //[TWO of D, TWO of C, TWO of H, TWO of S, EIGHT of D] vs
        //[SIX of D, SIX of C, SIX of H, SIX of S, NINE of H]

        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.C)));
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.EIGHT, Suit.S)));

        final FiveCardPokerHand hand = builder.build(5);

        final FiveCardPokerHand.Builder builder2 = new FiveCardPokerHand.Builder();
        builder2.addCard(Optional.of(new Card(Rank.SIX, Suit.D)));
        builder2.addCard(Optional.of(new Card(Rank.SIX, Suit.C)));
        builder2.addCard(Optional.of(new Card(Rank.SIX, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.SIX, Suit.S)));
        builder2.addCard(Optional.of(new Card(Rank.NINE, Suit.H)));

        final FiveCardPokerHand otherHand = builder2.build(5);
        final PokerHandComparator comparator = new PokerHandComparator();
        final int result = comparator.compare(hand, otherHand);
        assertEquals(result, -1);
    }

    @Test
    public void testHighCardvsHighCard() {
        final FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();

        builder.addCard(Optional.of(new Card(Rank.TWO, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.NINE, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.C)));
        builder.addCard(Optional.of(new Card(Rank.Q, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.K, Suit.H)));

        final FiveCardPokerHand hand = builder.build(5);

        final FiveCardPokerHand.Builder builder2 = new FiveCardPokerHand.Builder();

        builder2.addCard(Optional.of(new Card(Rank.FIVE, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.NINE, Suit.D)));
        builder2.addCard(Optional.of(new Card(Rank.J, Suit.C)));
        builder2.addCard(Optional.of(new Card(Rank.Q, Suit.H)));
        builder2.addCard(Optional.of(new Card(Rank.K, Suit.S)));

        final FiveCardPokerHand otherHand = builder2.build(5);
        final PokerHandComparator comparator = new PokerHandComparator();
        final int result = comparator.compare(hand, otherHand);

        assertEquals(result, -1);

    }

}
