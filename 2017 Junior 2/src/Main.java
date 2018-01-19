import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int times = scan.nextInt();

        System.out.println(shiftySum(num, times));
    }

    public static int shiftySum(int num, int times) {
        int sum = num;

        while (times >= 1) {
            int tenPowerTimes = (int) Math.pow(10, times);
            sum += num * tenPowerTimes;
            times--;
        }
        return sum;
    }
}
