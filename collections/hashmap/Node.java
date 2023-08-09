package collections.hashmap;

public class Node <K, V> {
    private final K key;
    private final V value;
    private Node<?, ?> nextNode;

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
