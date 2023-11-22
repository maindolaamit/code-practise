package com.hackerrank.practise.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StackEasyTest {

    @Test
    void equalStacks() {
//        3 2 1 1 1
//        4 3 2
//        1 1 4 1
        List<Integer> h1 = List.of(3, 2, 1, 1, 1);
        List<Integer> h2 = List.of(4, 3, 2);
        List<Integer> h3 = List.of(1, 1, 4, 1);
        assertEquals(5, StackEasy.equalStacks(h1, h2, h3));
    }
}