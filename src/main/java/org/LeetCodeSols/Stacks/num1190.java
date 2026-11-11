package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num1190 {
    public static String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder top = stack.pop();
                stack.peek().append(top.reverse());
            } else {
                stack.peek().append(c);
            }
        }

        return stack.pop().toString();
    }
}
