package org.LeetCodeSols.BinarySearch;

public class num1482 {
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int streak = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                streak++;
                if (streak == k) {
                    bouquets++;
                    streak = 0;
                }
            } else {
                streak = 0;
            }
        }

        return bouquets >= m;
    }
}
