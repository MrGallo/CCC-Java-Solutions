import java.util.Scanner;

public class Main {

    public static int[][] grid;

    public static void main(String[] strings) {
        getGridFromUserInput();

        while (gridNotRotatedProperly())
            rotateGrid();

        printGrid();
    }

    private static void getGridFromUserInput() {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        grid = new int[size][size];
        for (int row = 0; row < size; row++)
            for (int i = 0; i < size; i++)
                grid[row][i] = scan.nextInt();
    }

    private static boolean gridNotRotatedProperly() {
        return !leftColumnInOrder() || !allRowsInOrder();
    }

    public static boolean leftColumnInOrder() {
        for (int row = 0; row < grid.length - 1; row++)
            if (currentSunflowerLargerThanTheNext(row))
                return false;

        return true;
    }

    private static boolean currentSunflowerLargerThanTheNext(int row) {
        return !(grid[row][0] < grid[row+1][0]);
    }

    public static boolean allRowsInOrder() {
        for (int row = 0; row < grid.length; row++)
            if (!isRowInOrder(row))
                return false;

        return true;
    }

    public static boolean isRowInOrder(int row) {
        for (int i = 0; i < grid.length-1; i++)
            if (!(grid[row][i] < grid[row][i+1]))
                return false;

        return true;
    }

    public static void rotateGrid() {
        int[][] newGrid = new int[grid.length][grid.length];

        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid.length; col++)
                newGrid[row][col] = grid[col][grid.length-1-row];

        grid = newGrid;
    }

    private static void printGrid() {
        for (int[] row : grid) {
            for (int i = 0; i < grid.length; i++) {
                System.out.print(row[i]);
                if (notLastElement(i))
                    System.out.print(" ");
            }
            System.out.print("\r\n");
        }
    }

    private static boolean notLastElement(int i) {
        return i != grid.length - 1;
    }
}
