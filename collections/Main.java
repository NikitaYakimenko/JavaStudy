package collections;

import collections.arraylist.SimpleArrayList;
import collections.hashmap.SimpleHashMap;
import collections.linkedlist.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        // SimpleLinkedList
        System.out.println("    SimpleLinkedList:");
        SimpleLinkedList<String> myLinkedList = new SimpleLinkedList<>();
        myLinkedList.add("zero");
        myLinkedList.add("one");
        myLinkedList.add("two");
        myLinkedList.add("three");
        myLinkedList.add("four");
        myLinkedList.add("five");
        myLinkedList.add("six");
        myLinkedList.add("seven");

        myLinkedList.print();
        myLinkedList.removeFirst();
        myLinkedList.print();

        System.out.println();

        // SimpleHashMap
        System.out.println("    SimpleHashMap:");
        SimpleHashMap<Integer, String> myHashMap = new SimpleHashMap<>();
        myHashMap.put(1, "one");
        myHashMap.remove(1);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.containsKey(1));
        System.out.println(1 << 30);
        System.out.println(2 << 29);

        System.out.println();

        // SimpleArrayList
        System.out.println("    SimpleArrayList:");
        SimpleArrayList<String> myArrayList = new SimpleArrayList<>(2);
        myArrayList.add("zero");
        myArrayList.add("one");
        myArrayList.add("two");
        myArrayList.add("three");
        myArrayList.print();
    }
}
