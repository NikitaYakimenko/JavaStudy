package collections.hashmap;

public class Main {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>(2);
        myMap.put("0", "0");
        myMap.put("0", "1");
        System.out.println(myMap.get("0"));
        System.out.println(myMap.get("0").getNextNode());
    }
}
