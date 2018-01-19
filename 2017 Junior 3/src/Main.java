import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] start = createIntegerArrayFromSpaceSeparatedInput(scan);
        int[] end = createIntegerArrayFromSpaceSeparatedInput(scan);
        int charge = scan.nextInt();

        System.out.println(exactlyElectric(start, end, charge));

    }

    private static int[] createIntegerArrayFromSpaceSeparatedInput(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static char exactlyElectric(int[] startPos, int[] endPos, int charge) {
        int distanceX = Math.abs(endPos[0] - startPos[0]);
        int distanceY = Math.abs(endPos[1] - startPos[1]);
        int totalDistance = distanceX + distanceY;
        int remainingCharge = charge - totalDistance;

        if (remainingCharge >= 0 && remainingCharge % 2 == 0)
            return 'Y';
        return 'N';
    }
}
