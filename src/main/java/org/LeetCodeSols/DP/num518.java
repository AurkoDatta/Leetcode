package org.LeetCodeSols.DP;

/***
 * dp[i] holds the number of ways to make amount i using the coins processed so far
 * dp[0] starts at 1 since there's exactly one way to make amount zero, by using no coins at all
 * coins are looped on the outside and amounts on the inside, which locks in the order coins are considered in and stops the same combination from being counted more than once with coins in a different order
 * for each coin, every amount from that coin's value up to the target picks up dp[i - coin] more ways, since each of those ways can now be extended by using this coin once more
 * dp[amount] at the end holds every combination of the full coin set that adds up to amount, regardless of how many of each coin is used
 */

public class num518 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
