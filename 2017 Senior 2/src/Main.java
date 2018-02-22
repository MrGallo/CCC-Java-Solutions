import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

    private static TreeSet<Integer> set1;
    private static TreeSet<Integer> set2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanIntoTwoTreeSets(scanner);
        System.out.println(composeResponseString());
    }

    public static void scanIntoTwoTreeSets(Scanner scanner) {
        scanner.nextLine();  // throw-away first line

        set1 = new TreeSet<>();
        set2 = new TreeSet<>();

        int count = 0;
        while (scanner.hasNextInt()) {
            if (count % 2 == 0)
                set1.add(scanner.nextInt());
            else
                set2.add(scanner.nextInt());
        }
    }

    public static String composeResponseString() {
        String reorderedMeasurements = "";

        Integer[] highTideMeasurements;
        Integer[] lowTideMeasurements;
        if (set1.iterator().next() > set2.iterator().next()) {
            highTideMeasurements = set1.toArray(new Integer[]{});
            lowTideMeasurements = set2.toArray(new Integer[]{});
        } else {
            highTideMeasurements = set2.toArray(new Integer[]{});
            lowTideMeasurements = set1.toArray(new Integer[]{});
        }

        Integer[] longer;
        Integer[] shorter;

        if (highTideMeasurements.length > lowTideMeasurements.length) {
            longer = highTideMeasurements;
            shorter = lowTideMeasurements;
        } else {
            longer = lowTideMeasurements;
            shorter = highTideMeasurements;
        }

        if (highTideMeasurements.length != lowTideMeasurements.length) {
            reorderedMeasurements += longer[0] + " ";
            longer = Arrays.copyOfRange(longer, 1, longer.length);
        }

        for (int cursor1 = 0; cursor1 < shorter.length; cursor1++) {
            int cursor2 = (longer.length-1) - cursor1;
            reorderedMeasurements += shorter[cursor2] + " " + longer[cursor1];
            reorderedMeasurements += " ";
        }
        return reorderedMeasurements;
    }

    public static TreeSet<Integer> getSet1() {
        return set1;
    }

    public static TreeSet<Integer> getSet2() {
        return set2;
    }
}
