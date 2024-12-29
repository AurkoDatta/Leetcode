package org.LeetCodeSols.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * First run the base cases
 * Sort the array
 * Loop through the array
 * Run a base case to skip a iteration if required
 * Use a two pointer method along with the for loop
 * Calculate the sum at the indexes of all three pointers (Third pointer is the one from the for loop)
 * Run the appropriate logic
 */

public class num15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //Base case for insufficient number of elements
        if (nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        //Base case for exactly 3 elements
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                list.add(nums[2]);
                res.add(list);
                return res;
            } else {
                return res;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0){
                    //if sum > 0, decrement the right pointer
                    k--;
                } else if (sum < 0){
                    //If sum < 0, increment the left pointer
                    j++;
                } else {
                    //If sum is 0, add all three numbers to the answer as a list and increment the left pointer
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k) j++;
                }
            }
        }


        return res;
    }
}
