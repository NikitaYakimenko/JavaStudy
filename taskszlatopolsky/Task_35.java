package taskszlatopolsky;

import taskszlatopolsky.support.Triangle;

public class Task_35 {
    public static void main(String[] args) {
        Triangle myTriangle = new Triangle(3.2, 4.5);
        System.out.println("Гипотенуза = " + myTriangle.getHypotenuse(myTriangle.getA(), myTriangle.getB()));
    }
}
