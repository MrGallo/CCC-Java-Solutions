import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighTideLowTideTest {
    private Scanner scanner;
    private ByteArrayInputStream in;

    @Test
    public void testScannerInput() {
        initializeScanerWithInput("2\n1 3");
        assertEquals("2", scanner.nextLine());
        assertEquals("1 3", scanner.nextLine());
    }

    @Test
    @Disabled
    public void testScanIntoTreeSet1() {
        initializeScanerWithInput("2\n1 3");
        Main.scanIntoTwoTreeSets(scanner);
        TreeSet<Integer> expectedSet1 = new TreeSet<>(Arrays.asList(1));
        TreeSet<Integer> expectedSet2 = new TreeSet<>(Arrays.asList(3));
        assertEquals(expectedSet1, Main.getSet1());
        assertEquals(expectedSet2, Main.getSet2());
    }

    @Test
    @Disabled
    public void testScanIntoTreeSet2() {
        initializeScanerWithInput("2\n1 3 7 5");
        Main.scanIntoTwoTreeSets(scanner);
        TreeSet<Integer> expectedSet1 = new TreeSet<>(Arrays.asList(1));
        TreeSet<Integer> expectedSet2 = new TreeSet<>(Arrays.asList(3));
        assertEquals(expectedSet1, Main.getSet1());
        assertEquals(expectedSet2, Main.getSet2());
    }

    @Test
    @Disabled
    public void testComposeResponseString() {
        initializeScanerWithInput("4\n1 7 3 5");
        Main.scanIntoTwoTreeSets(scanner);
        assertEquals("3 5 1 7", Main.composeResponseString());
    }

    @Test
    @Disabled
    public void testComposeResponseString2() {
        initializeScanerWithInput("8\n10 50 40 7 3 110 90 2");
        Main.scanIntoTwoTreeSets(scanner);
        assertEquals("10 40 7 50 3 90 2 110", Main.composeResponseString());
    }

    @Test
    @Disabled
    public void testComposeResponseStringOddNumberMidIsHighTide() {
        initializeScanerWithInput("5\n1 2 3 4 5");
        Main.scanIntoTwoTreeSets(scanner);
        assertEquals("3 2 4 1 5", Main.composeResponseString());
    }

    @Test
    @Disabled
    public void testComposeResponseStringOddNumberMidIsLowTide() {
        initializeScanerWithInput("5\n1 2 3 5 6");
        Main.scanIntoTwoTreeSets(scanner);
        assertEquals("3 5 2 6 1", Main.composeResponseString());
    }

    @Test
    @Disabled
    public void testComposeResponseStringTest4FromCCC() {
        initializeScanerWithInput("39\n199252 470888 74578 802746 396295 386884 721198 628655 722503 207868 647942 87506 792718 761498 917727 843338 908043 952768 268783 375312 414369 319712 96230 277106 168102 263554 936674 246545 667941 198849 268921 191459 436316 134606 802932 515506 837311 465964 39476");
        Main.scanIntoTwoTreeSets(scanner);
        String expected = "414369 436316 396295 465964 394766 470888 386884 515506 375312 628655 319712 647942 277106 667941 268921 721198 268783 722503 263554 761498 246545 792718 207868 802746 199252 802932 198849 837311 191459 843338 168102 908043 134606 917727 96230 936674 87506 952768 74578";
        assertEquals(expected, Main.composeResponseString());
    }

    @Test
    @Disabled
    public void testComposeResonnseStringTest5FromCCC() {
        initializeScanerWithInput("26\n650419 984050 790137 432079 786900 683340 141081 672277 936815 104250 874183 41862 50825 408976 718927 866448 546966 262261 412146 238004 258178 240996 615461 493128 371564 51181\n");
        Main.scanIntoTwoTreeSets(scanner);
        String expected = "432079 493128 412146 546966 408976 615461 371564 650419 262261 672277 258178 683340 240996 718927 238004 786900 141081 790137 104250 866448 51181 874183 50825 936815 41862 984050";
        assertEquals(expected, Main.composeResponseString());
    }


    @Test
    @Disabled
    public void learnTreeSetCapabilities() {
        Set<Integer> test = new TreeSet<>(Arrays.asList(5,3,1,17,13,11));
        assertTrue(Arrays.equals(new Integer[] {1,3,5,11,13,17}, test.toArray()));
        Integer[] measurementsArray = test.toArray(new Integer[]{});
        assertEquals(Integer.valueOf(1), measurementsArray[0]);
    }

    private void initializeScanerWithInput(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
    }
}
