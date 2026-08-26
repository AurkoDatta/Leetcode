package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * walk through the string one char at a time
 * build up a number whenever we see digits, thats the repeat count
 * push the count and whatever string we have so far when we hit a '['
 * when we hit a ']' pop back off and repeat the current chunk that many times, then keep going
 */

public class num394 {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int count = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for (int i = 0; i < count; i++) {
                    prev.append(current);
                }
                current = prev;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
