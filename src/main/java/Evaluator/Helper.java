package Evaluator;

import Cards.Card;

import java.util.*;

public class Helper {

    public static int indexForCardValue(ArrayList<Card> cards, int value) {
        for (int i = 0; i < cards.size(); i++)
            if (cards.get(i).getValue() == value)
                return i;
        return -1;
    }

    public static boolean findIfRepetitionIsPresent(ArrayList<Card> cards, int value) {
        Map<Integer, Integer> valueDict = new HashMap<>();
        for (Card card: cards) {
            valueDict.merge(card.getValue(), 1, Integer::sum);
        }
        return valueDict.containsValue(value) ;

    }

    public static int findNumberOfSameColor(ArrayList<Card> cards) {
        Map<String, Integer> valueDict = new HashMap<>();
        for (Card card: cards) {
            valueDict.merge(card.getColor(), 1, Integer::sum);
        }
        Optional<Map.Entry<String, Integer>> maxEntry = valueDict.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get().getValue();
    }

    public static int findNumberOfPair(ArrayList<Card> cards) {
        Map<Integer, Integer> valueDict = new HashMap<>();
        for (Card card: cards) {
            valueDict.merge(card.getValue(), 1, Integer::sum);
        }
        int numberOfPair = 0;
        for (Integer value:valueDict.values()) {
               if (value == 2){
                   numberOfPair ++;
               }
        }
        return numberOfPair;
    }

    public static int getHighestCardNotRepeated(ArrayList<Card> cards) {
        Map<Integer, Integer> valueDict = new HashMap<>();
        for (Card card: cards) {
            valueDict.merge(card.getValue(), 1, Integer::sum);
        }
        int currentHighestCard = 0;
        for (Map.Entry<Integer, Integer> entry : valueDict.entrySet()) {
            if (Objects.equals(1, entry.getValue())) {
                if (entry.getKey() > currentHighestCard){
                    currentHighestCard = entry.getKey();
                }
            }
        }
        return currentHighestCard;
    }

    public static int getValueOfRepetition(ArrayList<Card> cards, int value) {

        Map<Integer, Integer> valueDict = new HashMap<>();
        for (Card card: cards) {
            valueDict.merge(card.getValue(), 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : valueDict.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return 0 ;
    }

    public static ArrayList<Card> findAllcardOfFlush(ArrayList<Card> cards) {
        Map<String, Integer> valueDict = new HashMap<>();
        for (Card card: cards) {
            valueDict.merge(card.getColor(), 1, Integer::sum);
        }
        Optional<Map.Entry<String, Integer>> color = valueDict.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        ArrayList<Card> flushCard = new ArrayList<>();
        for (Card card: cards) {
            if (card.getColor().equals(color.get().getKey())) {
                if (flushCard.size() == 5) {
                    flushCard.remove(0);
                    flushCard.add(card);
                }else {
                    flushCard.add(card);
                }
            }
        }
        return flushCard;
    }
}
