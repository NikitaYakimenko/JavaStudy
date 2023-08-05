package collections.hashmap;

public class Node<K, V> {
    int hash;
    K key;
    V value;
    Node<K, V> nextNode = null;

    Node(int hash, K key, V value, Node<K, V> nextNode) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }

    public String toString(K key, V value) {
        return key + ": " + value;
    }

    public V getValue() {
        return value;
    }
}
