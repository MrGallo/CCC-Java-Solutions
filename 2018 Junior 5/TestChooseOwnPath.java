import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestChooseOwnPath {

    @Test
    public void testShortestPathOfOnePageIs1() {
        Main.bookMap = new HashMap<>();
        Main.bookMap.put(1, new ArrayList<Integer>() {{ add(0); }});

        assertEquals(1, Main.shortestPathOfPage(1));
    }

    @Test
    public void testShortestPathOfTwoPagesProperlyLinkedIs2() {
        Main.bookMap = new HashMap<>();
        Main.bookMap.put(1, new ArrayList<Integer>() {{ add(2); }});
        Main.bookMap.put(2, new ArrayList<Integer>() {{ add(0); }});

        assertEquals(2, Main.shortestPathOfPage(1));
    }

    @Test
    public void testShortestPathOfThreePagesNoShortcutsIs3() {
        Main.bookMap = new HashMap<>();
        Main.bookMap.put(1, new ArrayList<Integer>() {{ add(2); }});
        Main.bookMap.put(2, new ArrayList<Integer>() {{ add(3); }});
        Main.bookMap.put(3, new ArrayList<Integer>() {{ add(0); }});

        assertEquals(3, Main.shortestPathOfPage(1));
    }

    @Test
    public void testShortestPathOfThreePagesWithShortcutsIs2() {
        Main.bookMap = new HashMap<>();
        Main.bookMap.put(1, new ArrayList<Integer>() {{ add(2); add(3); }});
        Main.bookMap.put(2, new ArrayList<Integer>() {{ add(3); }});
        Main.bookMap.put(3, new ArrayList<Integer>() {{ add(0); }});

        assertEquals(2, Main.shortestPathOfPage(1));
    }

    @Test
    public void testShortestPathShouldNotLoopBetweenPages1And4() {
        Main.bookMap = new HashMap<>();
        // Program should not loop
        Main.bookMap.put(1, new ArrayList<Integer>() {{ add(2); add(4); }});
        Main.bookMap.put(2, new ArrayList<Integer>() {{ add(3); }});
        Main.bookMap.put(3, new ArrayList<Integer>() {{ add(0); }});
        Main.bookMap.put(4, new ArrayList<Integer>() {{ add(1); }});

        assertEquals(3, Main.shortestPathOfPage(1));
    }
}
