package collections.hashmap;

import java.util.Arrays;
import static collections.hashmap.Node.setNextNode;

public class SimpleHashMap<K, V> {
    private Node[] map = new Node[4];

    void put(K key, V value) { // принимаем на вход любые типы
        if (checkOccupancy()) {
            addElements();
        }

        int hashcode = key.hashCode(); // берем хеш-код от ключа

        int index = (map.length - 1) & hashcode; // нормируем хеш-код в int для индекса

        if (index > map.length) {
            System.out.println("invalid index");
        }

        if (map[index] != null) {
            setNextNode(map[index], new Node<>(hashcode, key, value));
        } else {
            map[index] = new Node<>(hashcode, key, value);
        }

        System.out.println("PUT\nput value \"" + value + "\" to index " + index + "\nhashcode = " + hashcode);
        System.out.println(Arrays.toString(map) + "\n");
    }

    Object get(K key) {

        int hashcode = key.hashCode();

        int index = (map.length - 1) & hashcode;

        if (index > map.length) {
            System.out.println("error");
            return null;
        }

        System.out.println("GET\ngot value of index " + index + ": " + map[index] + " (value: \"" + map[index].getValue() + "\")" + "\nhashcode = " + hashcode + "\n");

        return map[index];
    }

    private boolean checkOccupancy() { // проверяем не заполнен ли массив
        boolean isFull = true;

        for (Object value : map) {
            if (value == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private void addElements() { // увеличиваем массив на четыре ячейки
        map = Arrays.copyOf(map, map.length + 4);
    }
}
