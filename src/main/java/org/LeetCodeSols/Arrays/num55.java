package org.LeetCodeSols.Arrays;

/***
 * reach tracks the farthest index that's been confirmed reachable from the start so far
 * walking through the array, if i ever goes past reach that index could never actually be landed on, so the end is out of reach
 * otherwise reach gets extended to whichever is bigger between its current value and i plus however far nums[i] lets it jump from there
 * reach only ever grows as i moves forward, so it either catches up to the last index or i runs into a gap it can't cross first
 * if the loop finishes walking the whole array without ever hitting an unreachable index, the last index must have been reachable too, so return true
 */

public class num55 {
    public static boolean canJump(int[] nums) {
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }
}
