import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        System.out.println(quadrantSelect(x, y));
    }

    public static int quadrantSelect(int x, int y) {
        if (x > 0 && y > 0)
            return 1;
        else if (x < 0 & y > 0)
            return 2;
        else if (x < 0 && y < 0)
            return 3;
        else
            return 4;
    }
}
