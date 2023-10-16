package zlatopolsky;

import java.util.Scanner;

public class Task_30 {
    public static void main(String[] args) {
        // а
        Scanner input = new Scanner(System.in);

        System.out.print("Введите x: ");
        double x = input.nextDouble();

        System.out.print("Введите y: ");
        double y = input.nextDouble();

        System.out.println("Значение функции при x = " + x + ", y = " + y + ": " + getZ(x, y));
    }

    private static String getZ(double x, double y) {
        return String.format("%.2f", Math.pow(x, 3) - 2.5 * x * y + 1.78 * Math.pow(x, 2) - 2.5 * y + 1);
    }
}
