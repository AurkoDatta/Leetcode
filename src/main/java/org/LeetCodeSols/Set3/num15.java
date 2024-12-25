package org.LeetCodeSols.Set3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

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
                    k--;
                } else if (sum < 0){
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k) j++;
                }
            }
        }


        return res;
    }
}
