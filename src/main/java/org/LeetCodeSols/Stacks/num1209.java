package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num1209 {
    public static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }

            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] pair : stack) {
            for (int i = 0; i < pair[1]; i++) {
                sb.append((char) pair[0]);
            }
        }

        return sb.toString();
    }
}
