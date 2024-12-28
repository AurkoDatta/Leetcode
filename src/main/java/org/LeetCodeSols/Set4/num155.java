package org.LeetCodeSols.Set4;

/***
 * This solution is what the interviewer will probably want you to do, i.e, create a new stack
 * Imagine 'num155' is just minStack, so you can this entire class as code for an actual minStack
 * We use nodes to keep track of all values in the minStack
 * Use the push method, to add things onto the stack
 * Use the pop method, to remove things onto the stack
 * Use the top method, to get the value at the top of the stack
 * Use the min method, to get the minimum value in the stack
 */

public class num155 {
    private Node head;

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;

        }

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }

    }

    public void pop() {
        head = head.next;

    }

    public int top() {
        return head.val;

    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
