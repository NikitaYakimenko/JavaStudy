package collections.linkedlist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleLinkedList<V> {
    private Node<V> head;
    private Node<V> tail;
    private int size = 0;

    public void add(V value) {
        linkLast(value);
    }

    public void add(int index, V value) {
        if (index == 0) {
            linkFirst(value);
        } else if (index == size) {
            linkLast(value);
        } else if (isValidIndex(index)) {
            linkBefore(value, getNodeOnIndex(index));
        } else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public V get(int index) {
        if (isValidIndex(index)) {
            if (index == 0) {
                return head.value;
            } else if (index == size - 1) {
                return tail.value;
            }
            return getNodeOnIndex(index).value;
        } else {
            return null;
        }
    }

    public void remove(V value) {
        if (value == null) {
            for (Node<V> target = head; target != null; target = target.next) {
                if (target.value == null) {
                    unlink(target);
                }
            }
        } else {
            for (Node<V> target = head; target != null; target = target.next) {
                if (value.equals(target.value)) {
                    unlink(target);
                }
            }
        }
    }

    public void removeFirst() {
        Node<V> currentFirst = head;
        if (currentFirst == null) {
            throw new NoSuchElementException();
        }
        unlinkFirst(currentFirst);
    }

    public void removeLast() {
        Node<V> currentLast = tail;
        if (currentLast == null) {
            throw new NoSuchElementException();
        }
        unlinkLast(currentLast);
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node<V> target = head;
        while (target != null) {
            System.out.print((target == tail) ? target + "\n" : target + "; ");
            target = target.next;
        }
    }

    private void linkFirst(V value) {
        Node<V> currentFirst = head;
        Node<V> newNode = new Node<>(null, value, currentFirst);
        head = newNode;
        if (currentFirst == null) {
            tail = newNode;
        } else {
            currentFirst.previous = newNode;
        }
        size++;
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

    private void unlinkFirst(Node<V> target) {
        Node<V> newFirst = target.next;
        target.value = null;
        target.next = null;
        head = newFirst;
        if (newFirst == null) {
            tail = null;
        } else {
            newFirst.previous = null;
        }
        size--;
    }

    private void unlinkLast(Node<V> target) {
        Node<V> newLast = target.previous;
        target.value = null;
        target.previous = null;
        tail = newLast;
        if (newLast == null) {
            head = null;
        } else {
            newLast.next = null;
        }
        size--;
    }

    private void unlink(Node<V> target) {
        Node<V> next = target.next;
        Node<V> previous = target.previous;
        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
            target.previous = null;
        }
        if (next == null) {
            tail = previous;
        } else {
            next.previous = previous;
            target.next = null;
        }
        target.value = null;
        size--;
    }

    private int indexOf(Object value) {
        int index = 0;
        if (value == null) {
            for (Node<V> node = head; node != null; node = node.next) {
                if (node.value == null)
                    return index;
                index++;
            }
        } else {
            for (Node<V> node = head; node != null; node = node.next) {
                if (value.equals(node.value))
                    return index;
                index++;
            }
        }
        return -1;
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
