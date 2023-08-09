package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {

    static SimpleHashMap<Integer, String> myMap;

    @BeforeAll
    static void prepareData() {
        myMap = new SimpleHashMap<>();
        myMap.put(0, "zero");
    }

    @Test
    void put() {
        SimpleHashMap<Integer, String> myMap = new SimpleHashMap<>();
        myMap.put(0, "zero");

        assertEquals("zero", myMap.get(0));
    }

    @Test
    void expand() {
        SimpleHashMap<Integer, String> myMap = new SimpleHashMap<>();
        myMap.put(0, "zero");
        myMap.put(1, "one");
        myMap.put(2, "two");
        myMap.put(3, "three");
        myMap.put(4, "four");

        assertEquals(5, myMap.size());
        assertEquals("four", myMap.get(4));
    }
    @Test
    void get() {
        assertEquals("zero", myMap.get(0));
    }

    @Test
    void delete() {
        myMap.put(2, "two");
        myMap.delete(2, "two");

        assertNull(myMap.get(2));
    }

    @Test
    void containsKey() {
        assertTrue(myMap.containsKey(0));
    }

    @Test
    void size() {
        assertEquals(1, myMap.size());
    }
}