import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        String team1SeasonPoints = scan.nextLine();
        String team2SeasonPoints = scan.nextLine();

        int lastGameEqual = sumGame(team1SeasonPoints, team2SeasonPoints, days);
        System.out.println(lastGameEqual);
    }

    public static int sumGame(String team1SeasonPoints, String team2SeasonPoints, int totalDays) {
        String[] team1SeasonPointsArray = team1SeasonPoints.split(" ");
        String[] team2SeasonPointsArray = team2SeasonPoints.split(" ");

        int latestDayWithEqualPoints = 0;
        int team1TotalPoints = 0;
        int team2TotalPoints = 0;

        for (int i = 0; i < totalDays; i++) {
            team1TotalPoints += Integer.parseInt(team1SeasonPointsArray[i]);
            team2TotalPoints += Integer.parseInt(team2SeasonPointsArray[i]);
            if (team1TotalPoints == team2TotalPoints) {
                latestDayWithEqualPoints = i + 1;
            }
        }
        return latestDayWithEqualPoints;
    }
}