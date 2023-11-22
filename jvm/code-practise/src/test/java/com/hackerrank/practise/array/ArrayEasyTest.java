package com.hackerrank.practise.array;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class ArrayEasyTest {

    @Test
    void missingNumbers() throws IOException {
        // read data from the file

//        203 204 205 206 207 208 203 204 205 206
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
//        203 204 204 205 206 207 205 208 203 206 205 206 204
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);
        List<Integer> result = ArrayEasy.missingNumbers(arr, brr);
        System.out.println(result);

//        11 4 11 7 13 4 12 11 10 14
        arr = Arrays.asList(11, 4, 11, 7, 13, 4, 12, 11, 10, 14);
//        11 4 11 7 3 7 10 13 4 8 12 11 10 14 12
        brr = Arrays.asList(11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12);
        result = ArrayEasy.missingNumbers(arr, brr);
        System.out.println(result);
    }
}