package org.LeetCodeSols.SetTwo;

import java.util.HashMap;
import java.util.Map;

public class num771 {
    public static int numJewelsInStones(String jewels, String stones) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();

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
