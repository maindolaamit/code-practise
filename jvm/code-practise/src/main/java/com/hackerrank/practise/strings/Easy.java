package com.hackerrank.practise.strings;

import java.util.HashSet;
import java.util.Set;

public class Easy {
    /**
     * https://www.hackerrank.com/challenges/two-strings/problem
     * @param s1
     * @param s2
     * @return
     */
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        if (s1.length() == 1 && s2.length() == 1) return s1.equals(s2) ? "YES" : "NO";
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        // save the set
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }
        // check
        for (int i = 0; i < s2.length(); i++) {
            if (set1.contains(s2.charAt(i))) return "YES";
        }
        return "NO";

    }


}
