package org.LeetCodeSols.Set2;

import java.util.HashMap;
import java.util.Map;

public class num217 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        /***
         * loop thorugh each character in the string
         * if already present in the map, we increment its value by 1, else we add it to the map and set its value to 1
         * At the end, we loop, and if any values of the keys are more than 1, we return true as that means a duplicate
         * has occurred.
         */

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
