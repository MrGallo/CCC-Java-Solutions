import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***
 Input
 3 10 12 5

 Output for Sample Input
 0  3  13 25 30
 3  0  10 22 27
 13 10 0  12 17
 25 22 12 0  5
 30 27 17 5  0

 */
public class TestWeThereYet {

    @Test
    public void createsProper1stRowFor1111() {
        int[] distances = {1, 1, 1, 1};
        int row = 0;
        assertCorrectRowFromDistances("0 1 2 3 4", row, distances);
    }

    @Test
    public void createsProper1stRowFor2222() {
        int[] distances = {2, 2, 2, 2};
        int row = 0;
        assertCorrectRowFromDistances("0 2 4 6 8", row, distances);
    }

    @Test
    public void createsProper1stRowFor5342() {
        int[] distances = {5, 3, 4, 5};
        int row = 0;
        assertCorrectRowFromDistances("0 5 8 12 17", row, distances);
    }

    @Test
    public void createsProper2ndRowFor1111() {
        int[] distances = {1, 1, 1, 1};
        int row = 1;
        assertCorrectRowFromDistances("1 0 1 2 3", row, distances);
    }

    @Test
    public void createsProper3rdRowFor1111() {
        int[] distances = {1, 1, 1, 1};
        int row = 2;
        assertCorrectRowFromDistances("2 1 0 1 2", row, distances);
    }

    @Test
    public void createsProper4thRowFor1111() {
        int[] distances = {1, 1, 1, 1};
        int row = 3;
        assertCorrectRowFromDistances("3 2 1 0 1", row, distances);
    }

    @Test
    public void createsProper5thRowFor1111() {
        int[] distances = {1, 1, 1, 1};
        int row = 4;
        assertCorrectRowFromDistances("4 3 2 1 0", row, distances);
    }

    private void assertCorrectRowFromDistances(String expected, int row, int[] distances) {
        assertEquals(expected, Main.generateRow(row, distances));
    }

    @Test
    public void areWeThereYetAcceptance1() {
        String input = "3 10 12 5\n";
        String expected =   "0 3 13 25 30\r\n" +
                            "3 0 10 22 27\r\n" +
                            "13 10 0 12 17\r\n" +
                            "25 22 12 0 5\r\n" +
                            "30 27 17 5 0";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));
        Main.main(new String[]{});
        assertEquals(expected, outputStream.toString().trim());
        System.setIn(System.in);
        System.setOut(System.out);
    }


}
