package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class HighCardEvaluator extends Evaluator{

    public HighCardEvaluator(Evaluator nextEvaluator) {
        super(nextEvaluator);
    }

    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        int maxValue = 0;
        for (Card card:cards) {
            if (card.getValue() > maxValue){
                maxValue = card.getValue();
            }
        }
        return new WinCondition("Hauteur", maxValue);
    }
}
