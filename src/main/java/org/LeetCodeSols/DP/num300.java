package org.LeetCodeSols.DP;

import java.util.Arrays;

/***
 * dp[i] holds the length of the longest increasing subsequence that ends right at i
 * every index starts at 1 since a single number is a subsequence of length one
 * for each i look back at every j before it, if nums[j] is smaller we could extend that subsequence
 * take whichever earlier option stretches dp[i] the furthest
 * answer is just the biggest value sitting anywhere in dp
 */

public class num300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }
}
