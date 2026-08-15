package org.LeetCodeSols.LinkedList;

/***
 * make a dummy head node so there is no special case for the first node
 * keep a tail pointer that always points to the last merged node
 * compare the heads of both lists and attach whichever one is smaller
 * move that list forward one node and move tail forward too
 * once one list runs out, attach the rest of the other list to tail
 */

public class num21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
