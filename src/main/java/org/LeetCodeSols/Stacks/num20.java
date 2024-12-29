package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * Use a stack approach
 * Loop through each character in the string
 * Push any opening brackets onto the stack
 * Else, set a new variable 'top' to the see what's at the top of the stack
 * If a closing parenthesis is encountered, check it against the top variable.
 * If the closing parenthesis matches the opening parenthesis at the top of the stack, parenthesis is valid
 * Perform a pop on the stack
 * Else, return false
 */

public class num20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ( (c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}
