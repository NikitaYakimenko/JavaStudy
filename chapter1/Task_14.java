package chapter1;

import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args) {
        // а
        System.out.print("а:\nВведите x: ");
        Scanner inputX = new Scanner(System.in);
        double x = inputX.nextDouble();
        System.out.println(2 * x);

        // б
        System.out.println("б:\n" + Math.sin(x) + "\n");

        // в
        System.out.println("в:\n" + Math.pow(x, 2) + "\n");

        // г
        System.out.println("г:\n" + Math.sqrt(x) + "\n");

        // д
        System.out.println("д:\n" + Math.abs(x) + "\n");

        // е
        System.out.println("е:\n" + 5 * Math.cos(x) + "\n");

        // ж
        System.out.println("ж:\n" + -7.5 * Math.pow(x, 2) + "\n");

        // з
        System.out.println("з:\n" + 3 * Math.sqrt(x) + "\n");

        // и
        System.out.print("и:\nВведите y: ");
        Scanner inputY = new Scanner(System.in);
        double y = inputY.nextDouble();
        System.out.println((Math.sin(x) * Math.cos(y) + Math.cos(x) * Math.sin(y)) + "\n");

        // к
        System.out.println("к:\n" + x * Math.sqrt(2 * y) + "\n");

        // л
        System.out.println("л:\n" + (3 * Math.sin(2 * x) * Math.cos(3 * y)) + "\n");

        // м
        System.out.println("м:\n" + -5 * Math.sqrt(x + Math.sqrt(y)));
    }
}
