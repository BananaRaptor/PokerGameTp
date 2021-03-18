package Evaluator;

public class WinCondition {
    private int score;
    private String name;

    public WinCondition(String name, int i) {
        score = i;
        this.name = name;
    }

    public int getResult() {
        return score;
    }


    public String getName() {
        return name;
    }

}
