package org.LeetCodeSols.BinarySearch;

/***
 * a mountain array only rises then falls, so the slope at any index tells you which side of the peak you're on
 * checking mid against mid + 1 reveals that slope without needing to look at the whole array
 * if arr[mid] is less than arr[mid + 1] the array is still climbing at mid, so the peak has to be somewhere to the right, meaning left can move past mid
 * if arr[mid] is greater than arr[mid + 1] the array is already coming down, so mid itself could still be the peak, meaning right should land on mid instead of mid - 1
 * narrowing the window this way on every step guarantees left and right converge on the single index where the climb turns into the descent
 */

public class num852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
