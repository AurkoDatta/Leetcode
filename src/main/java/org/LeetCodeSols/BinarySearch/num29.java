package org.LeetCodeSols.BinarySearch;

/***
 * the one case that can actually overflow an int is Integer.MIN_VALUE divided by -1, since the true answer doesn't fit in an int, so that gets caught and returned up front before anything else runs
 * everything after that works off the absolute values of both numbers stored as longs, which keeps the doubling below from overflowing and lets the sign be handled separately at the very end
 * the outer loop keeps peeling multiples of the divisor off of a for as long as a is still at least as big as the divisor
 * the inner loop is what makes each peel fast: temp starts at the divisor and doubles every pass while multiple doubles right alongside it, so temp is always some power-of-two multiple of the divisor and multiple is tracking exactly which multiple that is
 * once doubling temp again would push it past a, the inner loop stops, that temp gets subtracted from a in one shot, and result picks up however many divisors multiple says that chunk was worth
 * once a finally drops below the divisor the outer loop ends, result holds the quotient's magnitude, and xor-ing the original signs decides whether the final answer comes back negative or positive
 */

public class num29 {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;

        while (a >= b) {
            long temp = b;
            long multiple = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);
        return negative ? (int) -result : (int) result;
    }
}
