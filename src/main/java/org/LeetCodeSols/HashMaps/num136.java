package org.LeetCodeSols.HashMaps;

import java.util.HashSet;
import java.util.Set;

public class num136 {
    public static int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                seen.remove(num);
            } else {
                seen.add(num);
            }
        }

        return seen.iterator().next();
    }
}
