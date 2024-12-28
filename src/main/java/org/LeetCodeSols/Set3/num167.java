package org.LeetCodeSols.Set3;

import java.util.HashMap;
import java.util.Map;

/***
 * This is the sum as the other twoSum question (num1 from Set2)
 * Since this is 1-indexed, we add 1 to each integer in the final array and return that
 */

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
