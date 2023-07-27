package chapter1;

import java.util.Scanner;

public class Task_29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите радиус: ");
        double myCircleR = input.nextDouble();

        System.out.println("Длина окружности с радиусом " + myCircleR + " у.е. = " + getCircleC(myCircleR) + " у.е.");
        System.out.println("Площадь круга с с радиусом " + myCircleR + " у.е. = " + getCircleS(myCircleR) + " у.е.");
    }

    private static String getCircleC(double circleR) {
        return String.format("%.2f", (2 * Math.PI * circleR));
    }

    private static String getCircleS(double circleR) {
        return String.format("%.2f", Math.PI * Math.pow(circleR, 2));
    }
}
