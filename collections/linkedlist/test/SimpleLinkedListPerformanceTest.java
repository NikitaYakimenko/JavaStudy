package collections.linkedlist.test;

import collections.linkedlist.SimpleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class SimpleLinkedListPerformanceTest {
    LinkedList<Integer> list;
    SimpleLinkedList<Integer> myList;
    long start;

    @BeforeEach
    void prepareData() {
        list = new LinkedList<>();
        myList = new SimpleLinkedList<>();
    }

    @Test
    void add() {
        // LinkedList
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        System.out.println("add(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }
        System.out.println("add(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void addToIndex() {
        // LinkedList
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i, i);
        }
        System.out.println("addToIndex(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i, i);
        }
        System.out.println("addToIndex(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void get() {
        // LinkedList
        for (int i = 0; i < 10_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.get(i);
        }
        System.out.println("get(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 10_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            myList.get(i);
        }
        System.out.println("get(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void remove() {
        // LinkedList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.remove(Integer.valueOf(i));
        }
        System.out.println("remove(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.remove(i);
        }
        System.out.println("remove(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void removeFirst() {
        // LinkedList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.removeFirst();
        }
        System.out.println("removeFirst(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.removeFirst();
        }
        System.out.println("removeFirst(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void removeLast() {
        // LinkedList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            list.removeLast();
        }
        System.out.println("removeLast(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.removeLast();
        }
        System.out.println("removeLast(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void contains() {
        // LinkedList
        for (int i = 0; i < 1_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.contains(i);
        }
        System.out.println("contains(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 1_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            myList.contains(i);
        }
        System.out.println("contains(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void size() {
        // LinkedList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.size();
        }
        System.out.println("size(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.size();
        }
        System.out.println("size(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void isEmpty() {
        // LinkedList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            list.isEmpty();
        }
        System.out.println("isEmpty(): LinkedList took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleLinkedList
        for (int i = 0; i < 1_000_000; i++) {
            myList.add(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myList.isEmpty();
        }
        System.out.println("isEmpty(): SimpleLinkedList took " + (System.currentTimeMillis() - start) + " ms");
    }
}