package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public abstract class Evaluator {
    public Evaluator nextEvaluator;

    public Evaluator(Evaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
    }

    public abstract WinCondition evaluateHand(ArrayList<Card> cards);
}
