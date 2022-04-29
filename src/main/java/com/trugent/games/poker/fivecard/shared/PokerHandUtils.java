package com.trugent.games.poker.fivecard.shared;


import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

import com.trugent.games.poker.fivecard.cards.Card;
import com.trugent.games.poker.fivecard.cards.Rank;
import static com.trugent.games.poker.fivecard.cards.Rank.*;
import com.trugent.games.poker.fivecard.cards.Suit;
/**
 * source: https://github.com/amir650/MyCardGame/blob/master/src/com/cardgames/poker/fivecardpoker/
 * @author amir.afghani
 */
public enum PokerHandUtils {
;   //no instance
    public static final int TIE = 0;

    public static final List<Card> ROYAL_FLUSH_SPADES = Arrays.asList(new Card(Rank.A, Suit.S),
                                                                      new Card(Rank.K, Suit.S),
                                                                      new Card(Rank.Q, Suit.S),
                                                                      new Card(Rank.J, Suit.S),
                                                                      new Card(Rank.TEN, Suit.S));


    public static final List<Card> ROYAL_FLUSH_HEARTS = Arrays.asList(new Card(Rank.A, Suit.H),
                                                                      new Card(Rank.K, Suit.H),
                                                                      new Card(Rank.Q, Suit.H),
                                                                      new Card(Rank.J, Suit.H),
                                                                      new Card(Rank.TEN, Suit.H));

    public static final List<Card> ROYAL_FLUSH_CLUBS = Arrays.asList(new Card(Rank.A, Suit.C),
                                                                     new Card(Rank.K, Suit.C),
                                                                     new Card(Rank.Q, Suit.C),
                                                                     new Card(Rank.J, Suit.C),
                                                                     new Card(Rank.TEN, Suit.C));

    public static final List<Card> ROYAL_FLUSH_DIAMONDS = Arrays.asList(new Card(Rank.A, Suit.D),
                                                                        new Card(Rank.K, Suit.D),
                                                                        new Card(Rank.Q, Suit.D),
                                                                        new Card(Rank.J, Suit.D),
                                                                        new Card(Rank.TEN, Suit.D));

    public static final List<Card> STRAIGHT_WHEEL_SPADES = Arrays.asList(new Card(Rank.A, Suit.S),
                                                                         new Card(Rank.TWO, Suit.S),
                                                                         new Card(THREE, Suit.S),
                                                                         new Card(FOUR, Suit.S),
                                                                         new Card(FIVE, Suit.S));

    public static final List<Card> STRAIGHT_WHEEL_HEARTS = Arrays.asList(new Card(Rank.A, Suit.H),
                                                                         new Card(Rank.TWO, Suit.H),
                                                                         new Card(THREE, Suit.H),
                                                                         new Card(FOUR, Suit.H),
                                                                         new Card(FIVE, Suit.H));

    public static final List<Card> STRAIGHT_WHEEL_CLUBS = Arrays.asList(new Card(Rank.A, Suit.C),
                                                                        new Card(Rank.TWO, Suit.C),
                                                                        new Card(THREE, Suit.C),
                                                                        new Card(FOUR, Suit.C),
                                                                        new Card(FIVE, Suit.C));

    public static final List<Card> STRAIGHT_WHEEL_DIAMONDS = Arrays.asList(new Card(Rank.A, Suit.D),
                                                                           new Card(Rank.TWO, Suit.D),
                                                                           new Card(THREE, Suit.D),
                                                                           new Card(FOUR, Suit.D),
                                                                           new Card(FIVE, Suit.D));


    public static final List<Rank> STRAIGHT_TWO_TO_SIX = Arrays.asList(TWO, THREE, FOUR, FIVE, SIX);

    public static final List<Rank> STRAIGHT_THREE_TO_SEVEN = Arrays.asList(THREE, FOUR, FIVE, SIX, SEVEN);

    public static final List<Rank> STRAIGHT_FOUR_TO_EIGHT = Arrays.asList(FOUR, FIVE, SIX, SEVEN, EIGHT);

    public static final List<Rank> STRAIGHT_FIVE_TO_NINE = Arrays.asList(FIVE, SIX, SEVEN, EIGHT, NINE);

    public static final List<Rank> STRAIGHT_SIX_TO_TEN = Arrays.asList(SIX, SEVEN, EIGHT, NINE, TEN);

    public static final List<Rank> STRAIGHT_SEVEN_TO_JACK = Arrays.asList(SEVEN, EIGHT, NINE, TEN, J);

    public static final List<Rank> STRAIGHT_EIGHT_TO_QUEEN = Arrays.asList(EIGHT, NINE, TEN, J, Q);

    public static final List<Rank> STRAIGHT_NINE_TO_KING = Arrays.asList(NINE, TEN, J, Q, K);

    public static final List<Rank> STRAIGHT_TEN_TO_ACE = Arrays.asList(TEN, J, Q, K, A);

    public static void checkHandClassification(final Hand hand,
                                               final ClassificationRank classificationRank) {
        if(hand.getHandAnalyzer().getClassification().getClassificationRank() != classificationRank) {
            throw new RuntimeException("Hand : " +hand+ " does not match expected classificationRank " + classificationRank);
        }
    }

    public static Classification classifyPokerHand(final RankGroup rankGroup,
                                                   final SuitGroup suitGroup,
                                                   final SortedSet<Card> cards) {
        final PokerFiveHandClassifier handDetector = new PokerFiveHandClassifier(rankGroup, suitGroup, cards);
        return handDetector.classify();
    }
}
