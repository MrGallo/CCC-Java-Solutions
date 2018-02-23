import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int mid1 = input.nextInt();
        int mid2 = input.nextInt();
        int last = input.nextInt();

        if(isTelemarketer(first, mid1, mid2, last))
            System.out.println("ignore");
        else
            System.out.println("answer");
    }

    public static boolean isTelemarketer(int first, int mid1, int mid2, int last) {
        return (first == 9 || first == 8)       // first property
                && mid1 == mid2                 // second property
                && (last == 8 || last == 9);    // third property
    }
}
