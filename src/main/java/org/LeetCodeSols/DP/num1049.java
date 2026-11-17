package org.LeetCodeSols.DP;

/***
 * every stone ends up smashed into one of two piles, and the final leftover weight is just the difference between those two piles, so the problem is really about splitting the stones into two groups as evenly as possible
 * target is set to half the total weight, and dp[i] tracks whether some subset of the stones can sum up to exactly i, turning this into a subset sum question
 * dp[0] starts true since a sum of zero is always reachable by taking no stones at all
 * for each stone, i is walked downward from target to that stone's weight, which keeps a stone from being counted into its own subset more than once while this pass fills in dp
 * once every stone has been processed, closest is found by scanning down from target to the first i where dp[i] is true, giving the largest reachable sum no bigger than half the total
 * the two piles end up weighing closest and total - closest, so the smallest possible leftover is just the gap between them, total - 2 * closest
 */

public class num1049 {
    public static int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                if (dp[i - stone]) {
                    dp[i] = true;
                }
            }
        }

        int closest = 0;
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                closest = i;
                break;
            }
        }

        return total - 2 * closest;
    }
}
