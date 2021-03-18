import Game.PokerGame;
import Game.PokerGameFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class Main {

    public static void main(String[] args) throws IOException {
        boolean isPlaying = true;
        System.out.println("Bienvenue au simulateur de Poker ");
        while (isPlaying) {
            String value = getType();
            if (value != "exit") {
                createPokerGame(value);
            } else {
                isPlaying = !isPlaying;
            }
        }
    }

    static void createPokerGame(String value) {
        try {
            PokerGame pokerGame = new PokerGameFactory().createAPokerGame(value);
            pokerGame.startPokerGame();
        } catch (Exception e) {
            System.out.println(value + " n'est pas encore implémenté  ");
        }
    }

    public static String getType( ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Quelle type de poker voulez vous jouer (Texas Hold’em, Limit, Ohama, Fermé ou Royal) ? \nVeuillez écrire le nom complet : ");
        String value = reader.readLine();
        return value;
    }
}
