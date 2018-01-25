import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NailedItTest {

    // Mapping plankLength -> quantity
    private Map<Integer, Integer> plankLengths;

    @BeforeEach
    public void setUp() {
        plankLengths = new HashMap<>();
        plankLengths.put(1, 1);
        plankLengths.put(2, 1);
        plankLengths.put(3, 1);
        plankLengths.put(15, 1);
    }

    @Test
    public void getPlankInputAndSort1() {
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3 15".getBytes());
        System.setIn(in);
        Scanner scan = new Scanner(System.in);
        assertEquals(plankLengths, Main.getPlankInputAndSort(scan));
    }

    @Test
    public void getPlankInputAndSort2() {
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3 15 1 2 3 15".getBytes());
        System.setIn(in);
        Scanner scan = new Scanner(System.in);
        plankLengths.put(1, 2);
        plankLengths.put(2, 2);
        plankLengths.put(3, 2);
        plankLengths.put(15, 2);
        assertEquals(plankLengths, Main.getPlankInputAndSort(scan));
    }

    @Test
    public void canCollectFenceLengths() {
        Map<Integer, Integer> fenceHeightQuantities = new HashMap<>();
        fenceHeightQuantities.put(3, 1);
        fenceHeightQuantities.put(4, 1);
        fenceHeightQuantities.put(16, 1);
        fenceHeightQuantities.put(5, 1);
        fenceHeightQuantities.put(17, 1);
        fenceHeightQuantities.put(18, 1);
        fenceHeightQuantities.put(2, 0);
        fenceHeightQuantities.put(6, 0);
        fenceHeightQuantities.put(30, 0);
        assertEquals(fenceHeightQuantities, Main.getFenceLengthForEachBoardHeight(plankLengths));
    }

    @Test
    public void findLongestFenceReturnEntrySet() {
        Map<Integer, Integer> fenceHeightQuantities = new HashMap<>();
        fenceHeightQuantities.put(2, 1);
        fenceHeightQuantities.put(4, 0);
        assertEquals(1, Main.findLongestFence(fenceHeightQuantities));
    }

    @Test
    public void getNumberOfHeightPossibilitiesOfLength() {
        Map<Integer, Integer> fenceHeightQuantities = new HashMap<>();
        fenceHeightQuantities.put(2, 1);
        fenceHeightQuantities.put(4, 0);
        fenceHeightQuantities.put(5, 1);
        assertEquals(2, Main.getFrequencyOfGivenLength(1, fenceHeightQuantities));

        fenceHeightQuantities.put(7, 3);
        fenceHeightQuantities.put(8, 3);
        fenceHeightQuantities.put(9, 3);
        fenceHeightQuantities.put(10, 3);
        assertEquals(4, Main.getFrequencyOfGivenLength(3, fenceHeightQuantities));
    }


}
