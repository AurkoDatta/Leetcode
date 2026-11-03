package org.LeetCodeSols.Arrays;

/***
 * an array of n numbers that's supposed to hold every value from 0 to n but is missing exactly one still has a sum that can be measured against what the full, complete range would have added up to
 * expectedSum uses the formula for the sum of the first n natural numbers, n * (n + 1) / 2, stretched to cover 0 through n even though the array itself only holds n of those n + 1 possible values
 * actualSum just adds up whatever's actually sitting in the array, which comes up short of expectedSum by exactly whatever the missing number would have contributed
 * subtracting actualSum from expectedSum isolates that one missing contribution, leaving behind the value that never made it into the array
 */

public class num268 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
