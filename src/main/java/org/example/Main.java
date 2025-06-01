package knapsackProblem;

import java.util.*;

class Item {
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

class Problem {
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

class Result {
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

public class Main {
    public static void main(String[] args) {
        Problem p = new Problem(5, 42, 1, 10);
        System.out.println(p);
        Result r = p.solve(30);
        System.out.println(r);
    }
}