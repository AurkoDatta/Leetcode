package org.LeetCodeSols.TwoPointer;

/***
 * low, mid, and high split the array into three regions as the scan goes: everything before low is confirmed 0s, everything from low to mid is confirmed 1s, and everything after high is confirmed 2s
 * mid is the only pointer that actually walks through the unsorted middle region, deciding what each value is as it goes
 * a 0 at mid belongs with the other 0s, so it gets swapped down to low, and since whatever was at low is already known to be a 1, mid can safely move forward right along with low
 * a 1 at mid is already sitting where it belongs, so mid just moves on without needing a swap
 * a 2 at mid gets swapped out to high, but mid can't move forward yet since the value swapped in from high hasn't been checked, so only high steps inward
 * once mid passes high there's nothing left unsorted in the middle, and the three regions together cover the whole array in order
 */

public class num75 {
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
