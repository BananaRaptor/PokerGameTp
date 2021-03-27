package Evaluator;

import Cards.Card;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EvaluatorTest {

    @Test
    public void royalFlushTest(){
        ArrayList<Card> royalFlush = new ArrayList<>();
        royalFlush.add(new Card(7,"Diamonds","7 de carreau"));
        royalFlush.add(new Card(9,"Diamonds","9 de carreau"));
        royalFlush.add(new Card(10,"Diamonds","10 de carreau"));
        royalFlush.add(new Card(11,"Diamonds","Valet de carreau"));
        royalFlush.add(new Card(12,"Diamonds","Reine de carreau"));
        royalFlush.add(new Card(13,"Diamonds","Roi de carreau"));
        royalFlush.add(new Card(14,"Diamonds","Ace de carreau"));
        WinCondition expectedResult = new WinCondition("Quinte Flush Royale",2000);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(royalFlush);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void straightFlushTest(){
        ArrayList<Card> StraightFlush = new ArrayList<>();
        StraightFlush.add(new Card(2,"Diamonds","2 de carreau"));
        StraightFlush.add(new Card(2,"Heart","2 de coeur"));
        StraightFlush.add(new Card(9,"Diamonds","9 de carreau"));
        StraightFlush.add(new Card(10,"Diamonds","10 de carreau"));
        StraightFlush.add(new Card(11,"Diamonds","valet de carreau"));
        StraightFlush.add(new Card(12,"Diamonds","reine de coeur"));
        StraightFlush.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Quinte Flush",1913);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(StraightFlush);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void fourOfAKindTest(){
        ArrayList<Card> fourOfAKind = new ArrayList<>();
        fourOfAKind.add(new Card(2,"Diamonds","2 de carreau"));
        fourOfAKind.add(new Card(2,"Heart","2 de coeur"));
        fourOfAKind.add(new Card(2,"club","2 de trefle"));
        fourOfAKind.add(new Card(2,"spade","2 de pique"));
        fourOfAKind.add(new Card(11,"Diamonds","valet de carreau"));
        fourOfAKind.add(new Card(12,"Diamonds","reine de coeur"));
        fourOfAKind.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Carré",1813);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(fourOfAKind);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void fullHouseTest(){
        ArrayList<Card> fullHouse = new ArrayList<>();
        fullHouse.add(new Card(2,"Diamonds","2 de carreau"));
        fullHouse.add(new Card(2,"Heart","2 de coeur"));
        fullHouse.add(new Card(2,"club","2 de trefle"));
        fullHouse.add(new Card(3,"spade","3 de pique"));
        fullHouse.add(new Card(3,"Diamonds","3 de carreau"));
        fullHouse.add(new Card(12,"Diamonds","reine de coeur"));
        fullHouse.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Main pleine",1723);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(fullHouse);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void flushTest(){
        ArrayList<Card> flush = new ArrayList<>();
        flush.add(new Card(2,"Diamonds","2 de carreau"));
        flush.add(new Card(3,"Diamonds","3 de carreau"));
        flush.add(new Card(5,"Diamonds","5 de carreau"));
        flush.add(new Card(6,"Diamonds","6 de carreau"));
        flush.add(new Card(10,"spade","10 de pique"));
        flush.add(new Card(12,"Diamonds","reine de coeur"));
        flush.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Couleur",1353);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(flush);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void straightTest(){
        ArrayList<Card> straight = new ArrayList<>();
        straight.add(new Card(2,"Diamonds","2 de carreau"));
        straight.add(new Card(3,"Heart","3 de coeur"));
        straight.add(new Card(4,"club","4 de trefle"));
        straight.add(new Card(5,"spade","5 de pique"));
        straight.add(new Card(6,"Diamonds","6 de carreau"));
        straight.add(new Card(12,"Diamonds","reine de coeur"));
        straight.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Quinte",1206);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(straight);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void straightPairTest(){
        ArrayList<Card> straight = new ArrayList<>();
        straight.add(new Card(2,"Spade","2 de trefle"));
        straight.add(new Card(2,"Diamonds","2 de carreau"));
        straight.add(new Card(3,"Heart","3 de coeur"));
        straight.add(new Card(4,"club","4 de trefle"));
        straight.add(new Card(5,"spade","5 de pique"));
        straight.add(new Card(6,"Diamonds","6 de coeur"));
        straight.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Quinte",1206);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(straight);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void straightAceTest(){
        ArrayList<Card> straight = new ArrayList<>();
        straight.add(new Card(2,"Spade","2 de trefle"));
        straight.add(new Card(3,"Heart","3 de coeur"));
        straight.add(new Card(4,"club","4 de trefle"));
        straight.add(new Card(6,"club","6 de trefle"));
        straight.add(new Card(12,"spade","reine de pique"));
        straight.add(new Card(13,"Diamonds","roi de coeur"));
        straight.add(new Card(14,"Diamonds","arce de carreau"));
        WinCondition expectedResult = new WinCondition("Quinte",1204);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(straight);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void threeOfAKindTest(){
        ArrayList<Card> threeOfAKind = new ArrayList<>();
        threeOfAKind.add(new Card(2,"Diamonds","2 de carreau"));
        threeOfAKind.add(new Card(2,"Heart","2 de coeur"));
        threeOfAKind.add(new Card(2,"club","2 de trefle"));
        threeOfAKind.add(new Card(5,"spade","5 de pique"));
        threeOfAKind.add(new Card(6,"Diamonds","6 de carreau"));
        threeOfAKind.add(new Card(12,"Diamonds","reine de coeur"));
        threeOfAKind.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult =  new WinCondition("Brelan", 1130);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(threeOfAKind);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }
    @Test
    public void twoPairTest(){
        ArrayList<Card> twoPair = new ArrayList<>();
        twoPair.add(new Card(2,"Diamonds","2 de carreau"));
        twoPair.add(new Card(2,"Heart","2 de coeur"));
        twoPair.add(new Card(5,"club","5 de trefle"));
        twoPair.add(new Card(5,"spade","5 de pique"));
        twoPair.add(new Card(6,"Diamonds","6 de carreau"));
        twoPair.add(new Card(12,"Diamonds","reine de coeur"));
        twoPair.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Double Paire",813);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(twoPair);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void pairTest(){
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(2,"Diamonds","2 de carreau"));
        pair.add(new Card(2,"Heart","2 de coeur"));
        pair.add(new Card(3,"club","3 de trefle"));
        pair.add(new Card(5,"spade","5 de pique"));
        pair.add(new Card(6,"Diamonds","6 de carreau"));
        pair.add(new Card(12,"Diamonds","reine de coeur"));
        pair.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Paire", 613);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(pair);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }

    @Test
    public void highCardTest(){
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(2,"Diamonds","2 de carreau"));
        pair.add(new Card(3,"club","3 de trefle"));
        pair.add(new Card(5,"spade","5 de pique"));
        pair.add(new Card(6,"Diamonds","6 de carreau"));
        pair.add(new Card(8,"Heart","8 de coeur"));
        pair.add(new Card(12,"Diamonds","reine de coeur"));
        pair.add(new Card(13,"Diamonds","roi de carreau"));
        WinCondition expectedResult = new WinCondition("Hauteur", 13);
        WinCondition actualResult = (new ChainOfEvaluator()).evaluate(pair);
        assertEquals(expectedResult.getResult(), actualResult.getResult());
    }




}
