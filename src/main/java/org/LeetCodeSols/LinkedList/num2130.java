package org.LeetCodeSols.LinkedList;

/***
 * find the middle of the list with fast and slow pointers
 * reverse the second half in place starting from that middle node
 * walk a pointer from the original head and a pointer from the reversed half together
 * at each step they land on a twin pair, so add them up and keep the biggest sum seen
 */

public class num2130 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        int max = 0;
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            max = Math.max(max, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return max;
    }
}
