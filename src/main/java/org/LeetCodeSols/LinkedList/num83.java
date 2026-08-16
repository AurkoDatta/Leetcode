package org.LeetCodeSols.LinkedList;

/***
 * list is already sorted so duplicates are always next to each other
 * walk through with head and just compare it to head.next
 * if they match skip over the next node, otherwise move forward
 * keep current pointing at the original start so we can return it at the end
 */

public class num83 {

    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return current;

    }

    public static void main(String[] args) {

    }
}
