package org.LeetCodeSols.Set2;

import java.util.HashMap;
import java.util.Map;

public class num771 {
    public static int numJewelsInStones(String jewels, String stones) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

        /***
         * Put all jewels in a map first, initialize each value to 0
         * Loop through the characters in stones, if the character is present in our jewel map, we increment the corresponding value in the map by 1
         * If not present we just ignore and move on
         * At the end, loop through every value in the jewel map and them together to get the total number of jewels
         */

        for (char c : jewels.toCharArray()) {
            map.put(c, 0);
        }

        for (char c : stones.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i : map.values()) {
            res += i;
        }

        return res;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));


    }
}
