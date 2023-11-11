package com.hackerrank.test;

import java.util.HashMap;
import java.util.List;

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
}
