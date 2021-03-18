package Deck;

import Cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TexasDeck implements DeckStrategy{
    private ArrayList<Card> cards = new ArrayList<>();
    private Random randomGenerator = new Random();

    @Override
    public void addCards() {
        cards.add(new Card(2,"Clubs","2 de trèfle"));
        cards.add(new Card(3,"Clubs","3 de trèfle"));
        cards.add(new Card(4,"Clubs","4 de trèfle"));
        cards.add(new Card(5,"Clubs","5 de trèfle"));
        cards.add(new Card(6,"Clubs","6 de trèfle"));
        cards.add(new Card(7,"Clubs","7 de trèfle"));
        cards.add(new Card(8,"Clubs","8 de trèfle"));
        cards.add(new Card(9,"Clubs","9 de trèfle"));
        cards.add(new Card(10,"Clubs","10 de trèfle"));
        cards.add(new Card(11,"Clubs","Valet de trèfle"));
        cards.add(new Card(12,"Clubs","Reine de trèfle"));
        cards.add(new Card(13,"Clubs","Roi de trèfle"));
        cards.add(new Card(14,"Clubs","Ace de trèfle"));

        cards.add(new Card(2,"Diamonds","2 de carreau"));
        cards.add(new Card(3,"Diamonds","3 de carreau"));
        cards.add(new Card(4,"Diamonds","4 de carreau"));
        cards.add(new Card(5,"Diamonds","5 de carreau"));
        cards.add(new Card(6,"Diamonds","6 de carreau"));
        cards.add(new Card(7,"Diamonds","7 de carreau"));
        cards.add(new Card(8,"Diamonds","8 de carreau"));
        cards.add(new Card(9,"Diamonds","9 de carreau"));
        cards.add(new Card(10,"Diamonds","10 de carreau"));
        cards.add(new Card(11,"Diamonds","Valet de carreau"));
        cards.add(new Card(12,"Diamonds","Reine de carreau"));
        cards.add(new Card(13,"Diamonds","Roi de carreau"));
        cards.add(new Card(14,"Diamonds","Ace de carreau"));

        cards.add(new Card(2,"Heart","2 de coeur"));
        cards.add(new Card(3,"Heart","3 de coeur"));
        cards.add(new Card(4,"Heart","4 de coeur"));
        cards.add(new Card(5,"Heart","5 de coeur"));
        cards.add(new Card(6,"Heart","6 de coeur"));
        cards.add(new Card(7,"Heart","7 de coeur"));
        cards.add(new Card(8,"Heart","8 de coeur"));
        cards.add(new Card(9,"Heart","9 de coeur"));
        cards.add(new Card(10,"Heart","10 de coeur"));
        cards.add(new Card(11,"Heart","Valet de coeur"));
        cards.add(new Card(12,"Heart","Reine de coeur"));
        cards.add(new Card(13,"Heart","Roi de coeur"));
        cards.add(new Card(14,"Heart","Ace de coeur"));

        cards.add(new Card(2,"Spade","2 de pique"));
        cards.add(new Card(3,"Spade","3 de pique"));
        cards.add(new Card(4,"Spade","4 de pique"));
        cards.add(new Card(5,"Spade","5 de pique"));
        cards.add(new Card(6,"Spade","6 de pique"));
        cards.add(new Card(7,"Spade","7 de pique"));
        cards.add(new Card(8,"Spade","8 de pique"));
        cards.add(new Card(9,"Spade","9 de pique"));
        cards.add(new Card(10,"Spade","10 de pique"));
        cards.add(new Card(11,"Spade","Valet de pique"));
        cards.add(new Card(12,"Spade","Reine de pique"));
        cards.add(new Card(13,"Spade","Roi de pique"));
        cards.add(new Card(14,"Spade","Ace de pique"));
    }

    @Override
    public void burnCards() {
        int index = randomGenerator.nextInt(cards.size());
        cards.remove(index);
    }

    @Override
    public void shuffeCards() {
        Collections.shuffle(cards);
    }

    @Override
    public Card getRandomCard() {
        int index = randomGenerator.nextInt(cards.size());
        Card cardToReturn = cards.get(index);
        cards.remove(index);
        return cardToReturn;
    }
}
