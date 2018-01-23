import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPlanks = Integer.parseInt(scan.nextLine());  // throw-away variable
        List<Integer> planks = convertStringInputToIntegerList(scan.nextLine());
        Map<Integer, Integer> plankQuantities = sortPlanks(planks);
        Map<Integer, Integer> fenceHeightQuantities = getFenceHeightQuantityMap(plankQuantities);
        int longestFence = findLongestFence(fenceHeightQuantities);
        int combinations = getNumberOfCombinationsOfGivenLength(longestFence, fenceHeightQuantities);
        System.out.println(longestFence + " " + combinations);
    }

    public static Map<Integer,Integer> sortPlanks(List<Integer> plankLengths) {
        Map<Integer, Integer> plankQuantityMap = new HashMap<>();
        for (int length : plankLengths)
            addLengthToQuantityMap(plankQuantityMap, length);
        return plankQuantityMap;
    }

    private static void addLengthToQuantityMap(Map<Integer, Integer> plankQuantityMap, int length) {
        if (!plankQuantityMap.containsKey(length))
            plankQuantityMap.put(length, 1);
        else
            plankQuantityMap.put(length, plankQuantityMap.get(length) + 1);
    }

    private static List<Integer> convertStringInputToIntegerList(String plankLengthsString) {
        return Arrays.stream(plankLengthsString.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Map<Integer,Integer> getFenceHeightQuantityMap(Map<Integer, Integer> plankLengths) {
        HashMap<Integer, Integer> fenceHeightQuantities = new HashMap<>();

        Integer[] lengths = getIntegerArrayFromKeySet(plankLengths);
        for (int i = 0; i < lengths.length; i++) {
            int length = lengths[i];
            for (int j = i; j < lengths.length; j++) {
                int otherLength = lengths[j];
                // make pairs with itself
                if (length == otherLength) {
                    if (!fenceHeightQuantities.containsKey(length*2))
                        fenceHeightQuantities.put(length*2, plankLengths.get(length) / 2);
                    else
                        fenceHeightQuantities.put(length*2, fenceHeightQuantities.get(length*2) + plankLengths.get(length)/2);
                } else {
                    // make pairs with rest
                    int comboLength = length + otherLength;
                    if (!fenceHeightQuantities.containsKey(comboLength)) {
                        fenceHeightQuantities.put(comboLength, Math.min(plankLengths.get(length), plankLengths.get(otherLength)));
                    } else {
                        fenceHeightQuantities.put(comboLength, fenceHeightQuantities.get(comboLength) + Math.min(plankLengths.get(length), plankLengths.get(otherLength)));
                    }
                }
            }
        }
        return fenceHeightQuantities;
    }

    private static Integer[] getIntegerArrayFromKeySet(Map<Integer, Integer> plankLengths) {
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

    public static int getNumberOfCombinationsOfGivenLength(int fenceLength, Map<Integer, Integer> fenceHeightQuantities) {
        int combinations = 0;
        for (int height : fenceHeightQuantities.keySet())
            if (fenceHeightQuantities.get(height) == fenceLength)
                combinations++;
        return combinations;
    }
}
