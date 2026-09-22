package org.LeetCodeSols.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * dp[i] tracks whether the prefix of s ending right before index i can be built out of dictionary words
 * dp[0] starts true since an empty prefix needs no words at all
 * for every end point i look back at every possible split point j
 * if dp[j] is already true and the chunk from j to i is a real word, then i is reachable too
 * dp[s.length()] at the end tells whether the whole string can be broken into dictionary words
 */

public class num139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
