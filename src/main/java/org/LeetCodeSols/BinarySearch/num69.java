package org.LeetCodeSols.BinarySearch;

/***
 * binary search for the sqrt instead of guessing one number at a time
 * the answer has to sit somewhere between 1 and x / 2, so search that range
 * at each mid check mid * mid against x
 * if its exactly x we're done, if its too small record mid as the best answer so far and move right
 * if its too big move left, since mid cant be part of the answer
 * once left passes right whatever we last recorded is the floor of the sqrt
 * using long for mid and square avoids overflow since x can be large
 */

public class num69 {
    public static int mySqrt(int x) {
        if (x < 2) return x;

        long left = 1;
        long right = x / 2;
        long ans = 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) ans;
    }
}
