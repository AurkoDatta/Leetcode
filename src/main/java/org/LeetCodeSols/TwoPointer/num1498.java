package org.LeetCodeSols.TwoPointer;

import java.util.Arrays;

public class num1498 {
    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int MOD = 1_000_000_007;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        long count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = (count + pow2[right - left]) % MOD;
                left++;
            }
        }

        return (int) count;
    }
}
