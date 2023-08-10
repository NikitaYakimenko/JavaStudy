package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {

    SimpleHashMap<Integer, String> myMap;

    @BeforeEach
    void prepareData() {
        myMap = new SimpleHashMap<>(1);
        myMap.put(0, "zero");
    }

    @Test
    void put() {
        myMap.put(1, "one");

        assertEquals("one", myMap.get(1));
    }

    @Test
    void get() {
        assertEquals("zero", myMap.get(0));
    }

    @Test
    void delete() {
        myMap.put(1, "one");
        myMap.delete(1, "one");

        assertNull(myMap.get(1));
    }

    @Test
    void containsKey() {
        assertTrue(myMap.containsKey(0));
    }

    @Test
    void size() {
        assertEquals(1, myMap.size());
    }

    @Test
    void expand() {
        myMap.put(1, "one");

        assertEquals(2, myMap.size());
    }
}
