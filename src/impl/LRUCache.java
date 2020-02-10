package impl;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head;
    Map<Integer, Node> table;
    int capacity;
    int size;

    class Node {
        Node prev;
        Node next;
        int value;
        int key;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }

        public Node(Node prev, Node next, int value, int key) {
            this.prev = prev;
            this.next = next;
            this.value = value;
            this.key = key;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        table = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        Node result = table.get(key);
        if(result == null) return -1;
        if(table.size() == 2) {
            head = result.next;
            return result.value;
        }
        if(result == head) {
            head = head.next;
            return result.value;
        }

        result.prev.next = result.next;
        result.next.prev = result.prev;

        head.prev.next = result;
        result.prev = head.prev;

        head.prev = result;
        result.next = head;

        return result.value;

    }

    public void put(int key, int value) {
        if(table.get(key) != null) {
            get(key);
            table.get(key).value = value;
            return;
        }
        if(capacity == size) {
            table.remove(head.key);
            remove();
        }
        table.put(key, add(value, key));

    }

    /**
     * Adds a new node to end of the DLL
     * @param value
     * @returns the added node
     */
    private Node add(int value, int key) {
        Node n;
        if (head == null) {
            n = new Node(value, key);
            n.prev = n;
            n.next = n;
            head = n;
        } else {
            n = new Node(head.prev, head, value, key);
            head.prev.next = n;
            head.prev = n;
        }
        size++;
        return n;
    }

    /**
     * Removes the head of the DLL
     */
    private void remove() {
        if(size == 0) return;
        if (size == 1) {
            head = null;
        } else {
            Node n = head.next;
            n.prev = head.prev;
            head.prev.next = n;
            head.next = null;
            head.prev = null;
            head = n;
        }
        size--;
    }
}

