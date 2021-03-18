package Evaluator;

import Cards.Card;

import java.util.ArrayList;

import static Evaluator.Helper.indexForCardValue;

public class RoyalFlushEvaluator extends Evaluator{

    public RoyalFlushEvaluator(Evaluator nextEvaluator){
        super(nextEvaluator);
    }

    @Override
    public WinCondition evaluateHand(ArrayList<Card> cards) {
        int numberOfCardInFlush = 0;
        int indexOf10 = indexForCardValue(cards,10);
        if(indexOf10 != -1) {
            Card prevCard = cards.get(indexOf10);
            numberOfCardInFlush ++;
            for(int i = indexOf10+1; i < cards.size() ; i++){
                if(cards.get(i).getValue() != prevCard.getValue()+1 || !cards.get(i).getColor().equals(prevCard.getColor()) ){
                    break;
                }
                numberOfCardInFlush ++;
                prevCard = cards.get(i);
            }
            if (numberOfCardInFlush  >= 5) {
                return new WinCondition("Quinte Flush Royale",2000);
            }
        }
        if (nextEvaluator != null) {
            return nextEvaluator.evaluateHand(cards);
        }else{
            return null;
        }
    }
}
