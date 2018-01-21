import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int minutes = scan.nextInt();
        System.out.println(favouriteTimes(minutes));
    }
    
    public static int favouriteTimes(int minutes) {
        int rounds = minutes / (12*60);
        int currentRoundMinutes = minutes % (12*60);
        int[] timeMap = getTimeMap();
        int[] timeMapSubset = Arrays.copyOfRange(timeMap, 0, currentRoundMinutes+1);
        return getFavCount(timeMapSubset) + (getFavCount(timeMap) * rounds);
    }

    public static int getFavCount(int[] timeMap) {
        return Arrays.stream(timeMap).sum();
    }

    public static int[] getTimeMap() {
        int[] favMap = new int[12*60];
        for (int minutes = 0; minutes < 12*60; minutes++){
            int time = getClockFace(minutes);
            favMap[minutes] = isFavouriteTime(time) ? 1 : 0;
        }
        return favMap;
    }

    public static int getClockFace(int minutes) {
        return Integer.parseInt(getClockFaceHour(minutes)
                + getClockFaceMinutes(minutes));
    }

    private static String getClockFaceHour(int minutesElapsed) {
        int hours = minutesElapsed / 60 % 12;
        return hours == 0
                ? String.valueOf(12)
                : String.valueOf(hours);
    }

    private static String getClockFaceMinutes(int minutesElapsed) {
        int mins = minutesElapsed % 60;
        return mins < 10
                ? "0"+mins
                : String.valueOf(mins);
    }

    private static boolean isFavouriteTime(int time) {
        int[] digits = splitIntegerIntoIntegerDigitArray(time);
        for (int i = 0; i < digits.length-2; i++) {
            int diff1 = digits[i+1] - digits[i];
            int diff2 = digits[i+2] - digits[i+1];
            if (diff1 != diff2)
                return false;
        }
        return true;
    }

    private static int[] splitIntegerIntoIntegerDigitArray(int time) {
        return Arrays.stream(String.valueOf(time).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
