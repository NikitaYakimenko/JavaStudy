package chapter1;

import java.util.Scanner;

public class Task_27 {
    public static void main(String[] args) {
        int R = 6350;

        Scanner input = new Scanner(System.in);
        System.out.print("Введите высоту: ");
        double myHeight = input.nextDouble();

        System.out.println("Расстояние от точки с высотой " + myHeight + " км до горизонта Земли: " + getHorizonDistance(R, myHeight) + " км");
    }

    private static double getHorizonDistance(double planetR, double height) {
        double a = planetR;
        double b = planetR + height;

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
