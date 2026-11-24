package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num1475 {
    public static int[] finalPrices(int[] prices) {
        int[] result = prices.clone();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}
