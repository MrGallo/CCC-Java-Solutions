import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FavouriteTimesTest {

    @Test
    public void minsToHourMin_0_is_1200() {
        assertEquals(1200, Main.getClockFace(0));
    }

    @Test
    public void minsToHourMin_59_is_1259() {
        assertEquals(1259, Main.getClockFace(59));
    }

    @Test
    public void minsToHourMin_60_is_100() {
        assertEquals(100, Main.getClockFace(60));
    }

    @Test
    public void minsToHourMin_65_is_105() {
        assertEquals(105, Main.getClockFace(65));
    }
    
    @Test
    public void minsToHourMin_120_is_200() {
        assertEquals(200, Main.getClockFace(120));
    }

    @Test
    public void minsToHourMinAcceptanceTest() {
        assertEquals(208, Main.getClockFace(60*14 + 8));
    }

    @Test
    public void favouriteTimes_within34() {
        assertEquals(1, Main.favouriteTimes(34));
    }
    
    @Test
    public void favouriteTimes_within180() {
        assertEquals(11, Main.favouriteTimes(180));
    }

    @Test
    public void favouriteTimes_12hours() {
        assertEquals(Main.getFavCount(Main.getTimeMap()), Main.favouriteTimes(12*60));
    }

    @Test
    public void favouriteTimes_24hours() {
        assertEquals(Main.getFavCount(Main.getTimeMap())*2, Main.favouriteTimes(12*60*2));
    }
}