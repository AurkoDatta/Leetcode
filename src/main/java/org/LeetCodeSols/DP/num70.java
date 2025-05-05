package org.LeetCodeSols.DP;

import java.util.HashMap;
import java.util.Map;

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
