package collections;

import collections.hashmap.SimpleHashMap;
import collections.linkedlist.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        //SimpleLinkedList
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");

        list.print();
        list.removeFirst();
        list.print();

        // SimpleHashMap
        SimpleHashMap<String, String> myMap = new SimpleHashMap<>();
        myMap.put("1", "one");
        myMap.put("2", "two");
        myMap.put("3", "three");
        myMap.put("4", "four");
        myMap.put("9", "nine");
        myMap.put("12", "twelve");
        myMap.put("23", "twenty three");

        myMap.print();
    }
}
