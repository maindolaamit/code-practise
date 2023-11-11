package com.hackerrank.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void miniMaxSum() {
    }

    @Test
    void timeConversion() {

        String s = Solved.timeConversion("07:05:45PM");
        assertEquals("19:05:45", s);

        s = Solved.timeConversion("12:00:00AM");
        assertEquals("00:00:00", s);
    }

    @Test
    void findMedian() {
        int median = Result.findMedian(List.of(0, 1, 2, 4, 6, 5, 3));
        assertEquals(3, median);
    }
}