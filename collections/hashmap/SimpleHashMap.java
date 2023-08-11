package collections.hashmap;

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

        int index = (map.length - 1) & key.hashCode(); // нормируем хеш-код в int для индекса
        Node<K, V> newNode = new Node<>(key, value); // создаем новый узел с ключом и значением

        if (map[index] == null) { // если в ячейке нет узла
            map[index] = newNode; // присваиваем ей новый узел
        } else { // если в ячейке есть узел
            Node<?, ?> current = map[index]; // создаем переменную для текущего узла

            while (current.getNextNode() != null) { // пока текущий узел имеет следующий узел
                current = current.getNextNode(); // переходим к следующему узлу
            }

            current.setNextNode(newNode); // присваиваем текущему узлу новый узел
        }

        System.out.println(Arrays.toString(map));
    }

    public Node<?, ?> get(K key) {
        int index = (map.length - 1) & key.hashCode();

        return map[index];
    }

    public void delete(K key, V value) { // удаляем узел по ключу и значению
        for (int i = 0; i <= map.length - 1; i++) {
            if (map[i] != null) {
                if (map[i].getKey().equals(key) & map[i].getValue().equals(value)) {
                    map[i] = null; // удаляем первый узел
                } else if (map[i].getNextNode() != null) {
                    if (map[i].getNextNode().getKey().equals(key) & map[i].getNextNode().getValue().equals(value)) {
                        map[i].setNextNode(null); // или удаляем ссылку на следующий узел
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
