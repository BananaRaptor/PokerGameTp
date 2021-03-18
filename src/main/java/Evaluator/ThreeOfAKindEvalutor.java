package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class ThreeOfAKindEvalutor extends Evaluator{

    public ThreeOfAKindEvalutor(Evaluator nextEvaluator){
        super(nextEvaluator);
    }
    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        if (Helper.findIfRepetitionIsPresent(cards,3)){
            return new WinCondition("Brelan",1000 + Helper.getHighestCardNotRepeated(cards) * 10);
        }else if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
