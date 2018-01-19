import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadrantSelectTest {
    @Test
    public void quadrant1_for_1_1() {
        assertEquals(1, Main.quadrantSelect(1, 1));
    }

    @Test
    public void quadrant2_for_neg1_1() {
        assertEquals(2, Main.quadrantSelect(-1, 1));
    }

    @Test
    public void quadrant3_for_neg1_neg1() {
        assertEquals(3, Main.quadrantSelect(-1, -1));
    }

    @Test
    public void quadrant4_for_1_neg1() {
        assertEquals(4, Main.quadrantSelect(1, -1));
    }
}
