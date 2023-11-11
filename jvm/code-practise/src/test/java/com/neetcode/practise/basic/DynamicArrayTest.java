package com.neetcode.practise.basic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void test_process_method_case_1() {
        String args[] = new String[]{"Array", "1", "getSize", "getCapacity"};
        Integer[] output = new Integer[]{null, 0, 1};

        compareProcessResults(args, output);
    }

    @Test
    void test_process_method_case_2() {
        String args[] = new String[]{"Array", "5", "getSize", "getCapacity"};
        Integer[] output = new Integer[]{null, 0, 5};

        compareProcessResults(args, output);
    }

    @Test
    void test_process_method_case_3() {
        String args[] = new String[]{"Array", "3", "pushback", "1", "pushback", "2", "pushback", "3", "get", "0", "get", "1", "get", "2"};
        Integer[] output = new Integer[]{null, null, null, null, 1, 2, 3};

        compareProcessResults(args, output);
    }

    @Test
    void test_process_method_case4() {
        String args[] = new String[]{"Array", "4", "pushback", "1", "set", "0", "0", "pushback", "2", "get", "0", "get", "1", "getCapacity", "popback"};
        Integer[] output = new Integer[]{null, null, null, null, 0, null, 4, 2};

        compareProcessResults(args, output);
    }

    @Test
    void test_process_method_case_8() {
        String args[] = new String[]{"Array", "5", "pushback", "2", "pushback", "4", "set", "0", "0", "get", "0", "get", "1", "getSize", "getCapacity"};
        Integer[] output = new Integer[]{null, null, null, null, 0, 4, 2, 5};

        compareProcessResults(args, output);
    }

    @Test
    void test_process_method_case_10() {
        String args[] = new String[]{"Array", "1", "getSize", "getCapacity", "pushback", "1", "getSize", "getCapacity", "pushback", "2", "getSize", "getCapacity", "get", "1", "set", "1", "3", "get", "1", "popback", "getSize", "getCapacity"};
        Integer[] output = new Integer[]{null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2};

        compareProcessResults(args, output);
    }

    private static void compareProcessResults(String[] args, Integer[] output) {
        DynamicArray arr = new DynamicArray(1);
        List<Integer> results = DynamicArray.process(args, arr);
        assertEquals(output.length, results.size());

        // compare random element
        int randomIndex = (int) (Math.random() * output.length);
        assertEquals(output[randomIndex], results.get(randomIndex));

        // compare random element
        randomIndex = (int) (Math.random() * output.length);
        assertEquals(output[randomIndex], results.get(randomIndex));
    }
}