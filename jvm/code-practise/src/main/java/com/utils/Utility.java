package com.utils;

import com.hackerrank.practise.basic.Mathematics;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Utility {

    public static int getLcm(List<Integer> numbers) {
        return numbers.stream().reduce(numbers.get(0), Mathematics::getLcm);
    }

    public static int getHcf(List<Integer> numbers) {
        return numbers.stream().reduce(numbers.get(0), Mathematics::getHcf);
    }

    @NotNull
    private static String getParsedLineFromReader(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
    }

    public static int parseSingleInteger(BufferedReader bufferedReader) throws IOException {
        return parseSingleIntFromLine(bufferedReader.readLine().trim());
    }

    private static int parseSingleIntFromLine(String s) {
        return Integer.parseInt(s);
    }

    public static String parseLineForIntegers(String line) {
        return line.replaceAll("\\s+$", "");
    }

    public static void writeToOutputFile(String result) throws IOException {
        FileWriter outputFile = new FileWriter("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(outputFile);
        bufferedWriter.write(result);
        bufferedWriter.close();
    }


    public static List<Pair<Integer, List<Integer>>> readInputFromFileForIntArray(String filename) throws IOException {
        FileReader inputFile = new FileReader(filename);

        // read input from file
        BufferedReader bufferedReader = new BufferedReader(inputFile);
        String line = null;
        List<Pair<Integer, List<Integer>>> result = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            // first line is the number of elements in the array
            int n = parseSingleIntFromLine(line);
            // second line is the array of elements
            List<Integer> arr = Stream.of(getParsedLineFromReader(bufferedReader).split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            // third line is the target
            int target = parseSingleInteger(bufferedReader);
            // call the method
            result.add(new Pair<>(target, arr));
        }
        bufferedReader.close();
        return result;
    }
}
