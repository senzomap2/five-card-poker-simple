package com.trugent.games.poker.fivecard.shared;

import com.trugent.games.poker.fivecard.cards.Card;
import com.trugent.games.poker.fivecard.cards.Rank;
import com.trugent.games.poker.fivecard.cards.Suit;
import java.util.Optional;
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
public class FiveCardPokerHandTest {
    
    public FiveCardPokerHandTest() {
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
    public void testHandSizeException(){
        FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();
        builder.addCard(Optional.of(new Card(Rank.NINE, Suit.S)));
        
        RuntimeException assertThrows = assertThrows(RuntimeException.class, ()->builder.build(5));
        assertNotNull(assertThrows.getMessage());
    }
    
    @Test
    public void testBuilderAdd(){
        FiveCardPokerHand.Builder builder = new FiveCardPokerHand.Builder();
        builder.addCard(Optional.of(new Card(Rank.NINE, Suit.S)));
        builder.addCard(Optional.of(new Card(Rank.EIGHT, Suit.D)));
        builder.addCard(Optional.of(new Card(Rank.J, Suit.S)));
        RuntimeException assertThrows = assertThrows(RuntimeException.class, ()->builder.build(3));
        assertNotNull(assertThrows.getMessage());
        builder.addCard(Optional.of(new Card(Rank.FIVE, Suit.H)));
        builder.addCard(Optional.of(new Card(Rank.NINE, Suit.C)));
        FiveCardPokerHand hand = builder.build(5);        
        assert hand!=null;       
    }
        
}
