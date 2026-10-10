package org.LeetCodeSols.LinkedList;

/***
 * a dummy node in front of head gives prev something to point at even if the very first nodes end up getting deleted
 * curr walks the list one node at a time, and whenever curr's value matches the value right after it, that value is a duplicate run to strip entirely
 * dupVal remembers that value, and the inner loop pushes curr forward past every node sharing it, including the first one, since none of them can survive
 * once curr sits past the whole run, prev.next is reattached straight to curr, skipping every node that held dupVal
 * when curr's value isn't repeated, prev just advances alongside curr since curr is a node that belongs in the final list
 * the loop ends once curr runs off the list, and dummy.next is the head of what's left after every duplicate run has been removed
 */

public class num82 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int dupVal = curr.val;
                while (curr != null && curr.val == dupVal) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
