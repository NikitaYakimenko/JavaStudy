package chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Task_31 {
    public static void main(String[] args) {
        int[] numbers = new int[2];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Введите " + (i + 1) + " число: ");
            numbers[i] = input.nextInt();
        }

        // а
        System.out.println("Среднее арифметическое = " + getAverage(numbers));

        // б
        System.out.println("Среднее геометрическое = " + getGeometricMean(numbers));
    }

    private static String getAverage(int[] numbers) {
        double average = (double) Arrays.stream(numbers).sum() / 2;
        return String.format("%.2f", average);
    }

    private static String getGeometricMean(int[] numbers) {
        int production = 1;

        for (int number : numbers) {
            production *= number;
        }

        double geometricMean = Math.pow(production, 1.0/numbers.length);

        return String.format("%.2f", geometricMean);
    }
}
