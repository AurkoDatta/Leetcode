package org.LeetCodeSols.Arrays;

/***
 * currSum tracks the largest sum of a subarray that ends exactly at the current index
 * at every number, currSum either extends the previous subarray by adding the current number on, or drops everything before it and starts fresh at the current number alone
 * starting fresh only wins once the running sum has gone negative enough that carrying it forward would drag the next subarray down instead of helping it
 * maxSum holds the best currSum seen across every index visited so far, getting updated right after currSum is recomputed each step
 * once the loop finishes walking the whole array, maxSum holds the maximum subarray sum overall
 */

public class num53 {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
