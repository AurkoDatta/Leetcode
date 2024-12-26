package org.LeetCodeSols.Set4;

import java.util.Stack;

/***
 * Loop through the input array and push elements onto a stack
 * Look at the comments on the if-statements for explanation
 * At the end, the number pushed on the stack last will be the answer
 * So we just return stack.pop()
 */

public class num150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();


        for (String token : tokens) {
            if (token.equals("+")) {
                //If the operand is +, add the last two integers in the stack
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                //If the operand is -, subtract the last integer in the stack from the second last integer
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (token.equals("*")) {
                //If the operand is *, multiply the last two integers in the stack
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                //If the operand is /, divide the second last integer in the stack by the last integer
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else{
                //Push all integers onto the stack for operations to be done on them
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

}
