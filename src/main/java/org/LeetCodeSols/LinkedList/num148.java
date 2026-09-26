package org.LeetCodeSols.LinkedList;

/***
 * split the list into two halves using the slow and fast pointer trick, slow lands right on the midpoint as fast runs off the end
 * cutting the link after slow turns the single list into two independent sublists that can each be sorted on their own
 * recursively call sortList on both halves until a sublist is down to one node, which is already sorted by itself
 * merge then walks the two sorted halves together, always attaching whichever head node holds the smaller value next
 * once one half runs dry the rest of the other half gets attached as is, since everything left in it is already in order
 */

public class num148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
