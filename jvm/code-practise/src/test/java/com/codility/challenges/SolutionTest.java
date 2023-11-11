package com.codility.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getDominator() {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        int dominator = Solution.getDominator(A);
        assertEquals(7, dominator);

        A = new int[]{};
        assertEquals(-1, Solution.getDominator(A));

        A = new int[]{1};
        assertEquals(0, Solution.getDominator(A));
    }

    @Test
    void get_highest_power() {
        assertEquals(0, Solution.highestPower(1));
        assertEquals(1, Solution.highestPower(2));
        assertEquals(1, Solution.highestPower(3));
        assertEquals(3, Solution.highestPower(24));
        assertEquals(2, Solution.highestPower(5));
        assertEquals(3, Solution.highestPower(15));
        assertEquals(4, Solution.highestPower(16));
        assertEquals(16, Solution.highestPower((int) Math.pow(2, 16)));
    }
}