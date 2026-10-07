package org.LeetCodeSols.DP;

/***
 * splitting nums into two equal sum subsets only works if the total sum is even, so that's checked first and ruled out immediately if not
 * target becomes half the total, and the problem turns into whether some subset of nums can add up to exactly target
 * dp[i] tracks whether a sum of i is reachable using the numbers processed so far, with dp[0] always true since an empty subset sums to zero
 * each num is folded in by walking i backwards from target down to num, so a number never gets used twice within the same pass
 * going backwards matters here because updating dp[i] from dp[i - num] in the same iteration would let num get reused, which a 0/1 subset can't do
 * once every number has been folded in, dp[target] says whether some subset actually reaches half the total
 */

public class num416 {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }

        return dp[target];
    }
}
