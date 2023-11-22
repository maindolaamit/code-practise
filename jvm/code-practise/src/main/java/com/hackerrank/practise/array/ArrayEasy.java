package com.hackerrank.practise.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayEasy {

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

    /**
     *https://www.hackerrank.com/challenges/missing-numbers/problem
     * @param arr
     * @param brr
     * @return
     */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        // Write your code here
        List<Integer> missing = new ArrayList<>();
        if (arr.size() == brr.size()) return missing;

        Map<Integer, Integer> mapM = new HashMap<>();
        //
        for (Integer i : brr) {
            mapM.put(i, mapM.getOrDefault(i, 0) + 1);
        }
        // check the number and frequency
        for (Integer i : arr) {
            int freq = mapM.get(i);
            //reduce one value
            freq--;
            // remove if 0 else decrese by 1
            if (freq == 0) mapM.remove(i);
            else mapM.put(i, freq);
        }

        return mapM.keySet().stream().sorted().collect(Collectors.toList());
    }

}
