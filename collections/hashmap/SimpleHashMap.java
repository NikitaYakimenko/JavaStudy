package collections.hashmap;

import java.util.Arrays;

public class SimpleHashMap<K, V> {
    private Node[] array = new Node[4];

    public Object get(K key) { // принимаем на вход любой тип
        Key<K> keyClass = new Key<>(key); // создаем инстанс Key на основе входного объекта

        int hashcode = keyClass.hashCode(); // берем хеш-код от инстанса
        System.out.println("get hashcode = " + hashcode);

        int index = (array.length - 1) & hashcode; // нормируем число для индекса
        System.out.println("get index = " + index);

        if (index > array.length) { // проверяем валидность входного объекта
            System.out.println("error");
            return null;
        }

        System.out.println("got value of index " + index);
        System.out.println(Arrays.toString(array) + "\n");

        return array[index];
    }

    public void put(K key, V value) {
        if (checkOccupancy()) {
            doubleSize();
        }

        Key<K> keyClass = new Key<>(key);

        int hashcode = keyClass.hashCode();
        System.out.println("put hashcode = " + hashcode);

        int index = (array.length - 1) & hashcode;
        System.out.println("put index = " + index);

        if (index > array.length) {
            System.out.println("invalid index");
        }

        array[index] = new Node<>(hashcode, key, value, null);

        System.out.println("put " + value + " to index " + index);
        System.out.println(Arrays.toString(array) + "\n");
    }

    private boolean checkOccupancy() { // проверяем не заполнен ли массив
        boolean isFull = true;

        for (Object value : array) {
            if (value == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }
    private void doubleSize() { // увеличиваем массив в два раза
        array = Arrays.copyOf(array, array.length * 2);
    }
}
