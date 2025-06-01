package knapsack;

public class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double ratio() {
        return (double) value / weight;
    }

    @Override
    public String toString() {
        return "[waga=" + weight + ", wartosc=" + value + "]";
    }
}
