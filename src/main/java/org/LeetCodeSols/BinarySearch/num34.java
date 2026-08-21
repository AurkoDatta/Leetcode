package org.LeetCodeSols.BinarySearch;

/***
 * two separate binary searches instead of one
 * first one hunts for the leftmost index where target shows up
 * second one hunts for the rightmost index, same idea just flipped
 * whenever nums[mid] equals target keep pushing the boundary further that direction instead of stopping
 * if the left search never finds the target just return -1 -1 right away
 */

public class num34 {
    public static int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    private static int findBound(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;

                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
