package org.LeetCodeSols.DP;

/***
 * dp[j] tracks the number of ways to reach column j in the row currently being processed, reusing the same array row after row
 * dp[0] starts at 1 since there's exactly one way to reach the top left cell, provided it isn't blocked
 * any cell sitting on an obstacle can never be reached, so dp[j] is forced to zero the moment obstacleGrid[i][j] is 1
 * for every column after the first, a clear cell just adds in the ways from the cell to its left, since that's the only new path merging in along the row
 * the first column of each row has no cell to its left, so it simply carries down whatever dp[0] already held from the row above
 * dp[n - 1] at the end holds every path that makes it all the way to the bottom right cell
 */

public class num63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
