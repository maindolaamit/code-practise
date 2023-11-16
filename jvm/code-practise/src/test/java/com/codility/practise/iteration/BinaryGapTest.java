package com.codility.practise.iteration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.codility.practise.iteration.BinaryGap.intToBinary;

class BinaryGapTest {

    @Test
    void maxBinaryGap() {
//        assertEquals(0, BinaryGap.maxBinaryGap(15));
//        assertEquals(0, BinaryGap.maxBinaryGap(2));
//        assertEquals(0, BinaryGap.maxBinaryGap(8));
//        assertEquals(0, BinaryGap.maxBinaryGap(7));
//        assertEquals(2, BinaryGap.maxBinaryGap(9));
//        assertEquals(5, BinaryGap.maxBinaryGap(1041));
//        assertEquals(1, BinaryGap.maxBinaryGap(20));
        assertEquals(3, BinaryGap.maxBinaryGap((int) (Math.pow(2, 31) - 15)));
    }

    @Test
    void intToBinary() {
        assertEquals("1001", BinaryGap.intToBinary(9));
        assertEquals(Integer.toBinaryString(8), BinaryGap.intToBinary(8));
        assertEquals("101", BinaryGap.intToBinary(5));
        assertEquals(Integer.toBinaryString(345), BinaryGap.intToBinary(345));
    }
}