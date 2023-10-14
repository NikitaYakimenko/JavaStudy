package collections.linkedlist;

public class SimpleLinkedList <V> {

    Node<V> firstNode;
    Node<V> lastNode;

    int size = 0;

    public void add(V value) {
        linkLast(value);
    }

    public V get(int i) {
        if (isValidIndex(i)) {
            return getNodeOnIndex(i).value;
        } else {
            return null;
        }
    }

    private void linkLast(V value) {
        Node<V> currentLast = lastNode;
        Node<V> newNode = new Node<>(currentLast, value, null);
        lastNode = newNode;
        if (currentLast == null) {
            firstNode = newNode;
        } else {
            currentLast.next = newNode;
        }
        size++;
    }

    private boolean isValidIndex(int i) {
        return i >= 0 && i < size;
    }

    private Node<V> getNodeOnIndex(int i) {
        Node<V> target;
        if (i < (size >> 2)) {
            target = firstNode;
            for (int position = 0; position < i; position++) {
                target = target.next;
            }
        } else {
            target = lastNode;
            for (int position = size - 1; position > i; position--) {
                target = target.previous;
            }
        }
        return target;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<V> i = firstNode;
        while (i != null) {
            System.out.print((i == lastNode) ? i + "\n" : i + "; ");
            i = i.next;
        }
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
