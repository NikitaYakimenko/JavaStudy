package taskszlatopolsky;

import java.util.Scanner;

public class Task_28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите высоту: ");
        double myCubeEdge = input.nextDouble();

        System.out.println("V куба со стороной " + myCubeEdge + " у.е. = " + getCubeV(myCubeEdge) + " у.е.");
        System.out.println("S поверхности куба со стороной " + myCubeEdge + " у.е. = " + getCubeS(myCubeEdge) + " у.е.");
    }

    private static String getCubeV(double cubeEdge) {
        return String.format("%.2f", Math.pow(cubeEdge, 3));
    }

    private static String getCubeS(double cubeEdge) {
        return String.format("%.2f", Math.pow(cubeEdge, 2) * 6);
    }
}
