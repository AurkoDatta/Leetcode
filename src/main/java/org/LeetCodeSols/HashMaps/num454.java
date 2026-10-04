package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * brute forcing all four arrays together would mean checking every possible quadruple, which gets expensive fast
 * instead split the problem into two halves, pairing nums1 with nums2 and nums3 with nums4
 * the first double loop walks every pair from nums1 and nums2, storing how many times each possible sum shows up in sumCount
 * the second double loop walks every pair from nums3 and nums4, and for each pair looks up the negation of their sum in that same map
 * any sum sumCount already holds for -(c + d) means those two pairs add up to zero together, so its stored count gets added onto the running total
 * once both nums3 and nums4 have been fully walked, count holds every quadruple across all four arrays that sums to zero
 */

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
