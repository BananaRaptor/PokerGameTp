package Game;

public class PokerGameFactory {
    public PokerGame createAPokerGame(String type) throws Exception {
        return switch (type) {
            case "Texas Hold’em" -> new TexasPokerGame();
            case "Limit" -> throw new Exception("Limit");
            case "Ohama" -> throw new Exception("Ohama");
            case "Fermé" -> throw new Exception("Fermé");
            case "Royal" -> throw new Exception("Royal");
            default -> throw new Exception("Bad value");
        };
    }

}
