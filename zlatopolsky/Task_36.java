package zlatopolsky;

import zlatopolsky.support.Circle;

public class Task_36 {
    public static void main(String[] args) {
        Circle myCircle = new Circle(4.4, 4.5);
        System.out.println("Площадь кольца = " + myCircle.getRingS(myCircle.getInternalR(), myCircle.getExternalR()));
    }
}
