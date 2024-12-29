package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * Check the base case
 * Loop through the input array
 * While the stack is not empty and the current temperature is greater than the temperatuer at the top of the stock
 * set a variable j to stack.pop()
 * and set the fianl array to be answered at the index of j to the difference between the two indexes
 * After the while loop, push i to the stack
 *
 */

public class num739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0){
            return new int[0];
        }


        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);

        }

        return result;

    }

    public static void main(String[] args) {
        int[] temps = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(temps));
    }
}
