package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class StraightEvaluator extends Evaluator{

    public StraightEvaluator(Evaluator nextEvaluator){
        super(nextEvaluator);
    }

    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        for (int j = 0 ; j < cards.size(); j++) {
            Card prevCard = cards.get(j);
            Card highestCard = cards.get(j);
            int numberOfCardInFlush = 1;
            for (int i = j + 1; i < cards.size(); i++) {
                if (cards.get(i).getValue() != prevCard.getValue() + 1) {
                    break;
                }else {
                    highestCard = cards.get(i);
                }
                numberOfCardInFlush++;
                prevCard = cards.get(i);
            }
            if (numberOfCardInFlush  >= 5) {
                return new WinCondition("Quinte",1200 + highestCard.getValue());
            }

        }
        if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
