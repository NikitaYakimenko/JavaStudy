package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleHashMapPerformanceTest {
    Map<Integer, Integer> map;
    SimpleHashMap<Integer, Integer> myMap;

    @BeforeEach
    void prepareData() {
        map = new HashMap<>();
        myMap = new SimpleHashMap<>();
    }

    @Test
    void put() {
        myMap = new SimpleHashMap<>(1_000_000);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }
        System.out.println("put(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }
        System.out.println("put(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void get() {
        map.put(1, 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.get(1);
        }
        System.out.println("get(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        myMap.put(1, 1);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.get(1);
        }
        System.out.println("get(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void remove() {
        for (int i = 0; i < 10_000; i++) {
            map.put(i, i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            map.remove(i);
        }
        System.out.println("remove(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        for (int i = 0; i < 10_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            myMap.remove(i);
        }
        System.out.println("remove(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void containsKey() {
        map.put(1, 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.containsKey(1);
        }
        System.out.println("containsKey(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        myMap.put(1, 1);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.containsKey(1);
        }
        System.out.println("containsKey(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }

    @Test
    void size() {
        for (int i = 0; i < 1_000_000; i++) {
            map.put(i, i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            map.size();
        }
        System.out.println("size(): HashMap took " + (System.currentTimeMillis() - start) + " ms");

        myMap = new SimpleHashMap<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            myMap.size();
        }
        System.out.println("size(): SimpleHashMap took " + (System.currentTimeMillis() - start) + " ms");
    }
}
