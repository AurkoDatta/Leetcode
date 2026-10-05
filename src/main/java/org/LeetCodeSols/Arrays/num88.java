package org.LeetCodeSols.Arrays;

/***
 * nums1 has extra room at the end to fit all of nums2, so merging from the back avoids overwriting values that still need to be read
 * i tracks the last real element in nums1, j tracks the last element in nums2, and k tracks the last open slot in nums1
 * at each step whichever of nums1[i] or nums2[j] is bigger gets dropped into slot k, then that pointer and k both move back one
 * once nums2 runs out every value still left in nums1 is already sitting where it belongs, so the loop only needs to keep checking j
 */

public class num88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
