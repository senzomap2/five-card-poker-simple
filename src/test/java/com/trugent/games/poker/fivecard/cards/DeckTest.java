package com.trugent.games.poker.fivecard.cards;

import java.util.Optional;
import java.util.Stack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SenzoM
 */
public class DeckTest {

    public DeckTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testEmptyDeck() {
        Deck deck = new Deck();
        Optional<Card> card = deck.deal();
        assertTrue(card.isEmpty());
    }

    @Test
    public void testDeal() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck();
        Optional<Card> card = deck.deal();
        assertTrue(card.isPresent());
    }

    @Test
    public void testShuffleDeck() {
        Deck deck = new Deck();
        deck.createDeck();
        Stack<Card> deckCards = deck.getDeckCards();
        Card peekCard1 = deckCards.peek();
        deck.shuffleDeck();
        Card peekCard2 = deckCards.peek();
        assertNotEquals(peekCard1, peekCard2);
    }

    @Test
    public void testUnshuffleDeck() {
        Deck deck = new Deck();
        deck.createDeck();
        Stack<Card> deckCards = deck.getDeckCards();
        Card peekCard1 = deckCards.peek();
        deck.shuffleDeck();
        Card peekCard2 = deckCards.peek();
        deck.unshuffleDeck();
        Card peekCard3 = deckCards.peek();
        assertEquals(peekCard1, peekCard3);
        assertNotEquals(peekCard1, peekCard2);
    }
    
    @Test
    public void testContains(){
        Card card = new Card(Rank.NINE, Suit.S);
        Deck deck = new Deck();
        deck.createDeck();
        boolean contains = deck.contains(card);
        assert contains==true;
    }
}
