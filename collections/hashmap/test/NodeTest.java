package collections.hashmap.test;

import collections.hashmap.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Node<Integer, String> node;

    @BeforeEach
    void prepareData() {
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
        Node<Integer, String> newNode = new Node<>(2, "two");
        node.setNextNode(newNode);

        assertEquals(newNode, node.getNextNode());
    }

    @Test
    void testToString() {
        assertEquals("1: one", node.toString());
    }
}
