import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] distances = new int[4];
        for (int i = 0; i < distances.length; i++)
            distances[i] = scan.nextInt();

        for (int city = 0; city < 5; city++)
            System.out.println(generateRow(city, distances));
    }

    public static String generateRow(int cityNumber, int[] distances) {
        StringBuilder rowBuilder = new StringBuilder();
        prependDistancesBeforeCity(rowBuilder, cityNumber, distances);
        appendDistancesAfterCity(rowBuilder, cityNumber, distances);
        return rowBuilder.toString().trim();
    }

    private static void prependDistancesBeforeCity(StringBuilder rowBuilder, int cityNumber, int[] distances) {
        int totalDist = 0;
        for(int i = cityNumber-1; i >= 0; i--) {
            totalDist += distances[i];
            rowBuilder.insert(0, totalDist + " ");
        }
    }

    private static void appendDistancesAfterCity(StringBuilder rowBuilder, int cityNumber, int[] distances) {
        int totalDist;
        totalDist = 0;
        rowBuilder.append(totalDist).append(" ");
        for (int i = cityNumber; i < distances.length; i++) {
            totalDist += distances[i];
            rowBuilder.append(totalDist).append(" ");
        }
    }
}
