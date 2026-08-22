package org.LeetCodeSols.DP;

/***
 * straight up recursive version, no memo here
 * base case is n is 0 or 1, just return n itself
 * otherwise its the sum of the previous two fib calls
 * works fine but recomputes the same subproblems over and over, v2 fixes that
 */

public class num509 {
    public static int fib(int n) {
         if (n <= 1){
             return n;
         }
         return fib(n - 1) + fib(n - 2);

    }
}
