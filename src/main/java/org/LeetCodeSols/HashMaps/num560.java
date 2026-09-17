package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * keep a running prefix sum while walking through nums
 * a map tracks how many times each prefix sum has shown up so far, starting with sum 0 seen once
 * if sum - k has been seen before, every one of those earlier prefixes marks the start of a subarray that adds up to k
 * add however many times sum - k was seen to the count, then record the current sum in the map
 * count ends up holding the total number of subarrays in nums that sum to k
 */

public class num560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
