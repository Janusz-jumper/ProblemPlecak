package knapsack;

public class Main {
    public static void main(String[] args) {
        Problem p = new Problem(10, 30, 60, 200);
        System.out.println(p);
        Result r = p.solve(1000);
        System.out.println(r);
    }
}
