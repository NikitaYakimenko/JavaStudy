package chapter1;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        int[] numbers = new int[4];

        for (byte i = 0; i < numbers.length; i++) {
            System.out.print("Введите " + (i + 1) + " число: ");
            Scanner input = new Scanner(System.in);
            numbers[i] = input.nextInt();
        }

        for (byte i = 0; i < numbers.length; i++) {
            int lastIndex = numbers.length - 1;
            if (i == lastIndex) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
