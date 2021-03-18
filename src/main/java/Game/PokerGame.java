package Game;

import Cards.Card;
import Deck.DeckContext;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class PokerGame {
    protected int MinNumberOfPlayer;
    protected int MaxNumberOfPlayer;
    protected int numberOfPlayer;

    protected ArrayList<Player> players = new ArrayList<>();

    protected ArrayList<Card> dealerHand = new ArrayList<>();

    protected DeckContext deck;

    public void startPokerGame(){
        askForForNumberOfPlayer();
    }


    private void askForForNumberOfPlayer(){
        Scanner myInput = new Scanner( System.in );
        System.out.println("Veuillez entrer le nombre de joueur ");
        while (numberOfPlayer == 0){
            int value = myInput.nextInt();
            if (value > MinNumberOfPlayer && value < MaxNumberOfPlayer ) {
                numberOfPlayer = value;
            } else{
                System.out.println("Veuillez entrer le nombre de joueur valide pour votre type de jeux soit : entre " + MinNumberOfPlayer + " et " + MaxNumberOfPlayer);
            }
        }
    };
}
