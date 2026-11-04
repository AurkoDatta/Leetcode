package org.LeetCodeSols.Stacks;

import java.util.Stack;

public class num316 {
    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] onStack = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (onStack[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                onStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            onStack[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
