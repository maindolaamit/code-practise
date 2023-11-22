package com.hackerrank.practise.strings;

import com.utils.Utility;
import kotlin.Pair;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SLLMediumTest {

    @Test
    void test_characterReplacement() {
        assertEquals(4, Medium.characterReplacement("AABABBA", 1));
    }

    @Test
    void test_lenghtShortestSubstring() {
        assertEquals(4, Medium.lengthOfLongestSubstring("dabbcabcd"));
        assertEquals(3, Medium.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void test_sortByFrequency() {
        assertEquals("eert", Medium.sortByFrequency(4, "tree"));
        assertEquals("aaaccc", Medium.sortByFrequency(6, "cccaaa"));
        assertEquals("bbccAa", Medium.sortByFrequency(6, "abcAbc"));
    }

    @Test
    void test_countSubStrings() {
//        assertEquals(4, Medium.countSubStrings("abcad", 2));
        assertEquals(3, Medium.countSubStrings("aacfssa", 2));
        assertEquals(1, Medium.countSubStrings("qffds", 4));
    }

    @Test
    void test_isValid() {
        assertEquals(false, Medium.isValid("()["));
        assertEquals(false, Medium.isValid("("));
        assertEquals(false, Medium.isValid("(("));
        assertEquals(false, Medium.isValid("({[]])"));
        assertEquals(true, Medium.isValid("()"));
        assertEquals(true, Medium.isValid("({[]})"));
        assertEquals(true, Medium.isValid("({})"));
    }

    @Test
    void test_isAnagram() throws IOException {
//        assertEquals(true, Medium.isAnagram("anagram", "nagaram"));
//        assertEquals(false, Medium.isAnagram("rat", "car"));
//        assertEquals(false, Medium.isAnagram("aacc", "ccaa"));
        List<Pair<Boolean, List<String>>> pairs = readInputFromAnagramFile("src/main/resources/validAnagram.txt");
        for (Pair<Boolean, List<String>> pair : pairs) {
            assertEquals(pair.getFirst(), Medium.isAnagram(pair.getSecond().get(0), pair.getSecond().get(1)));
        }
    }

    private static List<Pair<Boolean, List<String>>> readInputFromAnagramFile(String filename) throws IOException {
        FileReader inputFile = new FileReader(filename);

        // read input from file
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        String line = null;
        List<Pair<Boolean, List<String>>> result = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            // first line is the number of elements in the array
            String s = line;
            String t = bufferedReader.readLine();
            // third line is the target
            boolean target = Boolean.parseBoolean(bufferedReader.readLine());
            // call the method
            result.add(new Pair<>(target, List.of(s, t)));
        }
        bufferedReader.close();
        inputFile.close();
        return result;
    }

    @Test
    void test_groupAnagrams() {
        String[] values = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = Medium.groupAnagrams(values);
        assertEquals(3, lists.size());

        values = new String[]{"", ""};
        lists = Medium.groupAnagrams(values);
        assertEquals(1, lists.size());
    }

    @Test
    void test_isPalindrome() {
        assertEquals(true, Medium.isPalindrome("abcba"));
        assertEquals(true, Medium.isPalindrome("abba"));
        assertEquals(true, Medium.isPalindrome("a"));
        assertEquals(true, Medium.isPalindrome(""));
        assertEquals(false, Medium.isPalindrome("race a car"));
        assertEquals(true, Medium.isPalindrome("A man, a plan, a canal: Panama"));
    }
}