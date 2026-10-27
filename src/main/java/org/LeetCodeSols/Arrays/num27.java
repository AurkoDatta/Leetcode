package org.LeetCodeSols.Arrays;

/***
 * k tracks how many values have been kept so far, and also doubles as the index where the next kept value goes
 * walking i across the whole array, any value that isn't val gets copied into nums[k] and k moves forward by one
 * values equal to val just get skipped over, so they never make it into the kept portion of the array
 * by the end k holds exactly how many values survived, and the first k slots of nums hold all of them in their original order
 * returning k is enough since leetcode only checks that the first k elements match, whatever comes after that in the array is ignored
 */

public class num27 {
    public static int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
