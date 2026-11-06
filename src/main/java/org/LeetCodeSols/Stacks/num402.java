package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * the stack builds up the result digit by digit, keeping it as small as possible at every position while still leaving enough digits behind to reach the required length
 * each new digit c gets compared against whatever is on top of the stack, and as long as the top is bigger than c and there are still removals left in k, that top digit gets popped, since swapping a bigger leading digit for a smaller one later always makes the number smaller
 * once nothing on top is bigger than c anymore, or k has run out, c just gets pushed on and the process moves to the next digit
 * if k still has removals left after the whole string has been pushed through, the biggest digits left are the ones sitting at the very end of the stack, so those get popped off until k reaches 0
 * building sb out of the stack leaves the digits in the same order they were pushed, which is the original left to right order of whatever survived
 * leading zeroes left over from the removals get stripped off, and the whole thing collapses to "0" if nothing meaningful is left
 */

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
