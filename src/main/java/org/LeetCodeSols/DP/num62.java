package org.LeetCodeSols.DP;

import java.util.Arrays;

/***
 * robot can only go right or down so paths to a cell are just paths from above plus paths from the left
 * start the top row as all ones since theres only one way across it
 * for each row after that add the value to the left into a running total, thats the new count for that column
 * end up with the answer sitting in the last spot of the array
 */

public class num62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
