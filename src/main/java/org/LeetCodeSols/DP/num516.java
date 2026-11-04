package org.LeetCodeSols.DP;

/***
 * dp[i][j] holds the length of the longest palindromic subsequence sitting inside s between index i and index j, inclusive on both ends
 * a single character on its own is always a palindrome of length 1, so dp[i][i] gets set to that before anything else for every i
 * i walks backwards from the end of the string down to the start, with j always starting just past i and moving forward from there, so by the time dp[i][j] is being worked out, dp[i + 1][j - 1], dp[i + 1][j] and dp[i][j - 1] all already got filled in on an earlier pass
 * when s.charAt(i) matches s.charAt(j), those two matching ends can both be kept in the subsequence, adding 2 onto whatever the longest palindrome strictly between them already was
 * when they don't match, one end has to be dropped, so dp[i][j] just takes whichever is bigger between dropping i and dropping j
 * dp[0][n - 1] ends up covering the entire string, so that's what gets returned once the table is completely filled in
 */

public class num516 {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
