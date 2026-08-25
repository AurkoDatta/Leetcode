package org.LeetCodeSols.BinarySearch;

/***
 * plain binary search on a sorted array, nothing fancy here
 * keep a left and right pointer and look at the middle each time
 * if the middle is too small move left up, too big move right down
 * if we ever land on the target just return that index, otherwise -1 once the pointers cross
 */

public class num704 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
