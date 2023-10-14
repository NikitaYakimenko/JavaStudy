package collections.linkedlist.test;

import collections.linkedlist.SimpleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListPerformanceTest {
    LinkedList<Integer> list;
    SimpleLinkedList<Integer> myList;

    @BeforeEach
    void prepareData() {
        list = new LinkedList<>();
        myList = new SimpleLinkedList<>();
    }

    @Test
    void add() {
        // LinkedList
        long start = System.currentTimeMillis();
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
        long start = System.currentTimeMillis();
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
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
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
    void size() {
        // LinkedList
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
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
}