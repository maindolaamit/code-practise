package com.codility.challenges;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        return highestPower(24);
    }

    /**
     * Given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.
     * The function should return −1 if array A does not have a dominator.
     *
     * @param A array of integers
     * @return index of any element of array A in which the dominator of A occurs
     */
    public static int getDominator(int[] A) {
        if (A.length == 0) return -1;
        if (A.length == 1) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int element = A[i];
            if (map.containsKey(element)) {
                Integer count = map.get(element);
                map.put(element, count + 1);
                // check if the element is the leader
                if (map.get(element) > A.length / 2) return i;
            } else {
                map.put(element, 1);
            }
        }
        return -1;
    }


    public static int highestPower(int N) {
        if (N == 1) return 0;
        int half = (int) Math.ceil(N / 2.0);
        int value = 2, pow = 1;
        while (value < half) {
            if (N % value == 0 && half / (value * 2) < 0) break;
            value *= 2;
            pow++;
        }
        return pow;
    }
}
