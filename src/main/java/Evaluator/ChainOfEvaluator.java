package Evaluator;

import Cards.Card;

import java.util.ArrayList;

public class ChainOfEvaluator {
    Evaluator chain;

    public ChainOfEvaluator(){
        chain = new RoyalFlushEvaluator(new StraightFlushEvaluator(new FourOfAKindEvaluator(new FullHouseEvaluator(new FlushEvaluator(new StraightEvaluator(new ThreeOfAKindEvalutor(new TwoPairEvaluator(new PairEvaluator(new HighCardEvaluator(null))))))))));
    }

    public WinCondition evaluate(ArrayList<Card> cards){
        return chain.evaluateHand(cards);
    }
}
