package models;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by ramcharan on 3/10/16.
 */
public class testDealerGame
{
    @Test
    public void testGameObjCreation()
    {
        dealerGame g = new dealerGame();
        assertNotNull(g);
    }

    @Test
    public void testIfRightObj()
    {
        dealerGame g = new dealerGame();
        assertThat(g,instanceOf(dealerGame.class));
    }

    @Test
    public void testScoreValues()
    {
        dealerGame g = new dealerGame();
        assertEquals(g.playerScore,0);
        assertEquals(g.dealerScore,0);
    }

    @Test
    public void testBuildDeck()
    {
        dealerGame g = new dealerGame();
        g.buildDeck();

        assertEquals(52,g.deck.size());
    }

    @Test
    public void testShuffle()
    {
        dealerGame g = new dealerGame();
        g.buildDeck();

        g.shuffle();

        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testInitialDeal()
    {
        dealerGame g = new dealerGame();
        g.buildDeck();
        g.shuffle();

        g.initialDeal();

        assertEquals(2,g.cols.get(0).size());
    }

    @Test
    public void testCustomInitialDeal()
    {
        dealerGame g = new dealerGame();
        String val1="A";
        String val2="9";

        g.cols.get(0).add(new Card(val1,Suit.Diamonds));
        g.playerValues.add(val1);

        g.cols.get(0).add(new Card(val2,Suit.Hearts));
        g.playerValues.add(val2);

        g.playerScore=g.getTotalScore(g.playerValues);

        assertEquals(20,g.playerScore);
    }
}
