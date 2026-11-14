package org.LeetCodeSols.Arrays;

import java.util.ArrayList;
import java.util.List;

/***
 * every value in nums is between 1 and n, so each value can point at exactly one index in the array by subtracting 1, giving every number a slot it's associated with
 * walking through nums, index turns num's value into the slot it points at, and flipping nums[index] negative is how that slot gets marked as having been claimed by some number in the array
 * checking nums[index] > 0 before flipping keeps a slot already marked from getting flipped back positive by a later duplicate pointing at the same spot
 * once every number has been walked through this way, any slot still holding a positive value is one that no number in the array ever pointed at, meaning its index + 1 never showed up
 * a second pass collects i + 1 for every index still left positive, since those are exactly the numbers between 1 and n that disappeared from the array
 */

public class num448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
