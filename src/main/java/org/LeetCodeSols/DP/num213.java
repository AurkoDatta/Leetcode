package org.LeetCodeSols.DP;

/***
 * same idea as regular house robber but the houses are in a circle now
 * so the first and last house count as neighbors, cant take both
 * just run the normal rob logic twice, once skipping the last house and once skipping the first
 * take whichever run gives the bigger total
 * special case for a single house since the circle logic does not really apply
 */

public class num213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int prev = 0;
        int curr = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
