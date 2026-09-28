package org.LeetCodeSols.DP;

public class num494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total || (total + target) % 2 != 0) {
            return 0;
        }

        int sum = (total + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[sum];
    }
}
