package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {
    SimpleHashMap<Integer, String> myMap;

    @BeforeEach
    void prepareData() {
        myMap = new SimpleHashMap<>();
    }

    @Test
    void put() {
        myMap.put(1, "one");
        assertEquals("one", myMap.get(1));

        myMap.put(2, "two");
        assertEquals("two", myMap.get(2));
    }

    @Test
    void get() {
        assertNull(myMap.get(1));

        myMap.put(1, "one");
        assertEquals("one", myMap.get(1));

        myMap.put(2, "two");
        assertEquals("two", myMap.get(2));
    }

    @Test
    void remove() {
        myMap.put(1, "one");

        myMap.remove(1);
        assertNull(myMap.get(1));
    }

    @Test
    void removeVal() {
        myMap.put(1, "one");
        myMap.remove(1, "one");

        assertNull(myMap.get(1));
    }

    @Test
    void replace() {
        myMap.put(1, "one");
        myMap.replace(1, "one", "newOne");

        assertEquals("newOne", myMap.get(1));
    }

    @Test
    void containsKey() {
        assertFalse(myMap.containsKey(1));

        myMap.put(1, "one");
        assertTrue(myMap.containsKey(1));

        myMap.put(2, "two");
        assertTrue(myMap.containsKey(2));
    }

    @Test
    void size() {
        myMap.put(1, "one");
        assertEquals(1, myMap.size());

        myMap.put(2, "two");
        assertEquals(2, myMap.size());

        myMap.remove(1);
        assertEquals(1, myMap.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myMap.isEmpty());

        myMap.put(1, "one");
        assertFalse(myMap.isEmpty());
    }

    @Test
    void flow() {
        for (int i = 0; i < 1000; i++) {
            myMap.put(i, String.valueOf(i));
            assertEquals(String.valueOf(i), myMap.get(i));
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(String.valueOf(i), myMap.get(i));
        }

        for (int i = 0; i < 500; i++) {
            myMap.remove(i);
            assertNull(myMap.get(i));
        }

        for (int i = 0; i < 500; i++) {
            assertNull(myMap.get(i));
        }

        for (int i = 500; i < 1000; i++) {
            myMap.remove(i, String.valueOf(i));
            assertNull(myMap.get(i));
        }

        for (int i = 500; i < 1000; i++) {
            assertNull(myMap.get(i));
        }
    }
}
