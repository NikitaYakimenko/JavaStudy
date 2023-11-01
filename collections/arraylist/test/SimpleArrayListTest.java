package collections.arraylist.test;

import collections.arraylist.SimpleArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleArrayListTest {
    SimpleArrayList<String> myList;

    @BeforeEach
    void prepareData() {
        myList = new SimpleArrayList<>();
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
    void remove() {
        myList.add("zero");
        myList.add("one");

        myList.remove("zero");
        assertEquals("one", myList.get(0));

        myList.remove(0);
        assertNull(myList.get(0));
    }

    @Test
    void contains() {
        assertFalse(myList.contains("one"));

        myList.add("one");
        assertTrue(myList.contains("one"));
    }

    @Test
    void size() {
        assertEquals(0, myList.size());

        myList.add("zero");
        assertEquals(1, myList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myList.isEmpty());

        myList.add("zero");
        assertFalse(myList.isEmpty());
    }
}
