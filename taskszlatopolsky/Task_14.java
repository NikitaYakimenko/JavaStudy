package taskszlatopolsky;

public class Task_14 {
    public static void main(String[] args) {
        double x = Math.random();
        double y = Math.random();

        double a = Math.random();
        double b = Math.random();

        double n = -Math.random();

        // а
        System.out.println("\nа: " + 2 * x + "\n");

        // б
        System.out.println("б: " + Math.sin(x) + "\n");

        // в
        System.out.println("в: " + Math.pow(a, 2) + "\n");

        // г
        System.out.println("г: " + Math.sqrt(x) + "\n");

        // д
        System.out.println("д: " + Math.abs(n) + "\n");

        // е
        System.out.println("е: " + 5 * Math.cos(y) + "\n");

        // ж
        System.out.println("ж: " + -7.5 * Math.pow(a, 2) + "\n");

        // з
        System.out.println("з: " + 3 * Math.sqrt(x) + "\n");

        // и
        System.out.println("и: " + (Math.sin(a) * Math.cos(b) + Math.cos(a) * Math.sin(b)) + "\n");

        // к
        System.out.println("к: " + a * Math.sqrt(2 * b) + "\n");

        // л
        System.out.println("л: " + (3 * Math.sin(2 * a) * Math.cos(3 * b)) + "\n");

        // м
        System.out.println("м: " + -5 * Math.sqrt(x + Math.sqrt(y)));
    }
}
