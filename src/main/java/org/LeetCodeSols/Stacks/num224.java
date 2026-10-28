package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * sign tracks whether the number currently being built should end up added or subtracted into result, flipping whenever a + or - is read
 * digits keep accumulating into num as they're read, since a number can be more than one character long
 * hitting a + or - means the number just finished, so sign * num gets folded into result, num resets to zero, and sign updates for whatever comes next
 * an open parenthesis means a nested expression is starting, so the running result and sign get pushed onto the stack and both reset to act as a fresh result and sign for just that inner expression
 * a close parenthesis means the nested expression just finished, so its trailing num gets folded in first, then that sub-result gets multiplied by the sign that was pushed before the parenthesis and added onto the result that was pushed before it, reconstructing the outer expression exactly as if the parentheses were never there
 * once the string ends there's no operator or parenthesis left to trigger the usual fold, so the final sign * num has to be added onto result directly in the return statement
 */

public class num224 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
                sign = 1;
            }
        }

        return result + sign * num;
    }
}
