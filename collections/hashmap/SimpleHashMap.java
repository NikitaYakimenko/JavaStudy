package collections.hashmap;

import java.util.Arrays;

import static collections.hashmap.Node.setNextNode;

class SimpleHashMap<K, V> {
    private int capacity = 4;
    private Node[] map = new Node[capacity];

    void put(K key, V value) { // принимаем на вход любые типы
        if (checkOccupancy()) {
            expand();
        }

        int hashcode = key.hashCode(); // берем хеш-код от ключа
        int index = (map.length - 1) & hashcode; // нормируем хеш-код в int для индекса
        final Node putNode; // переменная для логирования

        if (map[index] != null) {
            setNextNode(map[index], new Node<>(hashcode, key, value));
            putNode = map[index].nextNode;
        } else {
            map[index] = new Node<>(hashcode, key, value);
            putNode = map[index];
        }

        System.out.println("PUT \"" + putNode + "\"");
        System.out.println(Arrays.toString(map) + "\n");
    }

    Object get(K key) {
        int hashcode = key.hashCode();
        int index = (map.length - 1) & hashcode;

        if (map[index] == null) {
            System.out.println("node doesn't exist");
            return null;
        }

        System.out.println("GET \"" + map[index].getValue() + "\"\n");

        return map[index].getValue();
    }

    void delete(K key, V value) { // удаляем ноду по ключу и значению
        final String deletedNode = key + ": " + value;

        for (int i = 0; i <= map.length - 1; i++) {
            if (map[i] != null) {
                if (map[i].getKey().equals(key) & map[i].getValue().equals(value)) {
                    map[i] = null; // удаляем первую ноду
                } else if (map[i].nextNode != null) {
                    if (map[i].nextNode.getKey().equals(key) & map[i].nextNode.getValue().equals(value)) {
                        map[i].nextNode = null; // или удаляем ссылку на следующую ноду
                    }
                }
            }
        }

        System.out.println("DELETE \"" + deletedNode + "\"");
        System.out.println(Arrays.toString(map) + "\n");
    }

    int size() {
        int count = 0;

        for (Node node : map) {
            if (node != null) {
                count += 1;
            }
        }

        System.out.println("Size: " + count);
        return count;
    }

    boolean containsKey(K key) {
        boolean containsKey = false;

        for (int i = 0; i <= map.length - 1; i++) {
            if (map[i] != null) {
                if (map[i].getKey().equals(key)) {
                    containsKey = true;
                }
            }
        }

        System.out.println(containsKey);
        return containsKey;
    }

    private boolean checkOccupancy() { // проверяем не заполнен ли массив
        boolean isFull = true;

        for (Node node : map) {
            if (node == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private void expand() { // увеличиваем массив на четыре ячейки
        capacity += 4;
        System.out.println("map[] expanded: " + capacity);
        map = Arrays.copyOf(map, capacity);
    }
}
