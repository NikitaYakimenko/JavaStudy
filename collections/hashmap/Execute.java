package collections.hashmap;

public class Execute {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myStringHashMap = new SimpleHashMap<>(); // пример с key: String, value: String
        myStringHashMap.put("zero", "Zero"); // ставим ноду на индекс 0
        myStringHashMap.get("zero"); // вытаскиваем ту же ноду из индекса 0
        myStringHashMap.put("one", "One"); // ставим ноду на индекс 2
        myStringHashMap.put("one", "Two"); // ставим вторую ноду на индекс 2
        Node node = (Node) myStringHashMap.get("one"); // вытаскиваем первую ноду из индекса 2
        System.out.println("First node at index 2: " + node); // смотрим ее первую ноду на индексе 2
        System.out.println("Second node at index 2: " + node.nextNode); // смотрим следующую ноду на индексе 2
        System.out.println("Third node at index 2: " + node.nextNode.nextNode); // проверяем нулловость ссылки во второй ноде

//        SimpleHashMap<Integer, Double> myIntegerHashMap = new SimpleHashMap<>(); // пример с key: Integer, value: Double
//        myIntegerHashMap.put(0, 0.0); // ставим ноду на индекс 0
//        myIntegerHashMap.put(1, 1.0); // ставим ноду на индекс 1
//        myIntegerHashMap.put(1, 2.0); // ставим вторую ноду на индекс 1
//        myIntegerHashMap.delete(1, 2.0); // удаляем вторую ноду с индекса 1
//        myIntegerHashMap.delete(1, 1.0); // удаляем ноду с индекса 1

//        Node node = myIntegerHashMap.get(0); // можно проверить наличие нод под индексом
//        System.out.println(node);
//        System.out.println(node.nextNode);

//        SimpleHashMap<KeyObject, ValueObject> myObjectHashMap = new SimpleHashMap<>(); // пример с key: Object, value: Object
//        KeyObject myKey = new KeyObject();
//        myObjectHashMap.put(myKey, new ValueObject());
//        myObjectHashMap.get(myKey);
//
//        KeyObject myKey1 = new KeyObject();
//        myObjectHashMap.put(myKey1, new ValueObject());
//        myObjectHashMap.get(myKey1);
    }
}

class KeyObject {}
class ValueObject {}
