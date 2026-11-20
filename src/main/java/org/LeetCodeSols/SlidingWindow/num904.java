package org.LeetCodeSols.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class num904 {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            while (count.size() > 2) {
                count.put(fruits[left], count.get(fruits[left]) - 1);
                if (count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
