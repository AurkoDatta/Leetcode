package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num402 {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        sb.delete(0, i);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
