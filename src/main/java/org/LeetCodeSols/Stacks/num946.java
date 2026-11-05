package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * the stack simulates whatever is actually sitting on the real stack as pushed is worked through left to right, so at any point it holds exactly the values that have been pushed but not yet popped
 * j tracks how far through popped the simulation has gotten, always pointing at the next value that's supposed to come off the stack
 * every value from pushed gets pushed onto the stack as soon as it's reached, since pushes always happen in that exact order and there's no way to push out of order
 * right after each push, popped[j] gets checked against whatever is now on top of the stack, and as long as they match that value gets popped and j moves forward, since a pop can happen at any point once the right value is on top
 * once nothing on top of the stack matches popped[j] anymore, the loop just moves on to pushing the next value, since nothing else can be popped until a later push puts the right value back on top
 * if pushed and popped really do describe a valid sequence of pushes and pops, every value will have been matched and popped by the time all of pushed has been pushed, leaving the stack empty, so that's the final check that gets returned
 */

public class num946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
