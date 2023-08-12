package collections.hashmap;

public class Main {
    public static void main(String[] args) {
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();

        myMap.put("1", "1");
        myMap.getBucket("1");

        myMap.put("9", "9");
        myMap.getBucket("1");

        myMap.put("12", "12");
        myMap.getBucket("1");

        myMap.put("23", "23");
        myMap.getBucket("1");

//        myMap.put("2", "2");
//        myMap.put("3", "3");
//        myMap.put("4", "4");
//        myMap.put("5", "5");
//        myMap.put("6", "6");
//        myMap.put("7", "7");
//        myMap.put("8", "8");
//        myMap.put("10", "10");
//        myMap.put("11", "11");
//        myMap.put("13", "13");

        System.out.println(myMap.getNode("1").getNextNode().getNextNode().getNextNode());
    }
}
