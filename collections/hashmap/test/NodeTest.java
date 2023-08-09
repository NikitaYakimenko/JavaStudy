package collections.hashmap.test;

import collections.hashmap.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    static Node<Integer, String> node;

    @BeforeAll
    static void prepareDate() {
        node = new Node<>(1, "one");
    }

    @Test
    void getKey() {
        assertEquals(1, node.getKey());
    }

    @Test
    void getValue() {
        assertEquals("one", node.getValue());
    }

    @Test
    void nextNode() {
        Node<?, ?> newNode = new Node<>(2, "two");
        node.setNextNode(newNode);

        assertEquals(newNode, node.getNextNode());
    }

    @Test
    void testToString() {
        assertEquals("1: one", node.toString());
    }
}