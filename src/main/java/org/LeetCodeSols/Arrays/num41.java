package org.LeetCodeSols.Arrays;

/***
 * if the first missing positive exists it has to be somewhere between 1 and n, since n positives can only fill in the gaps up to n before one is guaranteed to be missing
 * that means every number belongs at a specific home, the value v belongs at index v - 1, so the array itself can be used as a hash set with no extra space
 * the first loop walks every index and keeps swapping whatever sits there into its correct home, skipping numbers that are out of range or already duplicates sitting in place
 * once every swap that can happen has happened, every value that belongs somewhere in the array is sitting at its correct index
 * the second loop just scans for the first index whose value doesn't match where it should be, that index plus one is the missing positive
 * if every index lines up perfectly then nothing from 1 to n is missing, so the answer has to be n + 1
 */

public class num41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }
}
