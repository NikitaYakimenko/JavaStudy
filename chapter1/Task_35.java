package chapter1;

public class Task_35 {
    public static void main(String[] args) {
        System.out.println("Гипотенуза = " + getHypotenuse(MyTriangle.a, MyTriangle.b));
    }

    private static double getHypotenuse(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private static class MyTriangle {
        static double a = 3.2;
        static double b = 4.5;
    }
}
