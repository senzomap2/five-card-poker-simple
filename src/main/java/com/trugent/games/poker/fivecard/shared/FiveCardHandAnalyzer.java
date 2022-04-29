package com.trugent.games.poker.fivecard.shared;

import com.trugent.games.poker.fivecard.shared.SuitGroup;
import com.trugent.games.poker.fivecard.shared.PokerHandUtils;
import com.trugent.games.poker.fivecard.shared.RankGroup;
import com.trugent.games.poker.fivecard.shared.Classification;
import com.trugent.games.poker.fivecard.shared.HandAnalyzer;
import com.trugent.games.poker.fivecard.cards.Card;

import java.util.Collections;
import java.util.SortedSet;
/**
 * source: https://github.com/amir650/MyCardGame/blob/master/src/com/cardgames/poker/fivecardpoker/
 * @author amir.afghani
 */
public class FiveCardHandAnalyzer implements HandAnalyzer {

    private final SortedSet<Card> cards;
    private final Classification handClassification;
    private final RankGroup rankGroup;
    private final SuitGroup suitGroup;

    FiveCardHandAnalyzer(final SortedSet<Card> cards) {
        this.cards = Collections.unmodifiableSortedSet(cards);
        this.rankGroup = new RankGroup(this.cards);
        this.suitGroup = new SuitGroup(this.cards);
        this.handClassification = PokerHandUtils.classifyPokerHand(getRankGroup(), getSuitGroup(), getCards());
    }

    @Override
    public Classification getClassification() {
        return this.handClassification;
    }

    @Override
    public RankGroup getRankGroup() {
        return this.rankGroup;
    }

    @Override
    public SuitGroup getSuitGroup() {
        return this.suitGroup;
    }

    @Override
    public SortedSet<Card> getCards() {
        return this.cards;
    }

}
