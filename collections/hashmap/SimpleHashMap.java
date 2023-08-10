package collections.hashmap;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class SimpleHashMap <K, V> {
    private int capacity;
    private Node<K, V>[] map;

    public SimpleHashMap(int capacity) {
        map = new Node[capacity];
    }

    public void put(K key, V value) { // принимаем на вход любые типы
        if (checkOccupancy()) {
            expand();
        }

        int hashcode = key.hashCode(); // берем хеш-код от ключа
        int index = (map.length - 1) & hashcode; // нормируем хеш-код в int для индекса

        if (map[index] != null) {
            map[index].setNextNode(new Node<>(key, value));
        } else {
            map[index] = new Node<>(key, value);
        }
    }

    public V get(@NotNull K key) {
        int hashcode = key.hashCode();
        int index = (map.length - 1) & hashcode;

        if (map[index] == null) {
            return null;
        }

        return map[index].getValue();
    }

    public void delete(K key, V value) { // удаляем ноду по ключу и значению
        for (int i = 0; i <= map.length - 1; i++) {
            if (map[i] != null) {
                if (map[i].getKey().equals(key) & map[i].getValue().equals(value)) {
                    map[i] = null; // удаляем первую ноду
                } else if (map[i].getNextNode() != null) {
                    if (map[i].getNextNode().getKey().equals(key) & map[i].getNextNode().getValue().equals(value)) {
                        map[i].setNextNode(null); // или удаляем ссылку на следующую ноду
                    }
                }
            }
        }
    }

    public boolean containsKey(K key) {
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

    public int size() {
        int count = 0;

        for (Node<?, ?> node : map) {
            if (node != null) {
                count += 1;
            }
        }

        return count;
    }

    private boolean checkOccupancy() { // проверяем не заполнен ли массив
        boolean isFull = true;

        for (Node<?, ?> node : map) {
            if (node == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private void expand() { // увеличиваем массив на четыре ячейки
        capacity += 4;
        map = Arrays.copyOf(map, capacity);
    }
}
