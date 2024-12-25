package org.LeetCodeSols.Set3;

import java.util.HashMap;
import java.util.Map;

public class num167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int complement = target - numbers[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i + 1};
            }
            numMap.put(numbers[i], i+1);
        }

        return new int[]{};
    }
}
