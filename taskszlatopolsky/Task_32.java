package taskszlatopolsky;

import java.util.Scanner;

public class Task_32 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите V: ");
        double V = input.nextDouble();

        System.out.print("Введите m: ");
        double m = input.nextDouble();

        System.out.println("Плотность = " + getP(V, m));
    }

    private static String getP(double V, double m) {
        return String.format("%.2f", V * m);
    }
}
