package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class FourOfAKindEvaluator extends Evaluator{

    public FourOfAKindEvaluator(Evaluator nextEvaluator){
        super(nextEvaluator);
    }
    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        if (Helper.findIfRepetitionIsPresent(cards,4)){
            return new WinCondition("Carré",  1800 + Helper.getHighestCardNotRepeated(cards));
        }else if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
