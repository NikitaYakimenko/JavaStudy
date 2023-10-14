package collections.linkedlist;

public class SimpleLinkedList <V> {

    Node<V> head;
    Node<V> tail;

    int size = 0;

    public void add(V value) {
        linkLast(value);
    }

    public void add(int index, V value) {
        if (index == size) {
            linkLast(value);
        } else if (isValidIndex(index)) {
            linkBefore(value, getNodeOnIndex(index));
        } else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public V get(int index) {
        if (isValidIndex(index)) {
            return getNodeOnIndex(index).value;
        } else {
            return null;
        }
    }

    private void linkLast(V value) {
        Node<V> currentLast = tail;
        Node<V> newNode = new Node<>(currentLast, value, null);
        tail = newNode;
        if (currentLast == null) {
            head = newNode;
        } else {
            currentLast.next = newNode;
        }
        size++;
    }

    private void linkBefore(V value, Node<V> target) {
        Node<V> previous = target.previous;
        Node<V> newNode = new Node<>(previous, value, target);
        target.previous = newNode;
        if (previous == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }
        size++;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node<V> getNodeOnIndex(int index) {
        Node<V> target;
        if (index < (size >> 2)) {
            target = head;
            for (int position = 0; position < index; position++) {
                target = target.next;
            }
        } else {
            target = tail;
            for (int position = size - 1; position > index; position--) {
                target = target.previous;
            }
        }
        return target;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<V> target = head;
        while (target != null) {
            System.out.print((target == tail) ? target + "\n" : target + "; ");
            target = target.next;
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private static class Node<V> {
        V value;
        Node<V> previous;
        Node<V> next;

        Node(Node<V> previous, V value, Node<V> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}
