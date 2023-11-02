package collections.linkedlist.test;

import collections.linkedlist.SimpleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {
    SimpleLinkedList<String> myList;

    @BeforeEach
    void prepareData() {
        myList = new SimpleLinkedList<>();
    }

    @Test
    void add() {
        myList.add("zero");
        assertEquals("zero", myList.get(0));

        myList.add("one");
        assertEquals("one", myList.get(1));

        myList.add(2, "two");
        assertEquals("two", myList.get(2));

        myList.add(0, "newZero");
        assertEquals("newZero", myList.get(0));
    }

    @Test
    void get() {
        assertNull(myList.get(0));

        myList.add("zero");
        assertEquals("zero", myList.get(0));

        myList.add("one");
        assertEquals("one", myList.get(1));

        myList.add("two");
        assertEquals("two", myList.get(2));

        assertNull(myList.get(3));
    }

    @Test
    void remove() {
        myList.add("zero");
        myList.add("one");
        myList.add("two");

        myList.remove("one");
        assertEquals("two", myList.get(1));
    }

    @Test
    void removeFirst() {
        myList.add("zero");
        myList.add("one");
        myList.add("two");

        myList.removeFirst();
        assertEquals("one", myList.get(0));
    }

    @Test
    void removeLast() {
        myList.add("zero");
        myList.add("one");
        myList.add("two");

        myList.removeLast();
        assertNull(myList.get(2));
    }

    @Test
    void contains() {
        assertFalse(myList.contains("zero"));

        myList.add("zero");
        assertTrue(myList.contains("zero"));
    }

    @Test
    void size() {
        assertEquals(0, myList.size());

        myList.add("zero");
        assertEquals(1, myList.size());

        myList.add("one");
        myList.add("two");
        myList.add("three");
        assertEquals(4, myList.size());

        myList.remove("two");
        assertEquals(3, myList.size());

        myList.removeFirst();
        assertEquals(2, myList.size());

        myList.removeLast();
        assertEquals(1, myList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myList.isEmpty());

        myList.add("zero");
        assertFalse(myList.isEmpty());

        myList.remove("zero");
        assertTrue(myList.isEmpty());
    }
}