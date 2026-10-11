package org.LeetCodeSols.BinarySearch;

public class num1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int neededDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                neededDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return neededDays <= days;
    }
}
