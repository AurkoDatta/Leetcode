package org.LeetCodeSols.HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * first pass builds a frequency map of every value in nums1, so its known how many times each number showed up there
 * walking nums2 after that checks each value against that map instead of rescanning nums1 every time
 * whenever a value still has a positive count left it gets added to result and its count in the map drops by one, so it can only be matched as many times as it actually appeared in nums1
 * values nums2 holds that never showed up in nums1, or that already used up all their matches, just get skipped
 * result is sized to the smaller of the two arrays since the intersection can never be longer than that, and idx tracks how many slots actually got filled
 * Arrays.copyOf trims result down to just those idx filled slots before returning, dropping the unused trailing zeros
 */

public class num350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;

        for (int num : nums2) {
            int freq = counts.getOrDefault(num, 0);
            if (freq > 0) {
                result[idx++] = num;
                counts.put(num, freq - 1);
            }
        }

        return Arrays.copyOf(result, idx);
    }
}
