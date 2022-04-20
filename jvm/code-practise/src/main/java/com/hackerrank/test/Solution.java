package com.hackerrank.test;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

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

    }
}


public class Solution {
    static long getNumber(int size, int[] b) {
        int[] a = new int[size];
        // reverse the list
        for (int i = 0; i < size; i++) {
            a[i] = b[size - 1 - i];
        }
        long decimalNumber = 0;

        for (int i = 0; i < size; i++) {
            decimalNumber += a[i] == 1 ? (long) Math.pow(2, i) : 0;
        }
        // return the max value
        return decimalNumber;

    }

    public static void main(String[] args) throws IOException {
        public static void main (String[]args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            long result = Result.getMinimumCost(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }

    }
}
