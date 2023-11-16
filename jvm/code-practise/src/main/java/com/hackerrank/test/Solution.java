package com.hackerrank.test;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {


}


public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader inputFile = new FileReader("src/main/resources/input.txt");
        FileWriter outputFile = new FileWriter("output.txt");

        // read input from file
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(outputFile);

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Solved.countingSort(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

//        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
