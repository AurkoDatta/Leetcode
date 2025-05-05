package org.LeetCodeSols.DP;

import java.util.HashMap;
import java.util.Map;

public class num509v2 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if(n <= 1){
            return n;
        }

        if (memo.containsKey(n)){
            return memo.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);

        memo.put(n, result);
        return result;
    }
}
