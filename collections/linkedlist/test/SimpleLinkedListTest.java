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

        myList.add(0, "newZero");
        assertEquals("newZero", myList.get(0));
    }

    @Test
    void get() {
        assertNull(myList.get(0));

        myList.add("zero");
        assertEquals("zero", myList.get(0));

        assertNull(myList.get(1));
    }

    @Test
    void size() {
        assertEquals(0, myList.size());

        myList.add("zero");
        assertEquals(1, myList.size());

        myList.add("one");
        assertEquals(2, myList.size());
    }
}