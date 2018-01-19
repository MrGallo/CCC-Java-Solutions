import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftySumTest {
    @Test
    public void shifty_1_zero_times_is_1() {
        assertEquals(1, Main.shiftySum(1, 0));
    }

    @Test
    public void shifty_2_0_times_is_2() {
        assertEquals(2, Main.shiftySum(2, 0));
    }

    @Test
    public void shifty_1_1_times_is_11() {
        assertEquals(11, Main.shiftySum(1, 1));
    }

    @Test
    public void shifty_2_1_times_is_22() {
        assertEquals(22, Main.shiftySum(2, 1));
    }
    
    @Test
    public void shifty_3_1_times_is_33() {
        assertEquals(33, Main.shiftySum(3, 1));
    }

    @Test
    public void shifty_12_1_times() {
        assertEquals(120+12, Main.shiftySum(12, 1));
    }

    @Test
    public void shifty_1_2_times() {
        assertEquals(100+10+1, Main.shiftySum(1, 2));
    }

    @Test
    public void shifty_12_2_times() {
        assertEquals(1200+120+12, Main.shiftySum(12, 2));
    }

    @Test
    public void shifty_1_3_times() {
        assertEquals(1000+100+10+1, Main.shiftySum(1, 3));
    }

    @Test
    public void shiftyAcceptance1() {
        assertEquals(150000+15000+1500+150+15, Main.shiftySum(15, 4));
    }

}
