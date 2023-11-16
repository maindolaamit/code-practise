package com.hackerrank.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solved {
    private static long getMaxConsecutiveLength(List<Integer> listNumbers) {
        // find the max consecutive values or bars
        int maxHLength = 0, maxVLength = 0, maxHStart = 0, maxVStart = 0;
        int tmpHLength = 0, tmpHStart = 0, tmpVLength = 0, tmpVstart = 0;
        for (int i = 0; i < listNumbers.size(); i++) {
            if (i == 0) {
                tmpHStart = 0;
            }
            // 1,2,3,5,6,10,11,12,13
            if (listNumbers.get(i) == listNumbers.get(i - 1) + 1) {
                tmpHLength++;
            } else { // break if not consequetive
                if (tmpHLength > maxHLength) {
                    maxHLength = tmpHLength;
                    maxHStart = tmpHStart;
                }
                tmpHLength = 0;
                tmpHStart = i;
            }
        }
        return (long) maxHLength;
    }

    /*
     * Complete the 'prison' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER_ARRAY h
     *  4. INTEGER_ARRAY v
     */
    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        // sort the arrays
        h.sort(Integer::compareTo);
        v.sort(Integer::compareTo);
        //
        long maxH = getMaxConsecutiveLength(h);
        long maxV = getMaxConsecutiveLength(v);
        // return the max value
        return (maxH + 1) * (maxV + 1);
    }

    public static long getMinimumCost(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> distinctCount = new HashMap<>();
        for (Integer integer : arr) {
            if (distinctCount.containsKey(integer)) {
                distinctCount.put(integer, distinctCount.get(integer) + 1);
            } else {
                distinctCount.put(integer, 1);
            }
        }
        return 0;
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        // find min and max
        if (arr.isEmpty()) return;
        long min = arr.get(0), max = arr.get(0), sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int value = arr.get(i);
            if (min > value) min = value;
            if (max < value) max = value;
            sum += value;
        }
        System.out.printf("%d %d%n", (sum - max), (sum - min));
    }

    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        if (s.contains("AM")) {
            hour = hour == 12 ? 0 : hour;
        } else {
            hour = hour == 12 ? 12 : hour + 12;
        }
        return String.format("%02d%s", hour, s.substring(2, 8));
    }

    public static int findMedian(List<Integer> arr) {
        if (arr.size() == 1) return arr.get(0);
        // sort the array
        arr = arr.stream().sorted().collect(Collectors.toUnmodifiableList());
        int middle = arr.size() / 2;

        return arr.get(middle);
    }

    public static int lonelyinteger(List<Integer> a) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : a) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) return i;
        }

        return -1;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftDiagonal = 0, rightDiagonal = 0, end = arr.size() - 1;
        for (int i = 0; i <= end; i++) {
            leftDiagonal += arr.get(i).get(i);
            rightDiagonal += arr.get(i).get(end - i);
        }
        return Math.abs(leftDiagonal - rightDiagonal);
    }

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here

        // get the max element
        int max = 100;

        // initialize the map
        HashMap<Integer, Integer> map = new HashMap<>(max);
        for (int i = 0; i < max; i++) map.put(i, 0);

        if (!arr.isEmpty()) {
            // count the frequency
            for (int i : arr) {
                if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            }
        }

        List<Integer> sorted = new ArrayList<>(max);
        map.forEach((k, v) -> sorted.add(v));

        return sorted;
    }
}
