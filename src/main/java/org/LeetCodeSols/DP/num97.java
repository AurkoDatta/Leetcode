package org.LeetCodeSols.DP;

/***
 * s3 is an interleaving of s1 and s2 only if its length matches the combined length of the two, so that mismatch is checked first as a quick exit
 * dp[i][j] tracks whether the first i characters of s1 and the first j characters of s2 can interleave to form the first i + j characters of s3
 * dp[0][0] is true since two empty strings trivially interleave into an empty prefix of s3
 * the first row and first column only ever pull from one of the two strings, so each is filled by checking that the previous cell was reachable and the next character lines up with s3
 * for every other cell, dp[i][j] is true if either the character just taken from s1 matches s3 while dp[i - 1][j] was already true, or the character just taken from s2 matches s3 while dp[i][j - 1] was already true
 * s3's index for the current pair is always i + j - 1 since every step advances exactly one position into s3 regardless of which string it came from
 * dp[m][n] at the end answers whether the full strings s1 and s2 together can interleave into all of s3
 */

public class num97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n];
    }
}
