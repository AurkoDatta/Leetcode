package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class num1512 {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int pairs = 0;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            pairs += count;
            countMap.put(num, count + 1);
        }

        return pairs;
    }
}
