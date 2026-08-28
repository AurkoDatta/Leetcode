package org.LeetCodeSols.LinkedList;

/***
 * use a dummy node in front so left can be position 1 without a special case
 * walk prev up to right before the left position
 * repeatedly grab the node right after curr and move it to sit right after prev
 * doing that right - left times flips just that section around
 */

public class num92 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode moved = curr.next;
            curr.next = moved.next;
            moved.next = prev.next;
            prev.next = moved;
        }

        return dummy.next;
    }
}
