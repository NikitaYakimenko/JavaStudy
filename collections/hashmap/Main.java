package collections.hashmap;

public class Main {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();

        myMap.put("1", "1");
        myMap.getBucket("1");

        myMap.put("9", "9");
        myMap.getBucket("9");

        myMap.put("12", "12");
        myMap.getBucket("12");

        myMap.put("23", "23");
        myMap.getBucket("23");
    }
}
