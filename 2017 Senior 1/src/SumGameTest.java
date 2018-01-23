import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumGameTest {
    private ByteArrayInputStream in;
    private List<Integer> team1SeasonPoints;
    private List<Integer> team2SeasonPoints;

    @Test
    public void testSumGameLastDayEqual() {
        initializeInputStream("4\n1 2 3 4\n1 3 2 4");
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String team1SeasonPoints = scan.nextLine();
        String team2SeasonPoints = scan.nextLine();
        assertEquals(4, Main.sumGame(team1SeasonPoints, team2SeasonPoints, days));
    }

    @Test
    public void testSumGameNoDayEqual() {
        initializeInputStream("4\n1 2 3 4\n2 3 4 5");
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String team1SeasonPoints = scan.nextLine();
        String team2SeasonPoints = scan.nextLine();
        assertEquals(0, Main.sumGame(team1SeasonPoints, team2SeasonPoints, days));
    }

    private void initializeInputStream(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
