package org.LeetCodeSols.BinarySearch;

/***
 * still binary search but the array got rotated at some pivot
 * at every mid figure out which half (left or right of mid) is actually sorted
 * if target falls inside that sorted half narrow into it
 * otherwise search the other half
 * keep doing that until left passes right
 */

public class num33 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
