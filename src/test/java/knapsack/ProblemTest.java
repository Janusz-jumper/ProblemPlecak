package knapsack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    @Test
    public void ProblemGeneration() {
        Problem p = new Problem(5, 1, 1, 10);
        assertEquals(5, p.items.size());
    }

    @Test
    public void SolutionExists() {
        Problem p = new Problem(3, 1, 1, 10);
        Result r = p.solve(15);
        assertTrue(r.totalValue > 0);
    }

    @Test
    public void testNoItemFits() {
        Problem p = new Problem(10, 1, 4, 10);
        Result r = p.solve(3);
        assertEquals(0, r.totalValue);
    }

    @Test
    public void testBounds() {
        Problem p = new Problem(10, 1, 1, 10);
        for (Item item : p.items) {
            assertTrue(item.weight >= 1 && item.weight <= 10);
            assertTrue(item.value >= 1 && item.value <= 10);
        }
    }
}
