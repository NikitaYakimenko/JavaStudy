package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {
    @Test
    void put() {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();

        myMap.put("1", "firstNodeValue"); // добавление нового узла
        assertEquals("firstNodeValue", myMap.get("1"));

        myMap.put("9", "secondNodeValue"); // добавление узла в список
        assertEquals("secondNodeValue", myMap.get("9"));

        myMap.put("1", "newFirstNodeValue"); // замена значения существующего узла
        assertEquals("newFirstNodeValue", myMap.get("1"));
    }

    @Test
    void get() {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();

        assertNull(myMap.get("1")); // пустой индекс

        myMap.put("1", "firstNodeValue");
        assertEquals("firstNodeValue", myMap.get("1")); // первый узел на индексе

        myMap.put("9", "secondNodeValue");
        assertEquals("secondNodeValue", myMap.get("9")); // второй узел на индексе

        myMap.put("12", "thirdNodeValue");
        assertEquals("thirdNodeValue", myMap.get("12")); // третий узел на индексе

        assertNull(myMap.get("23")); // несуществующий ключ в непустом индексе
    }

//    @Test
//    void delete() {
//        SimpleHashMap<Integer, String> myMap = new SimpleHashMap<>();
//        myMap.put(1, "one");
//        myMap.delete(1, "one");
//
//        assertNull(myMap.get(1));
//    }

    @Test
    void containsKey() {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();

        assertFalse(myMap.containsKey("1")); // ключ не содержится ни в одном узле связанных списков массива

        myMap.put("1", "");
        assertTrue(myMap.containsKey("1")); // ключ содержится в первом узле

        myMap.put("9", "");
        assertTrue(myMap.containsKey("9")); // ключ содержится в связанном узле
    }
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
