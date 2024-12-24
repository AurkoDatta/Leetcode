package org.LeetCodeSols.Set1;

/***
 * Use i and j variables
 * Run a while loop with the conditions that i and j are both shorter than the length of the input strings
 * if the characters at i and j indexes of both strings are equal, append that character to the StringBuilder
 * increment both i and j
 * If the characters arent equal only increment j
 * At the end compare the StringBuilder to the orignal string s
 */

public class num392 {
    public static boolean isSubsequence(String s, String t) {

        StringBuilder temp = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)){
                temp.append(s.charAt(i));
                i++;
                j++;
            } else if (s.charAt(i) != t.charAt(j)) {
                j++;
            }

        }

        return temp.toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
