package knapsack;

import java.util.*;

public class Problem {
    List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        items = new ArrayList<>();
        Random rand = new Random(seed);
        for (int i = 0; i < n; i++) {
            int weight = lowerBound + rand.nextInt(upperBound - lowerBound + 1);
            int value = lowerBound + rand.nextInt(upperBound - lowerBound + 1);
            items.add(new Item(weight, value));
        }
    }

    public Result solve(int capacity) {
        List<Item> sorted = new ArrayList<>(items);
        sorted.sort((a, b) -> Double.compare(b.ratio(), a.ratio()));

        List<Integer> counts = new ArrayList<>();
        int totalWeight = 0, totalValue = 0;

        for (Item item : sorted) {
            int count = capacity / item.weight;
            totalWeight += count * item.weight;
            totalValue += count * item.value;
            counts.add(count);
            capacity -= count * item.weight;
        }

        return new Result(sorted, counts, totalWeight, totalValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Przedmioty:\n");
        for (Item item : items) sb.append(item).append("\n");
        return sb.toString();
    }
}
