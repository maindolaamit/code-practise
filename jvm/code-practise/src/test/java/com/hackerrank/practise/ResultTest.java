package com.hackerrank.practise;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static com.hackerrank.practise.Result.timeConversion;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResultTest {

    @Test
    public void timeConversion_Test() {
        assertEquals("12:01:00", timeConversion("12:01:00PM"));
        assertEquals("13:01:00", timeConversion("01:01:00PM"));
        assertEquals("00:01:00", timeConversion("12:01:00AM"));
        assertEquals("11:01:00", timeConversion("11:01:00AM"));
        assertEquals("23:01:00", timeConversion("11:01:00PM"));
    }

}