package org.LeetCodeSols.Set2;

import java.util.HashMap;
import java.util.Map;

public class num383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();

        if (ransomNote.length() == 1 && magazine.length() == 1) {
            return ransomNote.equals(magazine); //Base case
        }

        Boolean result = false;

        /***
         * loop through every character in magazine. If already present in magMap increment the corresponding
         * value of the character by 1. If not present, add it to the map and set its value to 1.
         * Do the same for ransomNote as well and use ransMap.
         * At the end, loop through each key in ransMap and compare its value to the same keys value in magMap.
         * If magMap doesnt contain the value, its already false.
         * If magMap contains less of that value than ransMap, also false
         * If magMap has greater or equal value of that character, set result to true and continue the loop to check for
         * the rest.
         */

        for (char c : magazine.toCharArray()) {
            if (magMap.containsKey(c)) {
                magMap.put(c, magMap.get(c) + 1);
            } else {
                magMap.put(c, 1);
            }
        }

        Map<Character, Integer> ransMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (ransMap.containsKey(c)) {
                ransMap.put(c, ransMap.get(c) + 1);
            } else {
                ransMap.put(c, 1);
            }
        }

        for (char c : ransMap.keySet()) {
            if (magMap.get(c) == null) {
                return false;
            } else if (ransMap.get(c) > magMap.get(c)) {
                return false;
            } else if (ransMap.get(c) <= magMap.get(c)){
                result = true;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        String ransomNote = "ihgg";
        String magazine = "ch";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
