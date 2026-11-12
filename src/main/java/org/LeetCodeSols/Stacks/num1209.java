package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * the stack holds runs of the same character seen so far, each entry pairing that character with how many of it are currently stacked up in a row
 * walking through s one character at a time, a character matching whatever run is on top just extends that run, so its count gets bumped instead of pushing a new entry
 * a character that doesn't match what's on top starts a brand new run of its own, so a fresh pair gets pushed with a count of 1
 * right after updating the top run's count, it gets checked against k, and a run that's reached exactly k characters gets popped off entirely, since k of the same character in a row is exactly what's supposed to disappear
 * once every character in s has been processed this way, whatever runs are left on the stack are the ones that survived without ever hitting k, so rebuilding the string from the bottom of the stack up, repeating each character by its run's count, gives the final answer
 */

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
