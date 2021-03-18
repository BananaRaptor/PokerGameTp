package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class TwoPairEvaluator extends Evaluator{

    public TwoPairEvaluator(Evaluator nextEvaluator) {
        super(nextEvaluator);
    }

    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        if (Helper.findNumberOfPair(cards) == 2){
            return new WinCondition("Double Paire", 800 + Helper.getHighestCardNotRepeated(cards));
        }else if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
