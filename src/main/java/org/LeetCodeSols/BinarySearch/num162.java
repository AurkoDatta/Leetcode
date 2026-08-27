package org.LeetCodeSols.BinarySearch;

/***
 * binary search but comparing neighbors instead of a target value
 * if mid is smaller than the next element the peak has to be to the right
 * otherwise pull right down to mid since mid itself could be the peak
 * loop ends when left and right meet, that index is a peak
 */

public class num162 {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
