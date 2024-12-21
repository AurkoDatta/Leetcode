package org.LeetCodeSols.SetTwo;

import java.util.HashMap;
import java.util.Map;

public class num217 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        for (int i : map.values()){
            if (i > 1){
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {

    }
}
