package org.LeetCodeSols.DP;

public class num132 {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (len == 2 || isPalindrome[i + 1][j - 1]);
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = -1;

        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                if (isPalindrome[i][j - 1]) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n];
    }
}
