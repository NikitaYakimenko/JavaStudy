package collections.hashmap.test;

import collections.hashmap.Node;
import collections.hashmap.SimpleHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

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

        ArrayList<Node<String, String>> expected = new ArrayList<>(); // заготовка для проверки
        expected.add(new Node<>("1", "one"));
        expected.add(new Node<>("9", "nine"));

        try {
            Method method = SimpleHashMap.class.getDeclaredMethod("getBucket", int.class);
            method.setAccessible(true);
            assertEquals(expected.toString(), method.invoke(myMap, 1).toString()); // второй узел добавлен в конец списка
        }
        catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

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

    @Test
    void remove() {
        myMap.put("1", "one");

        myMap.remove("1"); // первый и единственный узел на индексе
        assertNull(myMap.get("1")); // на индексе пусто

        myMap.put("1", "one");
        myMap.put("9", "nine");
        myMap.put("12", "twelve");
        myMap.put("23", "twenty three");
        // на индексе сформирован список узлов

        myMap.remove("1"); // первый, но не единственный узел на индексе

        ArrayList<Node<String, String>> expected = new ArrayList<>(); // заготовка для проверки
        expected.add(new Node<>("9", "nine"));
        expected.add(new Node<>("12", "twelve"));
        expected.add(new Node<>("23", "twenty three"));

        try {
            Method method = SimpleHashMap.class.getDeclaredMethod("getBucket", int.class);
            method.setAccessible(true);
            assertEquals(expected.toString(), method.invoke(myMap, 1).toString()); // удален первый узел, остальные узлы сохранены
        }
        catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        myMap.remove("12"); // не первый узел на индексе
        expected.remove(1);
        try {
            Method method = SimpleHashMap.class.getDeclaredMethod("getBucket", int.class);
            method.setAccessible(true);
            assertEquals(expected.toString(), method.invoke(myMap, 1).toString()); // удален второй узел, остальные узлы сохранены
        }
        catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        myMap.remove("2"); // удаление несуществующего ключа не производит никаких действий
        assertNull(myMap.get("2"));
    }

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
        myMap.put("9", "nine");

        try {
            Method method = SimpleHashMap.class.getDeclaredMethod("getFirstNodeInBucket", int.class);
            method.setAccessible(true);
            assertEquals("1: one", method.invoke(myMap, 1).toString()); // вызов по существующему индексу
        }
        catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        try {
            Method method = SimpleHashMap.class.getDeclaredMethod("getFirstNodeInBucket", int.class);
            method.setAccessible(true);
            assertNull(method.invoke(myMap, 2)); // вызов по несуществующему индексу
        }
        catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    @Test
    void getBucket() {
        myMap.put("1", "one");
        myMap.put("9", "nine");

        ArrayList<Node<String, String>> expected = new ArrayList<>(); // заготовка для проверки
        expected.add(new Node<>("1", "one"));
        expected.add(new Node<>("9", "nine"));

        try {
            Method method = SimpleHashMap.class.getDeclaredMethod("getBucket", int.class);
            method.setAccessible(true);
            assertEquals(expected.toString(), method.invoke(myMap, 1).toString()); // последовательность узлов получена
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    @Test
    void size() {
        myMap.put("1", "one"); // первый узел на индексе 1
        assertEquals(1, myMap.size());

        myMap.put("9", "nine"); // второй узел на индексе 1
        assertEquals(2, myMap.size());

        myMap.put("2", "two"); // первый узел на индексе 2
        assertEquals(3, myMap.size());

        myMap.remove("1"); // удаляем один из узлов
        assertEquals(2, myMap.size());
    }

    @Test
    void expand() {
        int initialCapacity = myMap.getCapacity(); // начальная вместимость

        for (int i = 0; i <= initialCapacity - 1; i++) { // заполняем первый уровень каждой ячейки узлами
            myMap.put(Integer.toString(i), "");
        }

        assertEquals(myMap.getCapacity(), initialCapacity); // вместимость не увеличена

        myMap.put("8", ""); // добавляем еще один узел
        assertTrue(myMap.getCapacity() > initialCapacity); // вместимость увеличена

        initialCapacity = myMap.getCapacity();

        for (int i = 8; i <= initialCapacity - 1; i++) { // заполняем узлами до следующей необходимости в расширении вместимости
            myMap.put(Integer.toString(i), "");
        }

        myMap.put("10", ""); // добавляем еще один узел
        assertTrue(myMap.getCapacity() > initialCapacity); // вместимость увеличена
    }
}
