package org.LeetCodeSols.DP;

/***
 * build a 2d dp table where dp[i][j] is the lcs length using the first i characters of text1 and first j of text2
 * row 0 and column 0 stay 0 since an empty string has no common subsequence with anything
 * if the characters at i-1 and j-1 match, extend the diagonal value by 1
 * otherwise take whichever is bigger, dropping a character from either string
 * dp[m][n] ends up holding the answer for the full strings
 */

public class num1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
