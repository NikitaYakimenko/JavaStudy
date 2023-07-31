package taskszlatopolsky;

import java.text.DecimalFormat;

public class Task_1_2 {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1:");
        System.out.printf("%.2f%n", Math.PI);

        // Task 2
        System.out.println("\nTask 2:");
        DecimalFormat myFormat = new DecimalFormat("#.#");
        System.out.println(myFormat.format(Math.E));
    }
}
