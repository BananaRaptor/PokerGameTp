package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class FullHouseEvaluator extends Evaluator{
    public FullHouseEvaluator(Evaluator nextEvaluator){
        super(nextEvaluator);
    }
    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        if (Helper.findIfRepetitionIsPresent(cards,3) && Helper.findIfRepetitionIsPresent(cards,2)){
            return new WinCondition(  "Main pleine",1700 + Helper.getValueOfRepetition(cards,3) * 10 +  Helper.getValueOfRepetition(cards,2));
        }else if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
