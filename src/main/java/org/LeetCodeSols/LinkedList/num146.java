package org.LeetCodeSols.LinkedList;

import java.util.HashMap;
import java.util.Map;

/***
 * map gives instant lookup from a key straight to its node, while a doubly linked list keeps every node ordered from least to most recently used
 * head and tail are dummy nodes that never hold real data, they just anchor both ends of the list so there's never a null edge case to worry about
 * the node right after head is always the least recently used entry, and the node right before tail is always the most recently used
 * remove unlinks a node from wherever it currently sits by pointing its neighbours straight at each other
 * insert always drops a node in right before tail, which marks it as the freshest entry in the cache
 * get looks the key up in the map, then removes and reinserts that node so it jumps to the most recently used spot before its value gets returned
 * put either moves an existing node to that same freshest spot or builds a brand new node, inserting it at the end and registering it in the map
 * once that insert pushes the map's size past capacity, the node right after head is the least recently used one, so it gets evicted from both the list and the map
 */

public class num146 {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public num146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
    }
}
