package com.hackerrank.test;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class Result {

    public static int findMedian(List<Integer> arr) {
        if (arr.size() == 1) return arr.get(0);
        // sort the array
        arr = arr.stream().sorted().collect(Collectors.toUnmodifiableList());
        int middle = arr.size() / 2;

        return arr.get(middle);
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

    public static void main2(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                    try {
                        return getParsedLine(bufferedReader);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Solved.getMinimumCost(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


    public static void main(String[] args) throws IOException {
        FileReader inputFile = new FileReader("src/main/resources/input.txt");
        FileWriter outputFile = new FileWriter("output.txt");

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // read input from file
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(outputFile);

        // Input reading logic, you can read multiple lines here
        //        String line;
        //        while ((line = bufferedReader.readLine()) != null) {
        //            List<Integer> arr = Stream.of(line.replaceAll("\\s+$", "").split(" "))
        //                    .map(Integer::parseInt)
        //                    .collect(toList());
        //
        //            Result.miniMaxSum(arr);
        //            String result = Solved.timeConversion(line);
        //    }
//        int n = Integer.parseInt(getParsedLine(bufferedReader));
        List<Integer> arr = Stream.of(getParsedLine(bufferedReader).split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        int result = Result.findMedian(arr);
        bufferedWriter.write(String.valueOf(result));

        bufferedReader.close();
        bufferedWriter.close();
    }

    @NotNull
    private static String getParsedLine(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
    }

}
