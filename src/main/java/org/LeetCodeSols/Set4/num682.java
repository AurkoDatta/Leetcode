package org.LeetCodeSols.Set4;

import java.util.Stack;

/***
 * Note: Also possible with ArrayList
 */

public class num682 {
    public static int calPoints(String[] operations) {

        int result = 0;

        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int value = stack.get((stack.size() - 1)) + (stack.get(stack.size() - 2));
                stack.push(value);
            } else if (op.equals("D")) {
                stack.push(stack.get(stack.size() - 1) * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
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
