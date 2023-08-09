package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {

    static SimpleHashMap<Integer, String> myMap;

    @BeforeAll
    static void prepareData() {
        myMap = new SimpleHashMap<>(1);
        myMap.put(0, "zero");
    }

    @Test
    void put() {
        SimpleHashMap<Integer, String> myMap = new SimpleHashMap<>(1);
        myMap.put(0, "zero");

        assertEquals("zero", myMap.get(0));
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
        SimpleHashMap<Integer, String> myMap = new SimpleHashMap<>(3);
        myMap.put(0, "zero");

        assertEquals(1, myMap.size());
    }

    @Test
    void expand() {
        myMap.put(1, "one");

        assertEquals(2, myMap.size());
    }
}