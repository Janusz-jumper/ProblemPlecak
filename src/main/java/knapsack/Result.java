package knapsack;

import java.util.List;

public class Result {
    List<Item> items;
    List<Integer> counts;
    int totalWeight, totalValue;

    public Result(List<Item> items, List<Integer> counts, int weight, int value) {
        this.items = items;
        this.counts = counts;
        this.totalWeight = weight;
        this.totalValue = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Rozwiazanie:\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append(counts.get(i)).append(" x ").append(items.get(i)).append("\n");
        }
        sb.append("Suma wag: ").append(totalWeight).append(", Suma wartosci: ").append(totalValue);
        return sb.toString();
    }
}
