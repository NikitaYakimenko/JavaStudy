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

        myMap.put(2, "anotherTwo");
        assertEquals("anotherTwo", myMap.get(2));
    }

    @Test
    void get() {
        assertNull(myMap.get(1));

        myMap.put(1, "one");
        assertEquals("one", myMap.get(1));
    }

    @Test
    void remove() {
        myMap.put(1, "one");
        myMap.put(2, "two");

        myMap.remove(1);
        assertNull(myMap.get(1));

        myMap.remove(2, "two");
        assertNull(myMap.get(2));
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
}
