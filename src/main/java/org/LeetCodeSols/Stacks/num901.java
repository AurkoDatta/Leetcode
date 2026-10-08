package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num901 {
    private Stack<int[]> stack;

    public num901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
