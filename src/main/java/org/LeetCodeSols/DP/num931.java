package org.LeetCodeSols.DP;

public class num931 {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int best = matrix[i - 1][j];

                if (j > 0) {
                    best = Math.min(best, matrix[i - 1][j - 1]);
                }

                if (j < n - 1) {
                    best = Math.min(best, matrix[i - 1][j + 1]);
                }

                matrix[i][j] += best;
            }
        }

        int result = Integer.MAX_VALUE;

        for (int val : matrix[n - 1]) {
            result = Math.min(result, val);
        }

        return result;
    }
}
