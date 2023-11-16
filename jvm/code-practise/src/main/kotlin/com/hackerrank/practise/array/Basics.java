package com.hackerrank.practise.array;

import java.util.HashMap;
import java.util.Map;

public class Basics {

    public static int[] arrayRotation(int[] A, int K) {
        // k is <= A.length
        //  -1000 <= a[i] <= 1000
        if (A.length == 0 || K == A.length || K % A.length == 0) return A;

        int rotateBy = K % A.length;
        int[] newArray = new int[A.length];

        // Loop and assign values
        for (int i = 0; i < A.length; i++) {
            int newIndex = i + rotateBy;
            if (newIndex >= A.length)
                newIndex = newIndex % A.length;
            newArray[newIndex] = A[i];
        }
        return newArray;
    }


    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                return num;
            }
        }
        return -1;
    }
}
