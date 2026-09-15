package org.LeetCodeSols.LinkedList;

import java.util.HashMap;
import java.util.Map;

/***
 * use a hashmap to map each original node to its cloned copy
 * first pass walks the list and creates a clone for every node, storing original -> clone in the map
 * second pass walks the list again and wires up next and random on each clone by looking up the originals in the map
 * map.get(head) then gives back the head of the fully connected cloned list
 */

public class num138 {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
