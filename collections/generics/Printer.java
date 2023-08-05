package collections.generics;

public class Printer <T> { // class uses any type
     T something;
     public Printer(T something) {
         this.something = something;
     }

     public void print() {
         System.out.println(something);
     }
}
