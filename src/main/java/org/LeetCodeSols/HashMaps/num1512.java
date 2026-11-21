package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * countMap tracks how many times each value has already turned up while walking through nums
 * for every num, count holds how many earlier indices already held that exact same value, and each one of those earlier occurrences pairs up with the current index to form a good pair
 * pairs picks up count more good pairs right there, since a good pair just needs two equal values with the first index coming before the second, and count is exactly how many earlier matching indices exist so far
 * countMap then gets num's count bumped up by one, so the next time this value shows up it knows about every occurrence that came before it, this one included
 * once every index has been walked through this way, pairs holds the total number of good pairs in nums
 */

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
