package chapter1;

import java.util.Scanner;

public class Task_25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите грань: ");
        double mySquareEdge = input.nextDouble();

        System.out.println("P квадрата со стороной " + mySquareEdge + " y.e. = " + getSquareP(mySquareEdge) + " y.e.");
    }
    private static double getSquareP(double squareEdge) {
        return 4 * squareEdge;
    }
}
