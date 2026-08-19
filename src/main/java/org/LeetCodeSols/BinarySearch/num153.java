package org.LeetCodeSols.BinarySearch;

/***
 * array is sorted then rotated so there is one dip somewhere in the middle
 * compare mid to right instead of left, that tells which side the dip is on
 * if nums[mid] > nums[right] the min has to be somewhere right of mid
 * otherwise the min is at mid or to the left of it, so pull right down to mid
 * left eventually lands on the smallest value
 */

public class num153 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
