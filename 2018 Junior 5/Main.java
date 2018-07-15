import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static HashMap<Integer, ArrayList<Integer>> bookMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        System.out.println(result);
    }


    public static int shortestPathOfPage(int page) {
        HashMap<Integer, ArrayList<Integer>> bookMapClone = new HashMap<>(bookMap);
        return shortestPathOfPageHelper(page, bookMapClone);
    }

    private static int shortestPathOfPageHelper(int page, HashMap<Integer, ArrayList<Integer>> bookMap) {
        HashMap<Integer, ArrayList<Integer>> bookMapClone = new HashMap<>(bookMap);
        ArrayList<Integer> pageOptions = bookMapClone.get(page);
        ArrayList<Integer> pageOptionsClone = new ArrayList<>(pageOptions);

        if (pageOptions.contains(0))
            return 1;

        int minPath = Integer.MAX_VALUE;
        for (Integer option : pageOptionsClone) {
            pageOptions.remove(option);
            int path = 1 + shortestPathOfPageHelper(option, bookMapClone);
            if (path < minPath)
                minPath = path;
        }

        return minPath;
    }
}
