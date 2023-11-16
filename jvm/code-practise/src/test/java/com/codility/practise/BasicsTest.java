package com.codility.practise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.hackerrank.practise.array.Basics.arrayRotation;
import static org.junit.jupiter.api.Assertions.*;

class BasicsTest {

    @Test
    void arrayRotation_testcase_1() {
        int[] A = {1, 2, 3, 4};
        int k = 1;
        int[] output = {4, 1, 2, 3};

        int[] rotatedArray = arrayRotation(A, k);
        assertEquals(true, (Arrays.equals(output, rotatedArray)));

        output = new int[]{2, 3, 4, 1};
        rotatedArray = arrayRotation(A, 3);
        assertEquals(true, (Arrays.equals(output, rotatedArray)));

        // rotate array by 0
        rotatedArray = arrayRotation(A, 0);
        assertEquals(true, (Arrays.equals(A, rotatedArray)));

        // rotate array by length of array
        // get random number between 0 and A.length
        int l = (int) (Math.random() * A.length);
        rotatedArray = arrayRotation(A, A.length * l);
        assertEquals(true, (Arrays.equals(A, rotatedArray)));

        // rotate empty array
        rotatedArray = arrayRotation(new int[]{}, 0);
        assertEquals(true, (Arrays.equals(new int[]{}, rotatedArray)));
    }
}