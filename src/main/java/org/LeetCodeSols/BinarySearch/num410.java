package org.LeetCodeSols.BinarySearch;

public class num410 {
    public static int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canSplit(int[] nums, int m, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays <= m;
    }
}
