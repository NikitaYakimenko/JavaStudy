package collections;

import collections.hashmap.SimpleHashMap;
import collections.linkedlist.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        // SimpleLinkedList
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
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.put(1, "one");
        map.remove(1);
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        System.out.println(1 << 30);
        System.out.println(2 << 29);
    }
}
