import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPlanks = Integer.parseInt(scan.nextLine());  // throw-away variable

        Map<Integer, Integer> sortedPlanks = getPlankInputAndSort(scan);
        Map<Integer, Integer> fenceLengthByBoardHeight = getFenceLengthForEachBoardHeight(sortedPlanks);

        int longestLength = findLongestFence(fenceLengthByBoardHeight);
        int combinations = getFrequencyOfGivenLength(longestLength, fenceLengthByBoardHeight);
        System.out.println(longestLength + " " + combinations);
    }

    public static Map<Integer,Integer> getPlankInputAndSort(Scanner scan) {
        Map<Integer, Integer> sortedPlanks = new HashMap<>();
        while (scan.hasNextInt())
            sortAndAddLengthToSortedMap(sortedPlanks, scan.nextInt());
        return sortedPlanks;
    }

    private static void sortAndAddLengthToSortedMap(Map<Integer, Integer> plankQuantityMap, int length) {
        if (!plankQuantityMap.containsKey(length))
            plankQuantityMap.put(length, 1);
        else
            plankQuantityMap.put(length, plankQuantityMap.get(length) + 1);
    }

    public static Map<Integer,Integer> getFenceLengthForEachBoardHeight(Map<Integer, Integer> sortedPlanks) {
        HashMap<Integer, Integer> fenceLengthByBoardHeight = new HashMap<>();
        Integer[] lengths = getKeysAsIntegerArray(sortedPlanks);

        for (int i = 0; i < lengths.length; i++) {
            int firstPlankLength = lengths[i];

            // make pairs with itself
            int numberOfPairings = sortedPlanks.get(firstPlankLength) / 2;
            int boardHeight = firstPlankLength * 2;

            if (!fenceLengthByBoardHeight.containsKey(boardHeight))
                fenceLengthByBoardHeight.put(boardHeight, numberOfPairings);
            else
                fenceLengthByBoardHeight.put(boardHeight, fenceLengthByBoardHeight.get(boardHeight) + numberOfPairings);

            // make pairs with rest
            for (int j = i+1; j < lengths.length; j++) {
                int secondPlankLength = lengths[j];

                int height = firstPlankLength + secondPlankLength;
                if (!fenceLengthByBoardHeight.containsKey(height)) {
                    fenceLengthByBoardHeight.put(height, numOfPossiblePairings(sortedPlanks, firstPlankLength, secondPlankLength));
                } else {
                    fenceLengthByBoardHeight.put(height, fenceLengthByBoardHeight.get(height) + numOfPossiblePairings(sortedPlanks, firstPlankLength, secondPlankLength));
                }
            }
        }

        return fenceLengthByBoardHeight;
    }

    private static int numOfPossiblePairings(Map<Integer, Integer> sortedPlanks, int firstPlankLength, int secondPlankLength) {
        return Math.min(sortedPlanks.get(firstPlankLength), sortedPlanks.get(secondPlankLength));
    }

    private static Integer[] getKeysAsIntegerArray(Map<Integer, Integer> plankLengths) {
        Set<Integer> keys = plankLengths.keySet();
        Integer[] lengths = keys.toArray(new Integer[keys.size()]);
        return lengths;
    }

    public static int findLongestFence(Map<Integer, Integer> fenceHeightQuantities) {
        int largestLength = 0;
        for (int height : fenceHeightQuantities.keySet()) {
            if (fenceHeightQuantities.get(height) > largestLength)
                largestLength = fenceHeightQuantities.get(height);
        }
        return largestLength;
    }

    public static int getFrequencyOfGivenLength(int fenceLength, Map<Integer, Integer> fenceHeightQuantities) {
        int combinations = 0;
        for (int height : fenceHeightQuantities.keySet())
            if (fenceHeightQuantities.get(height) == fenceLength)
                combinations++;
        return combinations;
    }
}
