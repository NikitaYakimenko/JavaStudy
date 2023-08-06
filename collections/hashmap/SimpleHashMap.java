package collections.hashmap;

import java.util.Arrays;

import static collections.hashmap.Node.setNextNode;

class SimpleHashMap<K, V> {
    private int size = 4;
    private Node[] map = new Node[size];

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

        System.out.println("PUT\nput node \"" + putNode + "\" to index " + index + "\nhashcode = " + hashcode);
        System.out.println(Arrays.toString(map) + "\n");
    }

    Node get(K key) {
        int hashcode = key.hashCode();
        int index = (map.length - 1) & hashcode;

        if (map[index] == null) {
            System.out.println("node doesn't exist");
            return null;
        }

        System.out.println("GET\ngot node of index " + index + ": \"" + map[index] + "\"\nhashcode = " + hashcode + "\n");

        return map[index];
    }

    void delete(K key, V value) { // удаляем ноду по ключу и значению
        int hashcode = key.hashCode();
        int index = (map.length - 1) & hashcode;
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

        System.out.println("DELETE\ndeleted node " + deletedNode + " from index " + index + "\nhashcode = " + hashcode);
        System.out.println(Arrays.toString(map) + "\n");
    }

    int size() {
        System.out.println("map size: " + size);
        return size;
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
        size += 4;
        map = Arrays.copyOf(map, size);
    }
}
