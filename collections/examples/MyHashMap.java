package collections.examples;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    /*
    преобразование любого объекта в число int
    hashcode() возвращает hash, полученный путем конвертации внутреннего адреса ключа в число

    в основе HashMap лежит массив, элементами которого являются LinkedList
    все эти LinkedList заполняются элементами, которые добавляются в HashMap

    расположение ноды определяется выводом hashcode()

    если hash одинаковый, то ноды проверяются equal (индекс уже определен)
    если equal возвращает true, нода перезаписывается
    если equal возвращает false, нода добавляется в конец LinkedList

    нода содержит: ключ, значение, hash ключа, ссылку на след.ноду
     */
    public static void main(String[] args) {
        Map<String, Integer> carIds = new HashMap<>();

        carIds.put("Toyota Yaris", 1);
        carIds.put("Toyota Vios", 2);
        carIds.put("Nissan Almera", 3);

        System.out.println(carIds);
        System.out.println("get \"Nissan Almera\" id: " + carIds.get("Nissan Almera"));
        System.out.println("check if key \"Toyota Vios\" exists: " + carIds.containsKey("Toyota Vios"));
        System.out.println("check if value \"1\" exists: " + carIds.containsValue(1));

        carIds.put("Toyota Vios", 4); // updates value of a key

        System.out.println("check if value of key \"Toyota Vios\" was updated: " + carIds.get("Toyota Vios"));

        carIds.replace("Ford Raptor", 5); // updates value only if a key exists
        carIds.putIfAbsent("Toyota Yaris Ativ", 6); // puts a node only if a key doesn't exist yet

        carIds.remove("Toyota Yaris Ativ");
        System.out.println(carIds);

        carIds.put(null, 0); // null keys are added to carIds[0]

        for (Map.Entry<String, Integer> entry: carIds.entrySet()) { // HashMap output
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
