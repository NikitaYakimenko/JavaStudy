package collections.hashmap;

public class Execute {
    public static void main(String[] args) {
        SimpleHashMap<Integer, String> myIntegerHashMap = new SimpleHashMap<>();
        myIntegerHashMap.put(0, "zero");
        myIntegerHashMap.put(1, "one");
        myIntegerHashMap.put(2, "two");
        myIntegerHashMap.put(3, "three");
        myIntegerHashMap.put(4, "four");
        myIntegerHashMap.put(4, "four2");

        myIntegerHashMap.delete(4, "four2");
        myIntegerHashMap.get(4);
        myIntegerHashMap.containsKey(1);
        myIntegerHashMap.size();
    }
}
