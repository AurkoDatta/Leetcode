package org.LeetCodeSols.Set2;

import java.util.HashMap;
import java.util.Map;

public class num169 {
    public static int majorityElement(int[] nums) {
        int res = 0;
        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int id : map.keySet()) {
            int temp = map.get(id);
            if (temp > floor(length)){
                res = id;
                return res;
            }

        }

        return res;
    }

    public static int floor(int length){
        int res = Math.floorDiv(length, 2);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
}
