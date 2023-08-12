package collections.hashmap;

public class Node <K, V> {
    private final K key;
    private V value;
    private Node<?, ?> nextNode = null;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<?, ?> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<?, ?> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
