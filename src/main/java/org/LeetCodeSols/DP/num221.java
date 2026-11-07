package org.LeetCodeSols.DP;

/***
 * dp[i][j] holds the side length of the biggest all-ones square whose bottom right corner sits at matrix[i - 1][j - 1], with dp padded by an extra row and column of zeroes so the edges of the matrix don't need special casing
 * a square can only end at a cell that's itself a '1', since a square made of anything else can never be all ones
 * when matrix[i - 1][j - 1] is '1', the biggest square ending there is bounded by whichever of the square ending just above, just to the left, and diagonally up left is smallest, since every one of those three has to be at least that big to extend into a bigger square
 * taking the min of those three neighbours and adding one grows the smallest of them by exactly one layer, which is as far as the square ending at the current cell can possibly stretch
 * maxSide just tracks the biggest value seen anywhere in dp while the table fills in, since the largest square anywhere in the matrix has to end at some cell
 * the final answer is an area, so maxSide gets squared before it's returned
 */

public class num221 {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
