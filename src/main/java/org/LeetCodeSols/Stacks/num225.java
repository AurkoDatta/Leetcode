package org.LeetCodeSols.Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class num225 {
    private Queue<Integer> queue;

    public num225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
