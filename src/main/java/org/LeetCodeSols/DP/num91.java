package org.LeetCodeSols.DP;

/***
 * dp[i] holds the number of ways to decode the prefix of s ending at index i
 * dp[0] starts at 1 for the empty prefix, dp[1] starts at 1 unless the string opens with a 0, which can't decode to anything
 * for every later index look at the last one digit and the last two digits
 * the one digit chunk only adds dp[i - 1] ways if it isn't a leading zero
 * the two digit chunk only adds dp[i - 2] ways if it falls between 10 and 26
 * dp[n] at the end holds the total number of ways to decode the whole string
 */

public class num91 {
    public static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
