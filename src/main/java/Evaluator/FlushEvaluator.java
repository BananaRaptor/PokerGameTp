package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class FlushEvaluator extends Evaluator{

    public FlushEvaluator(Evaluator nextEvaluator){
        super(nextEvaluator);
    }
    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        if (Helper.findNumberOfSameColor(cards) >= 5){
            ArrayList<Card> cardsOfFlush = Helper.findAllcardOfFlush(cards);
            return new WinCondition("Couleur",500 + cardsOfFlush.get(4).getValue() * 10 + cardsOfFlush.get(3).getValue() *  + cardsOfFlush.get(2).getValue() * 9 +  cardsOfFlush.get(1).getValue() * 8 +   cardsOfFlush.get(1).getValue() * 7);
        }else if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
