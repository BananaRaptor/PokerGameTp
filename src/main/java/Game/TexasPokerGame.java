package Game;

import Cards.Card;
import Deck.DeckContext;
import Deck.TexasDeck;
import Player.AiPlayer;
import Player.HumanPlayer;
import Player.Player;

public class TexasPokerGame extends PokerGame {
    @Override
    public void startPokerGame() {
        super.MinNumberOfPlayer = 2;
        super.MaxNumberOfPlayer = 9;
        super.startPokerGame();
        CreateDeck();
        CreatePlayers();
        PassCard();
        Flop();
        Turn();
        River();
        PrintAllCard();
        FindWinner();

    }

    private void PrintAllCard() {
        for (Player player: super.players) {
            player.evaluateScore(super.dealerHand);
        }
        try {
            System.out.println("Vos cartes ( " + players.get(0).getScore().getName() + " ) : ");
        }catch (Exception e){

        }
        for (Card card: players.get(0).getCards()){
            System.out.println("- "+ card.getName());
        }
        for (int i = 1; i < super.numberOfPlayer; i++) {
            System.out.println("Les cartes de l'IA # "+ i+" ( "+players.get(i).getScore().getName()+" )  : ");
            for (Card card: players.get(i).getCards()){
                System.out.println("- "+ card.getName());
            }
        }
        System.out.println("Les cartes du dealer : ");
        for (Card card :dealerHand){
            System.out.println("- "+ card.getName());
        }
    }

    private void FindWinner() {
        Player winner = super.players.get(0);
        for (Player player: super.players) {
            if (player.getScore().getResult() > winner.getScore().getResult()){
                winner = player;
            }
        }
        if (winner.equals(players.get(0))){
            System.out.println("Félicitation vous avez gagner avec "+ winner.getScore().getName() +" !!!");
        }else {
            System.out.println("Le gagnant est l'IA : #" + (players.indexOf(winner)) + " avec " + winner.getScore().getName() );
        }
    }

    private void Flop() {
        deck.burnCards();
        super.dealerHand.add(deck.getRandomCard());
        super.dealerHand.add(deck.getRandomCard());
        super.dealerHand.add(deck.getRandomCard());
    }
    private void Turn() {
        deck.burnCards();
        super.dealerHand.add(deck.getRandomCard());
    }
    private void River() {
        deck.burnCards();
        super.dealerHand.add(deck.getRandomCard());
    }

    private void PassCard() {
        for (int i = 0; i < super.numberOfPlayer; i++) {
            super.players.get(i).addCard(deck.getRandomCard());
        }
        for (int i = 0; i < super.numberOfPlayer; i++) {
            super.players.get(i).addCard(deck.getRandomCard());
        }
    }

    private void CreatePlayers() {
        super.players.add(new HumanPlayer());
        for (int i = 0; i < super.numberOfPlayer-1; i++) {
            super.players.add(new AiPlayer());
        }
    }

    private void CreateDeck() {
        deck = new DeckContext(new TexasDeck());
        deck.addCards();
        deck.shuffleCards();
    }
}
