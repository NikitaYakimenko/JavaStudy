package collections.hashmap;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleHashMap <K, V> {
    private int capacity = 8; // Дефолтная вместимость
    private int size = 0;
    private Node<K, V>[] map;

    /*
    Дефолтный конструктор
     */
    public SimpleHashMap(){
        map = new Node[capacity];
    }

    /*
    Конструктор для случаев хранения больших объемов данных
     */
    public SimpleHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[this.capacity];
    }

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
            current = current.getNextNode(); // переходим к следующему узлу
        }

        if (current == null) { // если ячейка пустая
            if (previous == null) { // если это первый узел
                map[i] = newNode; // добавляем его в ячейку
            } else { // если это не первый узел
                previous.setNextNode(newNode); // добавляем его после предыдущего узла
            }
            size++;
        } else { // если нашли узел с таким же ключом
            current.setValue(value); // перезаписываем значение узла
        }
    }

    /*
    get() используется для получения значения узла на основе переданного ключа.
    На основе хеша ключа вычисляется индекс:
     - если на индексе пусто, возвращается null;
     - если на индексе есть узел или список узлов, возвращается узел с эквивалентным ключом.
     */
    public V get(K key) {
        int i = getIndexByKey(key); // получаем индекс на основе ключа
        Node <K, V> target = getFirstNodeInBucket(i); // присваиваем целевой узел

        if (target == null) { // если узла не существует
            return null;
        }

        while (target != null && !target.getKey().equals(key)) { // пока ключ узла не совпадет
            target = target.getNextNode(); // переходим к следующему узлу
        }

        if (target != null && target.getKey().equals(key)) {
            return target.getValue();
        } else {
            return null;
        }
    }

    /*
    remove() используется для удаления узлов по указанному ключу.
    Метод выполняется только если переданный ключ содержится в списках массива.
    На основе хеша ключа вычисляется индекс:
     - если на индексе находится единственный узел, он удаляется;
     - если на индексе находится список, то найденный узел удаляется, а его ссылка присваивается предыдущему.
     */
    public void remove(K key) { // удаляем узел по ключу
        if (containsKey(key)) { // если ключ содержится в списках массива
            int i = getIndexByKey(key); // получаем индекс на основе ключа
            Node<K, V> target = getFirstNodeInBucket(i); // присваиваем целевой узел
            Node<K, V> previousNode = null; // подготавливаем переменную для узла, предшествующего удаляемому

            while (target != null && !target.getKey().equals(key)) { // ищем узел с заданным ключом
                previousNode = target; // записываем предыдущий узел
                target = target.getNextNode(); // переходим к следующему узлу
            }

            if (target != null) { // если найден узел с заданным ключом
                if (previousNode == null) { // если он первый в списке
                    map[i] = target.getNextNode(); // ставим на его место следующий узел или null
                } else { // если он не первый в списке
                    previousNode.setNextNode(target.getNextNode()); // присваиваем ссылке предыдущего узла ссылку на следующий узел или null
                }
                size--;
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

                    node = node.getNextNode(); // переходим к следующему узлу
                }
            }
        }

        return containsKey;
    }

    /*
    print() выводит все узлы, содержащиеся в связанных списках массива соответственно индексам
     */
    public void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(i + " -> " + getBucket(i));
        }

        System.out.println();
    }

    /*
    size() возвращает общее количество узлов во всех связанных списках массива.
     */
    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    // приватные методы
    /*
    needExpansion() проверяет необходимость расширения массива, основываясь на заполненности индексов массива.
     */
    private boolean needExpansion() { // проверяем не заполнен ли массив
        boolean expansionNeeded = true;

        for (Node<?, ?> bucket : map) {
            if (bucket == null) {
                expansionNeeded = false;
                break;
            }
        }

        return expansionNeeded;
    }

    /*
    expand() увеличивает массив на ~30%
     */
    private void expand() {
        capacity += capacity / 3;
        map = Arrays.copyOf(map, capacity);
    }

    /*
    getIndexByKey() вычисляет индекс на основе переданного ключа.
    Метод применяет & к максимальному индексу массива и хешу ключа, гарантируя расположение индекса внутри диапазона массива.
     */
    private int getIndexByKey(K key) {
        return (map.length - 1) & key.hashCode();
    }

    /*
   getFirstNodeInBucket() возвращает первый узел, находящийся на индексе, независимо от переданного ключа.
   Какой бы ключ не был передан, на его основе вычисляется индекс, к которому обращается метод и, получая доступ ко всему списку,
   возвращает первый элемент этого списка. Кроме того, метод проверяет, содержится ли переданный ключ в любом из узлов связанных списков массива.
    */
    private Node<K, V> getFirstNodeInBucket(int i) {
        return map[i];
    }

    /*
    getBucket() возвращает список узлов, находящихся на индексе.
     */
    private ArrayList<Node<K, V>> getBucket(int i) {
        Node<?, ?> node = getFirstNodeInBucket(i);
        ArrayList<Node<K, V>> result = new ArrayList<>();

        if (node != null) {
            result.add((Node<K, V>) node);

            while (node.getNextNode() != null) {
                result.add((Node<K, V>) node.getNextNode());
                node = node.getNextNode();
            }

            return result;
        } else {
            return null;
        }
    }
}
