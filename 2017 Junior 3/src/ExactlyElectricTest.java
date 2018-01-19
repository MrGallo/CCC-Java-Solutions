import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExactlyElectricTest {

    @Test
    public void movingZeroWithEvenCharge_isY() {
        int[] start = {0, 0};
        int[] end = {0, 0};
        int charge = 0;
        assertEquals('Y', Main.exactlyElectric(start, end, charge));
    }

    @Test
    public void movingZeroWithOddCharge_isN() {
        int[] start = {0, 0};
        int[] end = {0, 0};
        int charge = 3;
        assertEquals('N', Main.exactlyElectric(start, end, charge));
    }

    @Test
    public void movingTwoWithOneCharge_isN() {
        int[] start = {0, 0};
        int[] end = {2, 0};
        int charge = 1;
        assertEquals('N', Main.exactlyElectric(start, end, charge));
    }

    @Test
    public void movingThreeWithTwoCharge_isN() {
        int[] start = {0, 0};
        int[] end = {3, 0};
        int charge = 2;
        assertEquals('N', Main.exactlyElectric(start, end, charge));
    }

    @Test
    public void acceptanceMovingEvenWithAdequateEvenChargeIsY() {
        int[] start = {0, 0};
        int[] end = {10, 10};
        int charge = 24;
        assertEquals('Y', Main.exactlyElectric(start, end, charge));
    }

    @Test
    public void acceptanceMovingEvenWithAdequateOddChargeIsN() {
        int[] start = {0, 0};
        int[] end = {10, 10};
        int charge = 25;
        assertEquals('N', Main.exactlyElectric(start, end, charge));
    }

    @Test
    public void acceptanceMovingEvenWithInadequateEvenChargeIsN() {
        int[] start = {0, 0};
        int[] end = {10, 10};
        int charge = 18;
        assertEquals('N', Main.exactlyElectric(start, end, charge));
    }

}
