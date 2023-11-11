package com.hackerrank.practise.basic.recursions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {

    @Test
    void sumFirstN() {
        assertEquals(1, Simple.sumFirstN(1));
        assertEquals(3, Simple.sumFirstN(2));
        assertEquals(6, Simple.sumFirstN(3));
        assertEquals(10, Simple.sumFirstN(4));
        assertEquals(15, Simple.sumFirstN(5));
        assertEquals(21, Simple.sumFirstN(6));
    }

    @Test
    void factorialNumbers() {
        assertEquals(1, Simple.factorialNumbers(1).size());
        assertEquals(3, Simple.factorialNumbers(7).size());
    }

    @Test
    void palindrome() {
        assertEquals(true, Simple.palindrome("a"));
        assertEquals(true, Simple.palindrome("aa"));
        assertEquals(true, Simple.palindrome("aba"));
        assertEquals(true, Simple.palindrome("abba"));
        assertEquals(true, Simple.palindrome("abcba"));
        assertEquals(false, Simple.palindrome("ab"));
        assertEquals(false, Simple.palindrome("abc"));
        assertEquals(false, Simple.palindrome("abca"));
    }
}