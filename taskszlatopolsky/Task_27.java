package taskszlatopolsky;

import java.util.Scanner;

public class Task_27 {
    public static void main(String[] args) {
        int R = 6350;

        Scanner input = new Scanner(System.in);
        System.out.print("Введите высоту: ");
        double myHeight = input.nextDouble();

        System.out.println("Расстояние от точки с высотой " + myHeight + " км до горизонта Земли: " + getHorizonDistance(R, myHeight) + " км");
    }

    private static String getHorizonDistance(double planetR, double height) {
        double fullHeight = planetR + height;

        return String.format("%.2f", Math.sqrt(Math.pow(planetR, 2) + Math.pow(fullHeight, 2)));
    }
}
