package zlatopolsky;

import java.util.Scanner;

public class Task_12 {
    public static void main(String[] args) {
        // а
        System.out.println("а:\n5 10\n7 см\n");

        // б
        System.out.print("б:\nВведите t: ");
        Scanner inputT = new Scanner(System.in);
        int t = inputT.nextInt();
        System.out.print("Введите v: ");
        Scanner inputV = new Scanner(System.in);
        int v = inputV.nextInt();
        System.out.println("100 " + t + "\n" + "1949 " + v + "\n");

        // в
        System.out.print("в:\nВведите x: ");
        Scanner inputX = new Scanner(System.in);
        int x = inputX.nextInt();
        System.out.print("Введите y: ");
        Scanner inputY = new Scanner(System.in);
        int y = inputY.nextInt();
        System.out.println(x + " 25" + "\n" + x + " " + y);
    }
}
