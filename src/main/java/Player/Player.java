package Player;

import Cards.Card;
import Evaluator.ChainOfEvaluator;
import Evaluator.WinCondition;

import java.util.ArrayList;

public abstract class Player {
    protected ArrayList<Card> playerCard = new ArrayList<>();

    public WinCondition getScore() {
        return score;
    }

    public void setScore(WinCondition score) {
        this.score = score;
    }

    protected WinCondition score;

    public void addCard(Card card){
        playerCard.add(card);
    }

    public ArrayList<Card> getCards(){
        return playerCard;
    }

    public void evaluateScore(ArrayList<Card> dealerHand){
        ArrayList<Card> fullCard = new ArrayList<>();
        fullCard.addAll(playerCard);
        fullCard.addAll(dealerHand);
        fullCard.sort(Card::compareTo);
        this.score = (new ChainOfEvaluator()).evaluate(fullCard);
    }
}

