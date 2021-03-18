package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class PairEvaluator extends Evaluator{

    public PairEvaluator(Evaluator nextEvaluator) {
        super(nextEvaluator);
    }
    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        if (Helper.findNumberOfPair(cards) == 1){
            return new WinCondition("Paire",600 + Helper.getHighestCardNotRepeated(cards));
        }else if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
