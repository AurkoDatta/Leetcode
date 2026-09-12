package org.LeetCodeSols.LinkedList;

/***
 * use fast and slow pointers, slow moves one step at a time, fast moves two
 * if they meet somewhere inside the list there's a cycle, if fast hits null first there isn't one
 * once they meet reset a third pointer to head and move it one step at a time alongside slow
 * wherever those two meet next is the start of the cycle
 */

public class num142 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
