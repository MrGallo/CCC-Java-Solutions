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

        System.out.println(sumGame(team1SeasonPoints, team2SeasonPoints, days));
    }

    public static int sumGame(String team1SeasonPoints, String team2SeasonPoints, int totalDays) {
        String[] team1SeasonPointsArray = team1SeasonPoints.split(" ");
        String[] team2SeasonPointsArray = team2SeasonPoints.split(" ");

        int latestDayWithEqualPoints = 0;
        int team1TotalPoints = 0;
        int team2TotalPoints = 0;

        for (int day = 1; day <= totalDays; day++) {
            team1TotalPoints += getPointsFromDayAsInt(team1SeasonPointsArray, day);
            team2TotalPoints += getPointsFromDayAsInt(team2SeasonPointsArray, day);
            if (team1TotalPoints == team2TotalPoints)
                latestDayWithEqualPoints = day;
        }
        return latestDayWithEqualPoints;
    }

    private static int getPointsFromDayAsInt(String[] seasonPointsArray, int day) {
        return Integer.parseInt(seasonPointsArray[day-1]);
    }
}
