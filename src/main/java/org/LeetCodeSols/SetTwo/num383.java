package org.LeetCodeSols.SetTwo;

import java.util.HashMap;
import java.util.Map;

public class num383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();

        if (ransomNote.length() == 1 && magazine.length() == 1) {
            return ransomNote.equals(magazine);
        }

        Boolean result = false;

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
