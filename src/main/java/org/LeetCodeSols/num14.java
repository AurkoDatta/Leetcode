package org.LeetCodeSols;

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
