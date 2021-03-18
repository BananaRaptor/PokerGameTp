package Deck;

import Cards.Card;

public class DeckContext {
    private DeckStrategy deckStrategy;

    public DeckContext(DeckStrategy deckStrategy){
        this.deckStrategy = deckStrategy;
    }

    public void addCards(){
        deckStrategy.addCards();
    }

    public void burnCards(){
        deckStrategy.burnCards();
    }


    public void shuffleCards() {
        deckStrategy.shuffeCards();
    }

    public Card getRandomCard() {
        return deckStrategy.getRandomCard();
    }
}
