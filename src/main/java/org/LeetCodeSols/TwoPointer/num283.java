package org.LeetCodeSols.TwoPointer;

/***
 * slow pointer marks where the next nonzero value should end up
 * walk fast pointer across the whole array
 * whenever fast hits a nonzero swap it into the slow spot and move slow up
 * zeros end up pushed to the back on their own without extra passes
 */

public class num283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}
