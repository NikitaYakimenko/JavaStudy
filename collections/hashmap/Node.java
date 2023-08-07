package collections.hashmap;

public class Node<K, V> {
    private int hash;
    private K key;
    private V value;
    Node<K, V> nextNode;

    Node(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    static <K, V> void setNextNode(Node<K, V> currentNode, Node<K, V> nextNode) {
        currentNode.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
