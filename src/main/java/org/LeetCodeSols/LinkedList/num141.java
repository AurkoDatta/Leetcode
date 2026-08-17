package org.LeetCodeSols.LinkedList;

/***
 * classic fast and slow pointer thing
 * slow moves one step at a time, fast moves two
 * if there is a cycle fast will eventually lap slow and they land on the same node
 * if fast hits null there was no cycle to begin with
 */

public class num141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
