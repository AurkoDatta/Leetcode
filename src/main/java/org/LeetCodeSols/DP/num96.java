package org.LeetCodeSols.DP;

/***
 * dp[nodes] holds how many structurally different BSTs can be built out of that many nodes, regardless of what values actually sit in them
 * zero nodes only has the empty tree, and a single node only has the one tree with nothing below it, so dp[0] and dp[1] both start out at 1
 * for a given total of nodes, picking which one of them acts as the root splits the rest into a left side of root - 1 nodes and a right side of nodes - root nodes, since a BST keeps everything smaller to the left and everything bigger to the right
 * every arrangement of the left side can be paired with every arrangement of the right side, so the trees that root contributes is dp[root - 1] times dp[nodes - root]
 * looping root over every possible position from 1 up to nodes and summing those products covers every tree that could ever have that many nodes, however it ends up shaped
 * dp[n] ends up holding the count for the full n nodes asked for in the problem, so that's what gets returned once the table is filled in
 */

public class num96 {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        return dp[n];
    }
}
