package com.trugent.games.poker.fivecard.shared;

import com.trugent.games.poker.fivecard.cards.Card;

import java.util.SortedSet;
/**
 * source: https://github.com/amir650/MyCardGame/blob/master/src/com/cardgames/poker/fivecardpoker/
 * @author amir.afghani
 */
public interface HandAnalyzer {

    SortedSet<Card> getCards();

    Classification getClassification();

    RankGroup getRankGroup();

    SuitGroup getSuitGroup();

}
