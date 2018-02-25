import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestSunflowers {

    private int[][] inputGrid3by3;

    @BeforeEach
    public void setUp() {
        inputGrid3by3 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }
    @Test
    public void rotateTwoByTwoArray1() {
        Main.grid = new int[][] {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {2, 4},
                {1, 3}
        };
        Main.rotateGrid();
        assertArrayEquals(expected, Main.grid);
    }

    @Test
    public void rotateTwoByTwoArray2() {
        Main.grid = new int[][]{
                {5, 6},
                {7, 8}
        };

        int[][] expected = {
                {6, 8},
                {5, 7}
        };
        Main.rotateGrid();
        assertArrayEquals(expected, Main.grid);
    }

    @Test
    public void rotateThreeByThreeArray() {
        int[][] expected = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        Main.grid = inputGrid3by3;
        Main.rotateGrid();
        assertArrayEquals(expected, Main.grid);
    }

    @Test
    public void checkFirstMeasurementColumnShouldBeTrue() {
        Main.grid = inputGrid3by3;
        assertTrue(Main.leftColumnInOrder(), "Expected left-most to be in order.");
    }

    @Test
    public void checkFirstMeasurementColumnShouldBeFalse() {
        inputGrid3by3[2][0] = 1;
        Main.grid = inputGrid3by3;
        assertFalse(Main.leftColumnInOrder(), "Expected left-most to not be in order.");
    }

    @Test
    public void checkRowOrderShouldBeInOrder() {
        Main.grid = inputGrid3by3;
        assertTrue(Main.isRowInOrder(0), "Expected row to be ascending.");
    }

    @Test
    public void checkRowOrderShouldNotBeInOrder() {
        inputGrid3by3[0][2] = 0;
        Main.grid = inputGrid3by3;
        assertFalse(Main.isRowInOrder(0), "Expected row to be out of order.");
    }

    @Test
    public void allRowsShouldBeInOrder() {
        Main.grid = inputGrid3by3;
        assertTrue(Main.allRowsInOrder(), "All rows should be in order");
    }

    @Test
    public void allRowsShouldBeNotInOrder() {
        inputGrid3by3[2][2] = 0;
        Main.grid = inputGrid3by3;
        assertFalse(Main.allRowsInOrder(), "All rows should not be in order");
    }

    @Test
    public void rotateZero() {
        String input = "2\n1 2\n3 4\n";
        String expected = "1 2\r\n3 4\r\n";
        assertProperRotation(input, expected);
    }

    @Test
    public void rotateOnce() {
        String input = "2\n3 1\n4 2\n";
        String expected = "1 2\r\n3 4\r\n";
        assertProperRotation(input, expected);
    }

    @Test
    public void rotateTwice() {
        String input = "2\n4 3\n2 1\n";
        String expected = "1 2\r\n3 4\r\n";
        assertProperRotation(input, expected);
    }

    @Test
    public void rotateThrice() {
        String input = "2\n2 4\n1 3\n";
        String expected = "1 2\r\n3 4\r\n";
        assertProperRotation(input, expected);
    }

    private void assertProperRotation(String input, String expected) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});
        assertEquals(expected, outputStream.toString());

        System.setIn(System.in);
        System.setOut(System.out);
    }


}
