package Deck;

import Cards.Card;

public interface DeckStrategy {
    public void addCards();

    public void burnCards();

    public void shuffeCards();

    public Card getRandomCard();
}
