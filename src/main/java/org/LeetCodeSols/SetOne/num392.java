package org.LeetCodeSols.SetOne;

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
