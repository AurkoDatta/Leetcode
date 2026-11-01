package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * the stack holds pairs of a past price and the span it was given when it came in, kept from oldest at the bottom to most recent at the top
 * every call to next starts the span at 1, just counting today's own price
 * while the price sitting on top of the stack is no higher than today's price, it can never be the one that breaks today's streak, so it gets popped off and its whole span gets folded into today's
 * once a price taller than today's price turns up on top, that's the first earlier day that stops the streak, so the loop stops there and leaves it in place
 * today's price and span then get pushed on together, ready to be folded into some later, bigger day's span the same way
 */

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
