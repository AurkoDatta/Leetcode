package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * walking the string left to right, a stack holds every character that hasn't been cancelled out yet
 * before pushing the current character it's compared against whatever sits on top of the stack
 * if they match, that top character just found its adjacent duplicate, so it gets popped instead of the current one being pushed
 * if they don't match, the current character has nothing to cancel with yet, so it gets pushed on top to wait for its own possible match later
 * removing one matched pair can expose two characters that were separated by it and now sit adjacent on the stack, so the next comparison naturally catches that too
 * once every character has been processed, whatever is left on the stack is the string with every adjacent duplicate pair removed, read bottom to top
 */

public class num1047 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
