package org.LeetCodeSols.DP;

/***
 * dp[i][j] tracks whether the first i characters of s can be matched against the first j characters of p
 * dp[0][0] starts true since an empty pattern matches an empty string
 * the first loop fills in dp[0][j] for every pattern prefix that's just a run of char-star pairs, since a star can always wipe out the character right before it and leave nothing behind to match against the still-empty s
 * for every other cell, pc is the pattern character currently being looked at, and when pc is a star dp[i][j] is true either by letting the star and the character before it contribute nothing at all (dp[i][j - 2]) or by letting the star swallow one more copy of the current s character (dp[i - 1][j]), with that second option only valid when the character the star follows is a dot or already matches s's current character
 * when pc isn't a star, dp[i][j] is simply inherited from dp[i - 1][j - 1] whenever pc is a dot or equal to s's current character, since both s and p only move forward by consuming exactly one character each in that case
 * dp[m][n] at the end holds whether the entire string s can be matched against the entire pattern p
 */

public class num10 {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    char prev = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2] || ((prev == '.' || prev == s.charAt(i - 1)) && dp[i - 1][j]);
                } else if (pc == '.' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
