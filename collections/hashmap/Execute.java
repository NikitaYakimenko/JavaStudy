package collections.hashmap;

public class Execute {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myStringHashMap = new SimpleHashMap<>();
        myStringHashMap.put("1", "One");
        myStringHashMap.put("2", "Two");
        System.out.println(myStringHashMap.get("1"));
        System.out.println(myStringHashMap.get("2") + "\n");

//        SimpleHashMap<Integer, String> myIntegerHashMap = new SimpleHashMap<>();
//        myIntegerHashMap.put(1, "Zero");
//        System.out.println(myIntegerHashMap.get(1));
//        myIntegerHashMap.put(1, "One");
//        myIntegerHashMap.put(2, "Two");
//        myIntegerHashMap.put(3, "Three");
//        myIntegerHashMap.put(4, "Four");
//        myIntegerHashMap.put(5, "Five");
//        myIntegerHashMap.put(6, "Six");
//        myIntegerHashMap.put(7, "Seven");
//        myIntegerHashMap.put(8, "Eight");
//        myIntegerHashMap.put(9, "Nine");
//        myIntegerHashMap.put(10, "Ten");

//        SimpleHashMap<KeyObject, ValueObject> myObjectHashMap = new SimpleHashMap<>();
//        KeyObject myKey = new KeyObject();
//        myObjectHashMap.put(myKey, new ValueObject());
//        System.out.println(myObjectHashMap.get(myKey));
    }
}

class KeyObject {}
class ValueObject {}
