package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * lastIndex keeps track of the most recent index each value was seen at, so looking a value up tells you exactly where it last showed up
 * for every new index i, if nums[i] has been seen before and that last sighting is within k of i, the two duplicates sit close enough apart to answer true right away
 * a sighting that's further back than k isn't good enough on its own, but it still gets overwritten with the newer, closer index in case a later match needs it
 * every value gets its index written into lastIndex after the check, whether or not it was already present, so the map always reflects the latest position seen
 * if the loop runs out without ever finding a close enough pair, no two equal values were ever within k of each other, so false is returned
 */

public class num219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i]) && i - lastIndex.get(nums[i]) <= k) {
                return true;
            }
            lastIndex.put(nums[i], i);
        }

        return false;
    }
}
