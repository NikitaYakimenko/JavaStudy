package collections.hashmap;

import java.util.Arrays;

public class SimpleHashMap <K, V> {
    private int capacity = 8;
    private Node<K, V>[] map = new Node[capacity];

    /*
    put() используется для добавления новых узлов и замены значений существующих узлов.
    На основе хеша ключа вычисляется индекс:
     - если на индексе пусто, добавляется новый узел;
     - если на индексе есть узел с эквивалентным ключом, значение этого узла перезаписывается;
     - если на индексе есть узел с отличным ключом, узел добавляется в список.
     */
    public void put(K key, V value) { // принимаем на вход любые типы
        int i = getIndexByKey(key); // получаем индекс на основе ключа
        Node<K, V> newNode = new Node<>(key, value); // создаем новый узел с ключом и значением

        if (needExpansion()) {
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
//        System.out.println(i);
//        System.out.println(Arrays.toString(map));
    }

    /*
    get() используется для получения значения узла на основе переданного ключа.
    На основе хеша ключа вычисляется индекс:
     - если на индексе пусто, возвращается null;
     - если на индексе есть узел или список узлов, возвращается узел с эквивалентным ключом.
     */
    public V get(K key) {
        Node <K, V> target = (Node<K, V>) getFirstNodeInBucket(key); // присваиваем целевой узел

        if (target == null) { // если узла не существует
            return null;
        }

        while (!target.getKey().equals(key)) { // пока ключ узла не совпадет
            target = (Node<K, V>) target.getNextNode(); // переходим к следующему узлу
        }

        if (target.getKey().equals(key)) {
            return target.getValue();
        } else {
            return null;
        }
    }

    public void remove(K key, V value) { // удаляем узел по ключу и значению
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

    /*
    containsKey() проверяет существование переданного ключа в узлах связанных списков массива.
    Метод возвращает истину, если любой из связанных списков массива содержит узел, ключ которого совпадает с переданным.
     */
    public boolean containsKey(K key) {
        boolean containsKey = false;

        for (int i = 0; i <= map.length - 1; i++) {
            Node<K, V> node = map[i];

            if (map[i] != null) { // если индекс не пустой

                while (node != null) { // пока узел существует
                    if (node.getKey().equals(key)) { // если ключ совпадает
                        containsKey = true;
                        break;
                    }

                    node = (Node<K, V>) node.getNextNode(); // переходим к следующему узлу
                }
            }
        }

        return containsKey;
    }

    /*
    getFirstNodeInBucket() возвращает первый узел, находящийся на индексе, независимо от переданного ключа.
    Какой бы ключ не был передан, на его основе вычисляется индекс, к которому обращается метод и, получая доступ ко всему списку,
    возвращает первый элемент этого списка. Кроме того, метод проверяет, содержится ли переданный ключ в любом из узлов связанных списков массива.
     */
    public Node<?, ?> getFirstNodeInBucket(K anyKeyInBucket) {
        int i = getIndexByKey(anyKeyInBucket); // получаем индекс на основе ключа

        if (containsKey(anyKeyInBucket)) {
            return map[i];
        } else {
            return null;
        }
    }

    /*
    getBucket() возвращает список узлов, находящихся на индексе.
    Метод расширяет getFirstNodeInBucket(), возвращая весь список целиком.
     */
    public String getBucket(K key) {
        Node<?, ?> node;

        if (getFirstNodeInBucket(key) != null) { // если на индексе есть узел
            node = getFirstNodeInBucket(key); // присваиваем в качестве целевого
        } else {
            return null;
        }

        String result = node.toString();

        if (containsKey(key)) { // если такой ключ содержится в списках массива
            while (node.getNextNode() != null) { // пока есть ссылка на следующий узел
                result += "; " + node.getNextNode(); // агрегируем строку для вывода
                node = node.getNextNode(); // и переходим к следующему узлу
            }
        } else {
            result = "Key \"" + key + "\" doesn't exist";
        }

        return result;
    }

    public String getBucket(int index) {
        if (index >= map.length) {
            return null;
        }

        if (map[index] == null) {
            return null;
        }

        Node<?, ?> node = map[index];

        String result = node.toString();

        while (node.getNextNode() != null) {
            result += "; " + node.getNextNode();
            node = node.getNextNode();
        }

        return result;
    }

    /*
    print() выводит все узлы, содержащиеся в связанных списках массива соответственно индексам
     */
    public void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(i + " -> " + getBucket(i));
        }
    }

    /*
    size() возвращает общее количество узлов во всех связанных списках массива.
     */
    public int size() {
        int count = 0;

        for (Node<?, ?> bucket : map) {
            if (bucket != null) {
                Node<?, ?> node = bucket;

                while (node.getNextNode() != null) {
                    node = node.getNextNode();
                    count++;
                }

                count++;
            }
        }

        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    /*
    needExpansion() проверяет необходимость расширения массива, основываясь на заполненности индексов массива.
     */
    private boolean needExpansion() { // проверяем не заполнен ли массив
        boolean needExpansion = true;

        for (Node<?, ?> bucket : map) {
            if (bucket == null) {
                needExpansion = false;
                break;
            }
        }

        return needExpansion;
    }

    /*
    expand() увеличивает массив на две ячейки
     */
    private void expand() {
        capacity += 2;
        map = Arrays.copyOf(map, capacity);
    }

    /*
    getIndexByKey() вычисляет индекс на основе переданного ключа.
    Метод применяет & к максимальному индексу массива и хешу ключа, гарантируя расположение индекса внутри диапазона массива.
     */
    private int getIndexByKey(K key) {
        return (map.length - 1) & key.hashCode();
    }
}
