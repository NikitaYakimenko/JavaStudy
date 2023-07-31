package taskszlatopolsky;

import java.util.Scanner;

public class Task_26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите радиус: ");
        double myCircleR = input.nextDouble();

        System.out.println("D окружности c радиусом " + myCircleR + " у.е. = " + getCircleD(myCircleR) + " у.е.");
    }

    private static String getCircleD(double circleR) {
        return String.format("%.2f", 2 * circleR);
    }
}
