package collections.hashmap;

import java.util.Arrays;

public class SimpleHashMap <K, V> {
    private int capacity = 8;
    private Node<K, V>[] map = new Node[capacity];

    public void put(K key, V value) { // принимаем на вход любые типы
        int i = (map.length - 1) & key.hashCode(); // нормируем хеш-код в int для индекса
        Node<K, V> newNode = new Node<>(key, value); // создаем новый узел с ключом и значением

        if (checkOccupancy(i)) {
            expand();
        }

        Node<K, V> current = map[i]; // текущий узел
        Node<K, V> previous = null; // предыдущий узел

        while (current != null && !current.getKey().equals(key)) { // пока не найдем пустую ячейку или узел с таким же ключом
            previous = current; // обновляем предыдущий узел
            current = (Node<K, V>) current.getNextNode(); // переходим к следующему узлу
        }

        if (current == null) { // если ячейка пустая
            if (previous == null) { // если это первый узел
                map[i] = newNode; // добавляем его в ячейку
            } else { // если это не первый узел
                previous.setNextNode(newNode); // добавляем его после предыдущего узла
            }
        } else { // если нашли узел с таким же ключом
            current.setValue(value); // перезаписываем значение узла
        }

        System.out.println("PUT: hash: " + key.hashCode() + ", index: " + i);
        System.out.println(Arrays.toString(map));
    }

    public Node<?, ?> getNode(K key) {
        int i = (map.length - 1) & key.hashCode();

        return map[i];
    }

    public void getBucket(K key) {
        int i = (map.length - 1) & key.hashCode();
        Node<?, ?> node = map[i];
        String result = map[i].toString();

        while (node.getNextNode() != null) {
            result += "; " + node.getNextNode().toString();
            node = node.getNextNode();
        }

        System.out.println("GET: { " + result + " }\n");
    }

    public V get(K key) {
        int index = (map.length - 1) & key.hashCode();

        if (map[index] == null) {
            return null;
        }

        return map[index].getValue();
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

    public int getCapacity() {
        return capacity;
    }

    private boolean checkOccupancy(int i) { // проверяем не заполнен ли массив
        boolean needExpansion = true;

        for (Node<?, ?> node : map) {
            if (node == null) {
                needExpansion = false;
                break;
            }
        }

        return needExpansion;
    }

    private void expand() { // увеличиваем массив на четыре ячейки
        capacity += 2;
        map = Arrays.copyOf(map, capacity);
    }
}
