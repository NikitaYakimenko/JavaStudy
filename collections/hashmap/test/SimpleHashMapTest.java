package collections.hashmap.test;

import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {
    SimpleHashMap<String, String> myMap;
    @BeforeEach
    void prepareData() {
        myMap = new SimpleHashMap<>();
    }
    @Test
    void put() {
        myMap.put("1", "one"); // добавление нового узла
        assertEquals("one", myMap.get("1"));

        myMap.put("9", "nine"); // добавление узла в список
        assertEquals("nine", myMap.get("9"));

        myMap.put("1", "newOne"); // замена значения существующего узла
        assertEquals("newOne", myMap.get("1"));
    }

    @Test
    void get() {
        assertNull(myMap.get("1")); // пустой индекс

        myMap.put("1", "one");
        assertEquals("one", myMap.get("1")); // первый узел на индексе

        myMap.put("9", "nine");
        assertEquals("nine", myMap.get("9")); // второй узел на индексе

        myMap.put("12", "twelve");
        assertEquals("twelve", myMap.get("12")); // третий узел на индексе

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
        assertFalse(myMap.containsKey("1")); // ключ не содержится ни в одном узле связанных списков массива

        myMap.put("1", "one");
        assertTrue(myMap.containsKey("1")); // ключ содержится в первом узле

        myMap.put("9", "nine");
        assertTrue(myMap.containsKey("9")); // ключ содержится в связанном узле
    }

    @Test
    void getFirstNodeInBucket() {
        myMap.put("1", "one");
        assertEquals("1: one", myMap.getFirstNodeInBucket("1").toString()); // вызов по ключу первого узла

        myMap.put("9", "9");
        assertEquals("1: one", myMap.getFirstNodeInBucket("9").toString()); // вызов по ключу второго узла

        assertNull(myMap.getFirstNodeInBucket("12")); // вызов по ключу несуществующего узла
    }

    @Test
    void getBucket() {
        myMap.put("1", "one");
        assertEquals("1: one", myMap.getBucket("1")); // вызов по ключу первого узла

        myMap.put("9", "nine");
        assertEquals("1: one; 9: nine", myMap.getBucket("9")); // вызов по ключу второго узла

        myMap.put("12", "twelve");
        assertEquals("1: one; 9: nine; 12: twelve", myMap.getBucket("12")); // вызов по ключу третьего узла

        assertNull(myMap.getBucket("23")); // вызов по ключу несуществующего узла
    }

    @Test
    void size() {
        myMap.put("1", "one"); // первый узел на индексе 1
        assertEquals(1, myMap.size());

        myMap.put("9", "nine"); // второй узел на индексе 1
        assertEquals(2, myMap.size());

        myMap.put("2", "two"); // первый узел на индексе 2
        assertEquals(3, myMap.size());
    }

    @Test
    void expand() {
        int initialCapacity = myMap.getCapacity(); // начальная вместимость

        for (int i = 0; i <= initialCapacity - 1; i++) { // заполняем первый уровень каждой ячейки узлами
            myMap.put(Integer.toString(i), "");
        }

        assertEquals(initialCapacity, myMap.getCapacity()); // вместимость не увеличена

        int expandedCapacity = initialCapacity + 2;

        myMap.put("8", ""); // добавляем еще один узел
        assertEquals(expandedCapacity, myMap.getCapacity()); // вместимость увеличена

        for (int i = 8; i <= expandedCapacity - 1; i++) { // заполняем узлами до следующей необходимости в расширении вместимости
            myMap.put(Integer.toString(i), "");
        }

        expandedCapacity += 2;

        myMap.put("10", ""); // добавляем еще один узел
        assertEquals(expandedCapacity, myMap.getCapacity()); // вместимость увеличена
    }
}
