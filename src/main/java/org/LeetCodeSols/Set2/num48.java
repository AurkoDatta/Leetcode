package org.LeetCodeSols.Set2;

import java.util.*;

/***
 * Loop through each string in the input array
 * Turn the current iteration into a char array
 * sort this array
 * turn that back into a string
 * check so that the map does not already contain this. If contained, get the string from the HashMap and add current iteration
 */

public class num48 {
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }
}
