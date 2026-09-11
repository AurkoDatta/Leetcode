package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * walk through the asteroids left to right, keeping a stack of the ones still moving right
 * a right moving asteroid always just gets pushed, nothing to collide with yet
 * when a left moving one shows up compare it against whatever is on top of the stack
 * smaller one on top gets popped and we keep checking the next one down
 * same size means they both blow up, bigger one on top means the new asteroid is the one that explodes
 * if it survives all the way through it gets pushed on too
 * whatever is left in the stack at the end is the final state, read bottom to top
 */

public class num735 {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(java.util.Arrays.toString(asteroidCollision(asteroids)));
    }
}
