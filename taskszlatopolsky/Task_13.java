package taskszlatopolsky;

import java.util.Scanner;

public class Task_13 {
    public static void main(String[] args) {
        // а
        System.out.println("а:\n2 кг\n13 17\n");

        // б
        System.out.print("б:\nВведите a: ");
        Scanner inputA = new Scanner(System.in);
        int a = inputA.nextInt();
        System.out.print("Введите b: ");
        Scanner inputB = new Scanner(System.in);
        int b = inputB.nextInt();
        System.out.println(a + " 1\n19 " + b + "\n");

        // в
        System.out.print("в:\nВведите x: ");
        Scanner inputX = new Scanner(System.in);
        int x = inputX.nextInt();
        System.out.print("Введите y: ");
        Scanner inputY = new Scanner(System.in);
        int y = inputY.nextInt();
        System.out.println(x + " " + y + "\n5 " + y);
    }
}
