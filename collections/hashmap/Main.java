package collections.hashmap;

public class Main {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();
        myMap.put("1", "one");
//        myMap.put("2", "two");
        myMap.put("9", "nine");
        myMap.put("12", "twelve");
        myMap.put("23", "twenty three");
        myMap.print();

        myMap.remove("2");

        myMap.print();
    }
}
