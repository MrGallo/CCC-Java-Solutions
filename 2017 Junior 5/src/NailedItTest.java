import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public void canSortPlanksOfUniqueLength() {
        assertEquals(plankLengths, Main.sortPlanks(Arrays.asList(1,2,3,15)));
    }

    @Test
    public void canSortPlanksOfRepeatedLength() {
        plankLengths.put(2, 2);
        plankLengths.put(15, 3);
        assertEquals(plankLengths, Main.sortPlanks(Arrays.asList(1,2,2,3,15,15,15)));
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
        assertEquals(fenceHeightQuantities, Main.getFenceHeightQuantityMap(plankLengths));
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
        assertEquals(2, Main.getNumberOfCombinationsOfGivenLength(1, fenceHeightQuantities));

        fenceHeightQuantities.put(7, 3);
        fenceHeightQuantities.put(8, 3);
        fenceHeightQuantities.put(9, 3);
        fenceHeightQuantities.put(10, 3);
        assertEquals(4, Main.getNumberOfCombinationsOfGivenLength(3, fenceHeightQuantities));
    }


}
