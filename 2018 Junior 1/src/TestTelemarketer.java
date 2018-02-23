import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestTelemarketer {

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream in;


    @Test
    public void mainGiven1111PrintsAnswer() {
        initSystemIn("1\n1\n1\n1\n");
        assertMainOutputEquals("answer");
        System.setIn(System.in);
    }

    @Test
    public void mainGiven9668PrintsAnswer() {
        initSystemIn("9\n6\n6\n8\n");
        assertMainOutputEquals("ignore");
        System.setIn(System.in);
    }

    private void initSystemIn(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    private void assertMainOutputEquals(String expected) {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Main.main(new String[]{});
        assertEquals(expected, outputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void telemarketer1111False() {
        assertFalse(Main.isTelemarketer(1,1,1,1), "1111 is not presumed telemarketer");
    }

    @Test
    public void middleDifferentNotTelemarketer() {
        assertFalse(Main.isTelemarketer(9,6,1,9), "9619 is not presumed telemarketer");
    }

    @Test
    public void lastNumber2NotTelemarketer() {
        assertFalse(Main.isTelemarketer(8,6,6,2), "8662 is not presumed telemarketer");
    }

    @Test
    public void telemarketer9669True() {
        assertTrue(Main.isTelemarketer(9,6,6,9), "9669 is presumed telemarketer");
    }

    @Test
    public void telemarketer8669True() {
        assertTrue(Main.isTelemarketer(8,6,6,9), "8669 is presumed telemarketer");
    }
}
