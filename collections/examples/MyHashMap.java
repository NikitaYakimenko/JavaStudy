package collections.examples;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    /*
    преобразование любого объекта в число int
    hashcode() возвращает hash, полученный путем конвертации внутреннего адреса ключа в число

    в основе HashMap<> лежит массив, элементами которого являются LinkedList<>
    все эти LinkedList заполняются элементами, которые добавляются в HashMap

    расположение ноды определяется выводом hashcode()

//    если hash одинаковый, то ноды проверяются equal (индекс уже определен)
//    если equal возвращает true, нода перезаписывается
//    если equal возвращает false, нода добавляется в конец LinkedList

    если индекс получился одинаковый, то ключи проверяются на equal()
    если true, нода перезаписывается
    если false, нода добавляется в конец LinkedList<>

    нода содержит: ключ, значение, hash ключа, ссылку на след.ноду
     */
    public static void main(String[] args) {
        HashMap<Integer, String> carIds = new HashMap<>();

        carIds.put(1, "toyota");
        System.out.println(carIds.size());

        carIds.put(1, "nissan");
        System.out.println(carIds.size());

        carIds.put(2, "ford");
        System.out.println(carIds.size());

        System.out.println(carIds);

//        for (Map.Entry<Integer, String> entry: carIds.entrySet()) { // HashMap output
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
    }
}
