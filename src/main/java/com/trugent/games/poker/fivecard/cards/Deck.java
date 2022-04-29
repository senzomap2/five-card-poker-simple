package com.trugent.games.poker.fivecard.cards;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;
/**
 * Deck Class. Responsible for creating and managing the deck of cards according
 * to Rank and Suit
 * @author SenzoM
 */
public class Deck {

    private Stack<Card> deckCards;

    /**
     * Creates the deck
     */
    public void createDeck() {
        deckCards = new Stack<>();
        for(final Suit suit : Suit.values()) {
            for(final Rank rank : Rank.values()) {
                deckCards.push(new Card(rank, suit));
            }
        }        
    }

    public Stack<Card> getDeckCards() {
        return deckCards;
    }
    /**
     * Shuffles using Collections shuffle method. Will create the deck if not
     * yet created 
     */
    protected void defaultShuffle(){
        if(deckCards==null){
            createDeck();
        }
        Collections.shuffle(deckCards);
    }
    /**
     * Sorts using collections sort method. Will create the deck if not yet created 
     */
    protected void defaultSort(){
        if(deckCards==null){
            createDeck();
        }
        Collections.sort(deckCards);
    }
    
    /**
     * shuffles the deck using the default collections shuffle. Can change this
     * to call another shuffling algorithm
     */
    public void shuffleDeck() {
        defaultShuffle();
    }

    /**
     * Re-sorts the deck back to original state using collections sort method.
     */
    public void unshuffleDeck() {
        defaultSort();
    }

    public int size() {
        return this.deckCards.size();
    }

    public boolean contains(final Card card) {
        return this.deckCards.contains(card);
    }

    /**
     * returns Optional of a card and removes the same from the stack. Returns
     * empty Optional if the stack is empty
     * @return 
     */
    public Optional<Card> deal() {
        return this.deckCards==null || this.deckCards.empty() ? Optional.empty() :
                Optional.of(this.deckCards.pop());
    }

}
