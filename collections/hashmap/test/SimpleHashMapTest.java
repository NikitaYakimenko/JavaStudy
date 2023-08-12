package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {
    @Test
    void put() {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();

        myMap.put("1", "String_0"); // индекс: 1, первый узел
        assertEquals("String_0", myMap.get("1"));

        myMap.put("9", "String_1"); // индекс: 1, второй узел
        assertEquals("String_1", myMap.getNode("1").getNextNode().getValue());

        myMap.put("1", "String_2"); // индекс: 1, замена 1 узла
        assertEquals("String_2", myMap.getNode("1").getValue());
    }

//    @Test
//    void delete() {
//        SimpleHashMap<Integer, String> myMap = new SimpleHashMap<>();
//        myMap.put(1, "one");
//        myMap.delete(1, "one");
//
//        assertNull(myMap.get(1));
//    }

//    @Test
//    void containsKey() {
//        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();
//
//        String key = "myKey";
//        myMap.put(key, "String_0");
//
//        assertTrue(myMap.containsKey(key));
//    }
//
//    @Test
//    void size() {
//        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();
//        myMap.put("number_one", "1");
//
//        assertEquals(1, myMap.size());
//    }
//
//    @Test
//    void expand() {
//        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();
//        myMap.put("number_one", "1");
//        myMap.put("8", "");
//
//        assertEquals(8, myMap.getCapacity());
//    }
}
