package org.LeetCodeSols.HashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
