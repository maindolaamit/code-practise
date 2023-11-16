package com.hackerrank.practise.strings;

import com.hackerrank.practise.list.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class Medium {
    /**
     * https://www.codingninjas.com/studio/problems/sorting-characters-by-frequency_1263699?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
     *
     * @param n number of characters in string
     * @param s string of characters
     * @return sorted string
     */
    public static String sortByFrequency(int n, String s) {
        // Write Your Code here
        if (s.length() == 1) return s;
        //
        HashMap<Character, Integer> map = new HashMap<>();
        // put values in the map
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sort the map
        List<Map.Entry<Character, Integer>> toSort = new ArrayList<>(map.entrySet());
        toSort.sort((e1, e2) -> {
            int result = e2.getValue().compareTo(e1.getValue());
            if (result == 0) return e2.getKey().compareTo(e1.getKey());
            else return result;
        });

        // get the count
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : toSort) {
            char c = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) sb.append(c);
        }
        return sb.toString();
    }

    public static int countSubStrings(String str, int k) {
        // Write your code here.
        if (str.length() < k) return 0;
        if (k == 1) return str.length();

        HashSet<String> set = new HashSet<>();
        int end;
        // loop for i = 0 to str.length -k
        for (int i = 0; i < str.length() - k + 1; i++) {
            end = i + k;
            String p = str.substring(i, end);
            HashSet<String> uniqueChars = new HashSet<>(Arrays.asList(p.split("")));
            // check unique char count
            while (uniqueChars.size() < k) {
                uniqueChars.add(str.charAt(++end) + "");
                if (end == str.length()) break;
            }
            if (uniqueChars.size() == k)
                set.add(str.substring(i, end));
        }
        return set.size();
    }

    public static boolean isValid(String s) {
        if (s.length() == 1) return false;
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        // loop
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                // check matching the last element
                if (stack.empty()) return false;
                else {
                    char c = stack.pop();
                    if (c == '(' && s.charAt(i) != ')') return false;
                    else if (c == '{' && s.charAt(i) != '}') return false;
                    else if (c == '[' && s.charAt(i) != ']') return false;
                }
            }
        }

        return stack.empty();
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // s and t are lowercase english letters max 26
        int[] set1 = new int[26];
        int[] set2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            set1[s.charAt(i) - 'a']++;
            set2[t.charAt(i) - 'a']++;
        }

        // check if counts are same
        for (int i = 0; i < 26; i++) {
            if (set1[i] != set2[i]) return false;
        }
        return true;
    }

    private static String getCountFrequency(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) return List.of(List.of(strs));
        // trick is to get the frequency count of each string and use that as map
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String str : strs) {
            String frequency = null;
            // get the frequency count
            if (str.isEmpty()) frequency = "";
            else frequency = getCountFrequency(str);
            HashSet<String> set = map.getOrDefault(frequency, new HashSet<>());
            set.add(str);
            map.put(frequency, set);
        }

        return map.values().stream().map(ArrayList::new).collect(Collectors.toList());
    }


    public static boolean isPalindrome(String s) {
        // replace the non alpha-numeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s.isEmpty()) return true;
        // ignore any non-alphanumeric characters
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) start++;
            else if (!Character.isLetterOrDigit(s.charAt(end))) end--;
            else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int start = 0, max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        // add element to set and check if it is already present
        for (int i = 0; i < s.length(); i++) {
            // remove last element from set to add new element
            // remove all elements if we get repeating characters
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(start++));
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }


    public static int characterReplacement(String s, int k) {
        if (s.length() == 1) return 1;
        if (k == s.length()) return s.length();
        int start = 0, maxWindowSize = Integer.MIN_VALUE, maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // check the count for eligible window
            // get the highest frequency character
            maxFreq = map.values().stream().mapToInt(v -> v).max().orElse(0);

            int windowSize = i - start + 1;
            if (windowSize - maxFreq > k) {
                // decrement the count of character at start
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                windowSize--;
                start++;
            }
            // save current window size
            maxWindowSize = Math.max(maxWindowSize, windowSize);
        }
        return maxWindowSize;
    }

//    public void reorderList(ListNode head) {
//        ListNode start = head, end = head;
//        int count = 0;
//        while (end.next != null) {
//            end = end.next;
//            count++;
//        }
//
//        for (int i = 0; i < count; i++) {
//            // swap start
//            ListNode nodeS = start.next;
//
//            // swap end
//        }
//
//    }

}
