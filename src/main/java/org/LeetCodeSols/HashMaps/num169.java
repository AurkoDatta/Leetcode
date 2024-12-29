package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

/***
 * Made a floor function that just calculates the formula given in the question, with the length of the input array
 * Put all the numbers in the input array into a HashMap.
 * If value present in the HashMap, increment its value by 1
 * Else, add it to the map and set value to 0
 * Now, loop through the keySet of the HashMap
 * temporarily get the corresponding value of the current key
 * If that value is greater than the floor function for the current arrays length
 * Return the current key
 */

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
