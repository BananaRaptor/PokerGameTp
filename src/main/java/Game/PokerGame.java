package Game;

import Cards.Card;
import Deck.DeckContext;
import Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        boolean isPlaying = true;
        while (isPlaying) {
            mainGameLogic();
            try {
                isPlaying = askPlayerToContinue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean askPlayerToContinue() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Voulez quitter (Exit) ou rester à ce type de jeu (Stay)");
        return !reader.readLine().equals("Exit");
    }

    protected abstract void mainGameLogic();

    protected abstract void PrintAllCard() ;

    protected abstract void FindWinner();

    protected abstract void Flop();

    protected abstract void Turn();

    protected abstract void River();

    protected abstract void PassCard() ;

    protected abstract void CreatePlayers() ;

    protected abstract void CreateDeck() ;


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
