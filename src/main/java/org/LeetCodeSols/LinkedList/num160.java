package org.LeetCodeSols.LinkedList;

/***
 * if the two lists intersect, the tails from the intersection point onward are identical, just reached after different amounts of lead-in
 * walking both pointers one step at a time and swapping each one onto the other list's head once it runs off its own end cancels out that length difference
 * pointer a covers lenA then lenB steps total, pointer b covers lenB then lenA steps total, so by the time either has gone through both lists they've both travelled the same distance
 * that means they land on the intersection node at exactly the same step, or both hit null together if the lists never intersect at all
 */

public class num160 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}
