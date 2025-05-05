package org.LeetCodeSols.DP;

public class num509 {
    public static int fib(int n) {
         if (n <= 1){
             return n;
         }
         return fib(n - 1) + fib(n - 2);

    }
}
