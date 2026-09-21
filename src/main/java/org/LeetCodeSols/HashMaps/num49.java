package org.LeetCodeSols.HashMaps;

import java.util.*;

/***
 * two strings are anagrams of each other only if they contain the exact same letters, just rearranged
 * sorting the characters of a string turns it into a canonical form that's identical for every one of its anagrams
 * use that sorted string as a key in a map, grouping every original string under the key it sorts down to
 * computeIfAbsent creates a fresh list for a key the first time it shows up, then every match after that just gets appended
 * map.values() at the end holds each group of anagrams bundled together
 */

public class num49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
