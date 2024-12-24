package org.LeetCodeSols.Set1;

/***
 * First we check the base case
 * Set a string s to the first string in the input array
 * We initiate the prefix length to the length of the first word in tne input array
 * Then, we run a loop
 * While prefix length is greater than length of the temp string initiated
 * Decrease prefix length by 1
 * Set s to a substring of s from 0 to the current prefix lenfth
 */

public class num14 {
        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String s = strs[0];
            int prefLen = s.length();
            for (int i = 1; i < strs.length; i++) {
                String temp = strs[i];
                while (prefLen > temp.length() || !s.equals(temp.substring(0, prefLen))) {
                    prefLen--;

                    if (prefLen == 0) return "";

                    s = s.substring(0, prefLen);
                }
            }

            return s;
        }

        public static void main(String[] args) {
            System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        }
    }
