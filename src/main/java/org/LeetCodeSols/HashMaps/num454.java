package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class num454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCount = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                count += sumCount.getOrDefault(-(c + d), 0);
            }
        }

        return count;
    }
}
