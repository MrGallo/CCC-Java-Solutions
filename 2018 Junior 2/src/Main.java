import java.util.Scanner;

public class Main {

    private static String yesterday;
    private static String today;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numSpots = scan.nextInt();
        yesterday = scan.next();
        today = scan.next();

        int total = 0;
        for (int spot = 0; spot < numSpots; spot += 1) {
            if (wasOccupiedBothDays(spot))
                total += 1;
        }

        System.out.println(total);
    }

    private static boolean wasOccupiedBothDays(int index) {
        boolean occupiedYesterday = yesterday.charAt(index) == 'C';
        boolean occupiedToday = today.charAt(index) == 'C';
        return occupiedYesterday && occupiedToday;
    }
}
