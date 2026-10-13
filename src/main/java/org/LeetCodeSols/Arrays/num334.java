package org.LeetCodeSols.Arrays;

/***
 * first and second track the smallest and second smallest values seen so far while scanning left to right, both starting as high as possible
 * any num no bigger than first just becomes the new smallest candidate, since a smaller starting value only ever helps a future triplet
 * a num bigger than first but no bigger than second becomes the new second value, pairing up with whatever first currently holds to complete an increasing pair
 * once a num shows up bigger than both first and second, it's the third element of an increasing triplet, since first and second were both set by earlier numbers at earlier indices
 * second can only be updated after first has already been set beneath it, so whenever second holds a real value there's guaranteed to be some earlier first it followed
 * if the scan finishes without ever hitting that third bigger number, no increasing triplet exists anywhere in the array
 */

public class num334 {
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
