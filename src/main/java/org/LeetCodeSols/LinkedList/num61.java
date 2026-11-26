package org.LeetCodeSols.LinkedList;

/***
 * the list is first walked once to find its length and its tail node, since rotating by k only makes sense relative to how many nodes there actually are
 * shift is k reduced modulo length, because rotating a list of length nodes by exactly length steps brings it right back to where it started, so only the remainder actually moves anything
 * if shift comes out to 0, either because k was already a multiple of length or the list is too short to rotate, the original head is returned untouched
 * otherwise tail.next is pointed back at head, turning the list into a cycle so the new head and new tail can both be found by walking forward from a single starting point
 * stepsToNewTail counts how many nodes stay in front of the rotation point, which is just length minus shift, since those are the nodes that end up at the back of the rotated list
 * walking that many steps from the old tail lands on newTail, the node that should become the last node of the rotated list, and newTail.next is exactly the node that should become the new head
 * breaking the cycle by setting newTail.next to null leaves a proper list again, now starting at newHead instead of the original head
 */

public class num61 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        int shift = k % length;
        if (shift == 0) return head;

        tail.next = head;
        int stepsToNewTail = length - shift;
        ListNode newTail = tail;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
