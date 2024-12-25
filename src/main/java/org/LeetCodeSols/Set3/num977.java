package org.LeetCodeSols.Set3;

import java.util.Arrays;

/***
 * Loop through all the integers in the input array, multiply them with themselves and add them to a new array
 * Sort the array and return it
 */

public class num977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }

        Arrays.sort(res);

        return res;

    }
}
