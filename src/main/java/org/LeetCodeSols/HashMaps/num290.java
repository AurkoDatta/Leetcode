package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class num290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> mapCW = new HashMap<>();
        Map<String, Character> mapWC = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (mapCW.containsKey(c) && !mapCW.get(c).equals(w)) {
                return false;
            }
            if (mapWC.containsKey(w) && mapWC.get(w) != c) {
                return false;
            }

            mapCW.put(c, w);
            mapWC.put(w, c);
        }

        return true;
    }
}
