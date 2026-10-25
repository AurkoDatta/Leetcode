package org.LeetCodeSols.BinarySearch;

/***
 * instead of testing every candidate root one at a time, binary search narrows in on it directly
 * any square root of num has to land somewhere between 2 and num / 2, so that's the range worth searching
 * at each step mid gets squared and compared against num
 * if the square lands exactly on num, mid is the root and num is a perfect square
 * if the square comes up short, the real root has to be bigger, so left moves past mid
 * if the square overshoots, the real root has to be smaller, so right moves before mid
 * left and right keep closing in until they cross, and if no mid along the way ever squared to exactly num, it isn't a perfect square
 * mid and square are kept as long so squaring a large mid never overflows past what an int can hold
 */

public class num367 {
    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 2;
        long right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
