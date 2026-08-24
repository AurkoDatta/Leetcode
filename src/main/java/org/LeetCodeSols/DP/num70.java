package org.LeetCodeSols.DP;

import java.util.HashMap;
import java.util.Map;

/***
 * climbing n stairs one or two at a time, counting how many ways to reach the top
 * first method recurses on n-1 and n-2 with a hashmap memo so it stops redoing work
 * second method builds it bottom up in an array, each step is just the sum of the two before it
 * dp[0] is set to 1 as the base case and the answer ends up sitting at dp[n]
 */

public class num70 {
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if( n <= 2 ){
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, res);
        return res;

    }

    public int climbStairsFaster(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1){
                dp[i] = dp[i-1] + 0;
            }
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];

    }
}
