package org.LeetCodeSols.HashMaps;

import java.util.HashSet;
import java.util.Set;

public class num349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int[] output = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            output[idx++] = num;
        }

        return output;
    }
}
