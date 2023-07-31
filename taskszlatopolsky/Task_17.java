package taskszlatopolsky;

public class Task_17 {
    public static void main(String[] args) {
        double x1 = Math.random();
        double x2 = Math.random();
        double x3 = Math.random();

        double v0 = Math.random();
        double t = Math.random();
        double a = Math.random();
        double b = Math.random();
        double c = Math.random();

        double m = Math.random();
        double v = Math.random();
        double g = Math.random();
        double h = Math.random();

        double R = Math.random();
        double R1 = Math.random();
        double R2 = Math.random();
        double I = Math.random();

        double x = Math.random();
        double y = Math.random();
        double m1 = Math.random();
        double m2 = Math.random();
        double r = Math.random();
        double d = Math.random();

        // а
        System.out.println("а: " + Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2)) + "\n");

        // б
        System.out.println("б: " + (x1 * x2 + x1 * x3 + x2 * x3) + "\n");

        // в
        System.out.println("в: " + (v0*t + (a * Math.pow(t, 2)) / 2) + "\n");

        // г
        System.out.println("г: " + ((m * Math.pow(v, 2) / 2) + (m * g * h)) + "\n");

        // д
        System.out.println("д: " + ((1 / R1) + (1 / R2)) + "\n");

        // е
        System.out.println("е: " + m * g * Math.cos(a) + "\n");

        // ж
        System.out.println("ж: " + 2 * Math.PI * R + "\n");

        // з
        System.out.println("з: " + (Math.pow(b, 2) - 4 * a * c) + "\n");

        // и
        System.out.println("и: " + y * m1 * m2 / Math.pow(r, 2) + "\n");

        // к
        System.out.println("к: " + Math.pow(I, 2) * R + "\n");

        // л
        System.out.println("л: " + a * b * Math.sin(c) + "\n");

        // м
        System.out.println("м: " + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(c)) + "\n");

        // н
        System.out.println("н: " + (a * d + b * c) / a * d + "\n");

        // о
        System.out.println("о: " + Math.sqrt(1 - Math.pow(Math.sin(x), 2)));
    }
}
