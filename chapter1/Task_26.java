package chapter1;

import java.util.Scanner;

public class Task_26 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите радиус: ");
        double myCircleR = input.nextDouble();

        System.out.println("D окружности c радиусом " + myCircleR + " y.e. = " + getCircleD(myCircleR) + " y.e.");
    }
    private static double getCircleD(double circleR) {
        return 2 * circleR;
    }
}
