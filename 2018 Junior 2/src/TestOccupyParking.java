import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOccupyParking {

    private ByteArrayInputStream in;
    private ByteArrayOutputStream outputStream;

    @Test
    public void overlapOfOneIn2Spaces() {
        assertInputYieldsExpected("2\n.C\n.C\n", "1");
    }

    @Test
    public void overlapOfNoneIn2Spaces() {
        assertInputYieldsExpected("2\n.C\nC.\n", "0");
    }

    @Test
    public void overlapOfOneIn3Spaces() {
        assertInputYieldsExpected("3\n.CC\nC.C\n", "1");
    }

    @Test
    public void acceptanceTest1() {
        assertInputYieldsExpected("5\nCCCCC\nCCC.C", "4");
    }

    private void assertInputYieldsExpected(String input, String expected) {
        initializeIO(input);
        assertMainOutputEquals(expected);
        tearDown();
    }

    private void initializeIO(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        outputStream = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(outputStream));
    }

    private void assertMainOutputEquals(String expected) {
        Main.main(new String[]{});
        assertEquals(expected, outputStream.toString().trim());
    }

    private void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
