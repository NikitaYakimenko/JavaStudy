package chapter1;

import java.util.Scanner;

public class Task_28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите высоту: ");
        double myCubeEdge = input.nextDouble();

        System.out.println("V куба со стороной " + myCubeEdge + " y.e. = " + getCubeV(myCubeEdge));
        System.out.println("S поверхности куба со стороной " + myCubeEdge + " y.e. = " + getCubeS(myCubeEdge));
    }
    private static double getCubeV(double cubeEdge) {
        return Math.pow(cubeEdge, 3);
    }
    private static double getCubeS(double cubeEdge) {
        return Math.pow(cubeEdge, 2) * 6;
    }
}
