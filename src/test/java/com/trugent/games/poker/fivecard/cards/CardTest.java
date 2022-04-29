package com.trugent.games.poker.fivecard.cards;

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
public class CardTest {

    public CardTest() {
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
    public void testGetRank() {
        Card card = new Card(Rank.NINE, Suit.S);
        Rank rank = card.getRank();
        assert rank==Rank.NINE;
    }
    
    @Test
    public void testGetSuit(){
        Card card = new Card(Rank.NINE, Suit.S);
        Suit suit = card.getSuit();
        assert suit==Suit.S;
    }
    
    @Test
    public void testToString(){
        Card card = new Card(Rank.NINE, Suit.S);
        String expected = "9S";
        assertEquals(expected, card.toString());
    }
    
    @Test
    public void testEquals(){
        Card card1 = new Card(Rank.NINE, Suit.S);
        Card card2 = new Card(Rank.NINE, Suit.S);
        assertEquals(card1, card2);
    }
    
    @Test
    public void testCompareTo(){
        Card card1 = new Card(Rank.NINE, Suit.S);
        Card card2 = new Card(Rank.A, Suit.S);
        assert card1.compareTo(card2)<0;
    }
}
