package taskszlatopolsky;

import taskszlatopolsky.support.Triangle;

public class Task_37 {
    public static void main(String[] args) {
        Triangle myTriangle = new Triangle(3.2, 4.5);
        double myTriangleHypotenuse = myTriangle.getHypotenuse(myTriangle.getA(), myTriangle.getB());

        System.out.println("Периметр = " + myTriangle.getP(myTriangle.getA(), myTriangle.getB(), myTriangleHypotenuse));
    }
}
