package taskszlatopolsky;

public class Task_34 {
    public static void main(String[] args) {
        double a = 3.2;
        double b = 4.5;

        System.out.println("Ответ: " + solveEquation(a, b));
    }

    private static double solveEquation(double a, double b) {
        double solution = 0;

        if (a != 0) {
            solution = -(b / a);
        } else {
            System.out.println("Division by zero");
        }

        return solution;
    }
}
