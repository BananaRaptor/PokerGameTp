package Cards;

public class Card implements Comparable{
    private int value;
    private String color;
    private String name;

    public Card(int value, String color, String name) {
        this.value = value;
        this.color = color;
        this.name = name;
    }

    public int getValue() {
        return value;
    }


    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object e) {
        int compareValue = ((Card)e).getValue();

        return this.value-compareValue;
    }
}
