package org.LeetCodeSols.BinarySearch;

public class num441 {
    public static int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coins = mid * (mid + 1) / 2;

            if (coins <= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) result;
    }
}
