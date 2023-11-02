package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleHashMapPerformanceTest {
    Map<Integer, Integer> map;
    SimpleHashMap<Integer, Integer> myMap;
    long start;

    @BeforeEach
    void prepareData() {
        map = new HashMap<>();
        myMap = new SimpleHashMap<>();
    }

    @Test
    void put() {
        // HashMap
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }
        System.out.println("put(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleHashMap
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
            assertEquals(i, myMap.get(i));
        }
        System.out.println("put(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void get() {
        // HashMap
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.get(i);
        }
        System.out.println("get(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleHashMap
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.get(i);
        }
        System.out.println("get(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void remove() {
        // HashMap
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.remove(i);
        }
        System.out.println("remove(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleHashMap
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.remove(i);
        }
        System.out.println("remove(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void containsKey() {
        // HashMap
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            map.containsKey(i);
        }
        System.out.println("containsKey(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleHashMap
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.containsKey(i);
        }
        System.out.println("containsKey(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void size() {
        // HashMap
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            map.size();
        }
        System.out.println("size(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleHashMap
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.size();
        }
        System.out.println("size(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void isEmpty() {
        // HashMap
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            //noinspection ResultOfMethodCallIgnored
            map.isEmpty();
        }
        System.out.println("isEmpty(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        // SimpleHashMap
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.isEmpty();
        }
        System.out.println("isEmpty(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }
}
