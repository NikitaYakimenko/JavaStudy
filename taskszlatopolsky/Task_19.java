package taskszlatopolsky;

public class Task_19 {
    public static void main(String[] args) {
        double x;
        int k;

        // а
        x = 10;
        x = -10;
        System.out.println(x); // -10

        // б
        x = 17.5;
        x = -2 * x;
        System.out.println(x); // -35

        // в
        x = 60;
        x = x - 1;
        x = 0;
        System.out.println(x); // 0

        // г
        x = -50;
        x = -25;
        k = 0;
        x = x + k;
        System.out.println(x); // -25 + k
    }
}
