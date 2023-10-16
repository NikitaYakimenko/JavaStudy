package zlatopolsky;

public class Task_16 {
    public static void main(String[] args) {
        double a = Math.random();
        double b = Math.random();
        double c = Math.random();
        double d = Math.random();

        double x = Math.random();

        double R = Math.random();

        // а
        System.out.println("а: " + a / b / c + "\n");

        // б
        System.out.println("б: " + a * b / c + "\n");

        // в
        System.out.println("в: " + a / b * c + "\n");

        // г
        System.out.println("г: " + (a + b / c) + "\n");

        // д
        System.out.println("д: " + (a + b) / c + "\n");

        // е
        System.out.println("е: " + (a + b / b + c) + "\n");

        // ж
        System.out.println("ж: " + ((a + b) / (b + c)) + "\n");

        // з
        System.out.println("з: " + a / Math.sin(b) + "\n");

        // и
        System.out.println("и: " + ((double) 1 / 2) * a * b * Math.sin(x) + "\n");

        // к
        System.out.println("к: " + (2 * b * c * Math.cos((a / 2))) / (b + c) + "\n");

        // л
        System.out.println("л: " + 4 * R * Math.sin(a / 2) * Math.sin(b / 2) * Math.sin(c / 2) + "\n");

        // м
        System.out.println("м: " + (a * x + b) / (c * x + d) + "\n");

        // н
        System.out.println("н: " + 2 * Math.sin((a + b) / 2) * Math.cos((a - b) / 2) + "\n");

        // о
        System.out.println("о: " + Math.abs(2 * Math.sin(-3 * Math.abs(x / 2))) + "\n");
    }
}
