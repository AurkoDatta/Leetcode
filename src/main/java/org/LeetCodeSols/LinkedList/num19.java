package org.LeetCodeSols.LinkedList;

/***
 * use a dummy node before head so removing the actual head node isnt a special case
 * move a fast pointer n+1 steps ahead of slow first
 * then move both together until fast falls off the end
 * slow is now sitting right before the node that needs to go, just skip it
 */

public class num19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
