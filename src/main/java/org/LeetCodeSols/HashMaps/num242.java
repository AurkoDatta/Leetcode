package org.LeetCodeSols.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class num242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        /***
         * Loop through each character in the two strings.
         * For the characters in 1 string, increment the value of the character in the map by 1
         * For the other string, decrement the same value by 1.
         * Returns true if all the values in the map are at 0.
         * If there is an uneven number of characters in either string, one of the values in the map will not be 0.
         */



        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            charCount.put(c1, charCount.getOrDefault(c1, 0) + 1);
            charCount.put(c2, charCount.getOrDefault(c2, 0) - 1);
        }

        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1));
    }
}
