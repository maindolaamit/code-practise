package com.leetcode.archive;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> m;
    Node head = null;
    Node tail = null;
    int capacity;

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        m = new LinkedHashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node n = m.get(key);
            // remove node
            removeKey(key);
            addLast(n.key, n.value);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        int s = m.size();
        if (m.containsKey(key)) {
            removeKey(key);
            addLast(key, value);
            m.get(key).value = value;
        } else {
            // key is new so check if the size is full
            if (s >= this.capacity) {
                int rmkey = tail.key;
                tail = tail.next;
                m.remove(rmkey);
            }
        }
        // add key value to the map and to the end of the list
        m.put(key, addLast(key, value));
    }

    private Node addLast(int key, int value) {
        Node n = new Node(key, value);
        // reset head
        n.prev = head;
        head.next = n;
        head = n;
        return n;
    }

    private void removeKey(int key) {
        Node n = m.get(key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
}
