package org.LeetCodeSols.LinkedList;

/***
 * walk through the list flipping each next pointer to face backwards
 * keep a prev pointer that trails behind as the new front of the reversed part
 * save the next node before flipping so we dont lose the rest of the list
 * once curr falls off the end prev is the new head
 */

public class num206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
