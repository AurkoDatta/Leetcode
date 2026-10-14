package org.LeetCodeSols.BinarySearch;

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
