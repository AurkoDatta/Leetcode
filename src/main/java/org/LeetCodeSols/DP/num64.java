package org.LeetCodeSols.DP;

/***
 * dp represents the minimum cost to reach each column of whichever row is currently being processed, reusing the same array row after row to save space
 * the first row can only be reached by moving right from the start, so dp begins as the running sum across grid's first row
 * moving into a new row, dp[0] can only be reached from directly above since there's no column to its left, so it just adds the next cell down in the first column
 * every other dp[j] takes the cheaper of the value still sitting from the row above or the value just updated to its left, then adds the current cell's own cost on top
 * by the time the last row finishes updating, dp[n - 1] holds the minimum path sum from the top left corner all the way to the bottom right corner
 */

public class num64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}
