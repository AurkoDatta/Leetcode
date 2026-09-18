package org.LeetCodeSols.TwoPointer;

/***
 * treat each value in nums as a pointer to the next index, since every value points somewhere inside the array
 * a repeated number means two different indices point into the same spot, so following the pointers has to loop
 * slow moves one step at a time and fast moves two, they're guaranteed to meet somewhere inside that loop
 * once they meet, reset slow back to the start and move both one step at a time
 * they meet again exactly at the start of the loop, which is the duplicate value
 */

public class num287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
