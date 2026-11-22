package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * sum tracks the running difference between ones and zeroes seen so far, going up by one for every 1 and down by one for every 0
 * a subarray has an equal number of 0s and 1s exactly when the running sum at its end matches the running sum right before it started, since whatever happened in between cancelled itself out
 * map remembers the earliest index where each running sum value was first reached, seeded with sum 0 at index -1 to cover a balanced subarray starting right from the beginning
 * when the current sum has already been seen before, the stretch between that earlier index and now is a balanced subarray, so maxLen gets updated if this stretch is longer than what's been found so far
 * a sum is only ever stored the first time it's seen, since the earliest occurrence always gives the longest possible subarray for any later index that reaches the same sum
 * maxLen at the end holds the length of the longest subarray with an equal number of 0s and 1s
 */

public class num525 {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
