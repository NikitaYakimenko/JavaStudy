package chapter1;

public class Task_36 {
    public static void main(String[] args) {
        System.out.println("Площадь кольца = " + getRingS(MyCircle.internalR, MyCircle.externalR));
    }

    private static double getRingS(double internalR, double externalR) {
        double internalS = Math.PI * Math.pow(internalR, 2);
        double externalS = Math.PI * Math.pow(externalR, 2);

        return externalS - internalS;
    }

    private static class MyCircle {
        static double internalR = 4.4;
        static double externalR = 4.5;
    }
}
