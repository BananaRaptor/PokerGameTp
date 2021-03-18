package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class StraightFlushEvaluator extends Evaluator{

    public StraightFlushEvaluator(Evaluator nextEvaluator){
        super(nextEvaluator);
    }

    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        for (int j = 0 ; j < cards.size()-2; j++) {
            Card prevCard = cards.get(j);
            Card highestCard = cards.get(j);
            int numberOfCardInFlush = 1;
            for (int i = j + 1; i < cards.size(); i++) {
                if (cards.get(i).getValue() != prevCard.getValue() + 1 || !cards.get(i).getColor().equals(prevCard.getColor())) {
                    break;
                }else {
                    highestCard = cards.get(i);
                }
                numberOfCardInFlush++;
                prevCard = cards.get(i);
            }
            if (numberOfCardInFlush  >= 5) {
                return new WinCondition("Quinte Flush",1900 + highestCard.getValue());
            }

        }
        if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
