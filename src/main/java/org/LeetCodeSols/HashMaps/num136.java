package org.LeetCodeSols.HashMaps;

import java.util.HashSet;
import java.util.Set;

/***
 * every value in nums shows up exactly twice except for one, so a value toggling in and out of a set tracks whether its pair has been seen yet
 * walking through nums, a value not yet in the set means this is its first appearance, so it gets added
 * a value already in the set means its matching pair just showed up, so it gets removed since that pair is now fully accounted for
 * once the whole array has been walked, every value that appeared twice has been added then removed, leaving the set with nothing but the one value that only ever appeared once
 * that's exactly the single number the problem asks for, so whatever is left in the set gets returned
 */

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
