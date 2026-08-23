package org.LeetCodeSols.BinarySearch;

/***
 * binary search on the eating speed itself, not the array
 * low is 1, high is the biggest pile since eating speed never needs to be more than that
 * for a given speed k figure out how many hours it takes to clear every pile, using ceiling division per pile
 * if hours fits within h try to go slower, otherwise go faster
 * keep the smallest speed that still works
 */

public class num875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }

        return hours <= h;
    }
}
