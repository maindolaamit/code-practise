package com.hackerrank.practise.utils;

import com.hackerrank.practise.basic.Mathematics;
import com.hackerrank.practise.basic.StarPatterns;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UtilityTest {

    @Test
    void getLcm_of_two_numbers() {
        assertEquals(6, Mathematics.getLcm(3, 2));
        assertEquals(10, Mathematics.getLcm(5, 10));
        assertEquals(10, Mathematics.getLcm(5, 2));
        assertEquals(35, Mathematics.getLcm(5, 7));
    }

    @Test
    void get_Hcf_of_two_numbers() {
        assertEquals(1, Mathematics.getHcf(4, 5));
        assertEquals(2, Mathematics.getHcf(2, 4));
        assertEquals(4, Mathematics.getHcf(4, 8));
        assertEquals(1, Mathematics.getHcf(5, 7));
    }

    @Test
    void get_LCM_of_List() {
        assertEquals(12, Utility.getLcm(Arrays.asList(2, 4, 6)));
        assertEquals(30, Utility.getLcm(Arrays.asList(2, 5, 6)));
    }

    @Test
    void get_HCF_of_List() {
        assertEquals(2, Utility.getHcf(Arrays.asList(2, 4, 6)));
        assertEquals(1, Utility.getHcf(Arrays.asList(2, 5, 6)));
    }

}