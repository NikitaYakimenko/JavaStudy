package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // using class generics
        Printer<String> stringPrinter = new Printer<>("some string");
        stringPrinter.print();

        Printer<Integer> integerPrinter = new Printer<>(123);
        integerPrinter.print();

        // using method generics
        printSomething("some string", 123);
        printSomething(123, "some string");

        // using wild card
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        printList(intList);

        List<Printer> printlist = new ArrayList<>();
        printlist.add(new Printer<>("something"));
        printList(printlist);
    }

    private static <T, V> V printSomething(T something, V somethingMore) {
        System.out.println(something);
        return somethingMore;
    }

    private static void printList(List<?> someList) { // <?> = unknown type
        System.out.println(someList);
    }
}
