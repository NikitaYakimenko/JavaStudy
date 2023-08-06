package collections.hashmap;

public class Execute {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myStringHashMap = new SimpleHashMap<>(); // пример с key: String, value: String
        myStringHashMap.put("zero", "Zero"); // ставим ноду на индекс 0
        myStringHashMap.get("zero"); // вытаскиваем ту же ноду из индекса 0
        myStringHashMap.put("one", "One"); // ставим ноду на индекс 2
        myStringHashMap.put("one", "Two"); // ставим вторую ноду на индекс 2
        Node abc = (Node) myStringHashMap.get("one"); // вытаскиваем первую ноду из индекса 2
        System.out.println("First value at index 2: " + abc.getValue()); // смотрим ее первое значение ноды на индексе 2
        System.out.println("Second value at index 2: " + abc.nextNode.getValue()); // смотрим значение следующей ноды на индексе 2
        System.out.println("Third node at index 2: " + abc.nextNode.nextNode); // проверяем нулловость ссылки во второй ноде

//        SimpleHashMap<Integer, Double> myIntegerHashMap = new SimpleHashMap<>(); // пример с key: Integer, value: Double
//        myIntegerHashMap.put(0, 0.0);
//        myIntegerHashMap.get(0);
//        myIntegerHashMap.put(1, 1.0);
//        myIntegerHashMap.get(1);

//        myIntegerHashMap.put(2, 2.0);
//        myIntegerHashMap.put(3, 3.0);
//        myIntegerHashMap.put(4, 4.0);
//        myIntegerHashMap.put(5, 5.0);
//        myIntegerHashMap.put(6, 6.0);
//        myIntegerHashMap.put(7, 7.0);
//        myIntegerHashMap.put(8, 8.0);
//        myIntegerHashMap.put(9, 9.0);
//        myIntegerHashMap.put(10, 10.0);

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
