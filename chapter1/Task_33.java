package chapter1;

import java.util.Scanner;

public class Task_33 {
    public static void main(String[] args) {
        System.out.println("Плотность населения = " + getDensity(SaintPetersburg.citizens, SaintPetersburg.S) + " жителей");
    }

    private static int getDensity(int citizensNumber, double S) {
        return (int) (citizensNumber / S);
    }

    private static class SaintPetersburg {
        static int citizens = 5600044;
        static double S = 1439;
    }
}
