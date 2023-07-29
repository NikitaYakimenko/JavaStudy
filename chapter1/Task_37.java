package chapter1;

public class Task_37 {
    public static void main(String[] args) {
        System.out.println("Периметр = " + getP(MyTriangle.a, MyTriangle.b, MyTriangle.c));
    }

    private static double getHypotenuse(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private static double getP(double a, double b, double c) {
        return a + b + c;
    }

    private static class MyTriangle {
        static double a = 3.2;
        static double b = 4.5;
        static double c = getHypotenuse(a, b);
    }
}
