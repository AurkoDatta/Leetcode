package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * Note: Also possible with ArrayList, Uses basically the same logic
 */

/***
 * Loop through the input array
 * Depending on what is encountered in the loop, run the appropriate logic, and push to stack
 * At the end, add up all the integers in the stack and return the answer
 */

public class num682 {
    public static int calPoints(String[] operations) {

        int result = 0;

        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if (op.equals("+")) {
                //If this is encountered, get the last two values in the stack, and add them up, then push
                int value = stack.get((stack.size() - 1)) + (stack.get(stack.size() - 2));
                stack.push(value);
            } else if (op.equals("D")) {
                //If this is encountered, get the last value in the stack, and double it, then push
                stack.push(stack.get(stack.size() - 1) * 2);
            } else if (op.equals("C")) {
                //If this is encountered, remove the last item in the stack
                stack.pop();
            } else {
                //Push all integers to the stack
                int currentNumber = Integer.parseInt(op);
                stack.push(currentNumber);
            }
        }

        for (int i : stack) {
            result += i;
        }

        return result;
    }


    public static void main(String[] args) {
        String[] test = {"5","2","C","D","+"};
        System.out.println(calPoints(test));
    }

}
