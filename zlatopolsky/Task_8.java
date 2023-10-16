package zlatopolsky;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        int[] numbers = new int[4];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Введите " + (i + 1) + " число: ");
            numbers[i] = input.nextInt();
        }

        int lastIndex = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != lastIndex) {
                System.out.print(" ");
            }
        }
    }
}
