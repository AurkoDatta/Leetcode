package org.LeetCodeSols.BinarySearch;

/***
 * same binary search idea as the non duplicate version, but duplicates can make nums[left], nums[mid], and nums[right] all equal
 * when that happens there's no way to tell which half is actually sorted, so left and right both shrink in by one and the loop just tries again
 * otherwise check nums[left] <= nums[mid] to find which half is sorted, same as the non duplicate version
 * if target falls inside that sorted half narrow into it, otherwise search the other half
 * keep going until left passes right, returning true the moment nums[mid] matches the target and false if the loop runs out
 */

public class num81 {
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
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

        return false;
    }
}
