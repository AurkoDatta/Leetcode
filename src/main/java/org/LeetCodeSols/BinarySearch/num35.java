package org.LeetCodeSols.BinarySearch;

/***
 * regular binary search with start and end pointers
 * if we find the target just return mid right away
 * otherwise keep shrinking the range like normal
 * once the loop ends start is exactly where the target would get inserted
 */

public class num35 {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;

    }
}
