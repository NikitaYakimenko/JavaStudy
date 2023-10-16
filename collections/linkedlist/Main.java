package collections.linkedlist;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
//        list.add("four");
//        list.add("five");
//        list.add("six");
//        list.add("seven");
        list.print();
//        System.out.println(list.size());
        list.removeFirst();
//        System.out.println(list.get(9));
        list.print();
//        System.out.println(list.size());
    }
}
