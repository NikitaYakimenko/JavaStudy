package collections.arraylist.test;

import collections.arraylist.SimpleArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SimpleArrayListPerformanceTest {
    ArrayList<Integer> list;
    SimpleArrayList<Integer> myList;

    @BeforeEach
    void prepareData() {
        list = new ArrayList<>();
        myList = new SimpleArrayList<>();
    }

    @Test
    void add() {
        // ArrayList
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        System.out.println("add(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }
        System.out.println("add(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void addToIndex() {
        // ArrayList
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i, i);
        }
        System.out.println("addToIndex(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i, i);
        }
        System.out.println("addToIndex(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void get() {
        // ArrayList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.get(i);
        }
        System.out.println("get(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.get(i);
        }
        System.out.println("get(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }
    @Test
    void remove() {
        // ArrayList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 999_999; i > 0; i--) {
            list.remove(i);
        }
        System.out.println("remove(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }
        start = System.currentTimeMillis();
        for (int i = 999_999; i > 0; i--) {
            myList.remove(i);
        }
        System.out.println("remove(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void contains() {
        // ArrayList
        for (int i = 0; i < 10_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.contains(i);
        }
        System.out.println("contains(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        for (int i = 0; i < 10_000; i++) {
            myList.add(i);
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            myList.contains(i);
        }
        System.out.println("contains(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void size() {
        // ArrayList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.size();
        }
        System.out.println("size(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.size();
        }
        System.out.println("size(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void isEmpty() {
        // ArrayList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.isEmpty();
        }
        System.out.println("isEmpty(): ArrayList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleArrayList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.isEmpty();
        }
        System.out.println("isEmpty(): SimpleArrayList took " + (System.currentTimeMillis() - start) + " ms");
    }
}
