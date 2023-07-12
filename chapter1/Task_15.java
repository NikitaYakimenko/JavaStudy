package chapter1;

public class Task_15 {
    public static void main(String[] args) {
        double x = Math.random();

        double a = Math.random();
        double b = Math.random();
        double c = Math.random();

        double m = Math.random();
        double n = Math.random();


//        double x = 32.5;
//
//        double a = 53.2;
//        double b = 12.9;
//        double c = 41.2;
//
//        double m = 1.9;
//        double n = 3.2;

        // а
        System.out.println("а: " + -1 / Math.pow(x, 2) + "\n");

        // б
        System.out.println("б: " + a / (b * c) + "\n");

        // в
        System.out.println("в: " + (a / b) * c + "\n");

        // г
        System.out.println("г: " + (a + b) / 2 + "\n");

        // д
        System.out.println("д: " + 5.45 * ((a + 2 * b) / (2 - a)) + "\n");

        // е
        System.out.println("е: " + ((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2 * a) + "\n");

        // ж
        System.out.println("ж: " + (-b + 1/a) / (2 / c) + "\n");

        // з
        System.out.println("з: " + 1 / (1 + (a + b) / 2) + "\n");

        // и
        System.out.println("и: " + 1 / (1 + (1 / (2 + 1 / (2 + 3 / 5)))) + "\n");

        // к
        System.out.println("к: " + Math.pow(2, Math.pow(m, n)) + "\n");;
    }
}
