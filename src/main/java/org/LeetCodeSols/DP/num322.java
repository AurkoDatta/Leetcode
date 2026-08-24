package org.LeetCodeSols.DP;

import java.util.Arrays;

/***
 * dp[i] holds the fewest coins needed to make amount i
 * fill the array with something bigger than any real answer so it acts like infinity
 * for every amount try every coin and see if using it beats what we already have
 * if the last amount never got beaten down from infinity there was no way to make it
 */

public class num322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
