package org.LeetCodeSols.DP;

import java.util.HashMap;
import java.util.Map;

/***
 * same fib as before but with a hashmap to remember answers already worked out
 * base case is still n is 0 or 1
 * before recursing check the map first, if its there just hand it back
 * otherwise compute it the normal way and stash it before returning
 * cuts out all the repeated calls the plain recursive version was doing
 */

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
