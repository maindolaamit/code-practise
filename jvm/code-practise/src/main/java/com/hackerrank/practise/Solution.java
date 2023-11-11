package com.hackerrank.practise;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.hackerrank.practise.basic.Mathematics.getHcf;
import static com.hackerrank.practise.basic.Mathematics.getLcm;
import static java.util.stream.Collectors.toList;


interface BaseI {
    void method();
}

class BaseC {
    public void method() {
        System.out.println("BaseC");
    }
}

class ImplC extends BaseC implements BaseI {
    public void method() {
        System.out.println("ImplC");
    }
}


class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        long maxSum = Long.MIN_VALUE, minSum = Long.MAX_VALUE, sum = 0;
        for (Integer integer : arr) {
            sum += integer;
        }
        for (Integer integer : arr) {
            long c = sum - integer;
            minSum = minSum > c ? c : minSum;
            maxSum = maxSum < c ? c : maxSum;
        }
        System.out.printf("%d %d%n", minSum, maxSum);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer candle : candles) {
            if (map.containsKey(candle)) {
                map.put(candle, map.get(candle) + 1);
            } else {
                map.put(candle, 1);
            }
        }

        Optional<Integer> max = map.values().stream().max((a, b) -> {
            return a >= b ? 0 : -1;
        });
        System.out.println("max = " + max);
        return max.orElse(0);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        return grades.stream().map(grade -> {
            if (grade < 38) {
                return grade;
            } else {
                int nextMultipleOfFive = (grade / 5 + 1) * 5;
                int frac = nextMultipleOfFive - grade;
                if (frac < 3) {
                    return grade + frac;
                } else {
                    return grade;
                }
            }
        }).collect(toList());
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        long applesCount = apples.stream().map(d -> d + a).filter(d -> d >= s && d <= t).count();
        long orangesCount = oranges.stream().map(d -> d + b).filter(d -> d >= s && d <= t).count();
        System.out.printf("%d\n%d", applesCount, orangesCount);
    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if (v1 == v2) return "NO";
        while (x2 != x1) {
            x1 += v1;
            x2 += v2;
            if (x1 > x2) return "NO";
        }
        return "YES";
    }

    /*
        // Todo : last test case failed due to performance
    10 10
    100 99 98 97 96 95 94 93 92 91
    1 2 3 4 5 6 7 8 9 10
    */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int startRange = a.stream().reduce(a.get(0), (l, n) -> getLcm(l, n));
        int endRange = b.stream().reduce(b.get(0), (h, n) -> getHcf(h, n));

        List<Integer> factors = new ArrayList<>();
        // add by the lcm, also gives better performance
        for (int i = startRange; i <= endRange; i = i + startRange) {
            int finalI = i;
            if (b.stream().allMatch(n -> n % finalI == 0)) factors.add(i);
        }
        return factors.size();
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int maxScore = scores.get(0), minScore = scores.get(0);
        int maxScoreBreak = 0, minScoreBreak = 0;
        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            int maxOfTwo = Math.max(score, maxScore);
            if (maxScore != maxOfTwo) {
                maxScoreBreak++;
                maxScore = maxOfTwo;
                continue;
            }
            int minOfTwo = Math.min(score, minScore);
            if (minOfTwo != minScore) {
                minScoreBreak++;
                minScore = minOfTwo;
            }
        }
        return List.of(maxScoreBreak, minScoreBreak);
    }

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int contSumsLength = s.size() - m + 1;
        int possiblePieces = 0;
        // Take the continuous sum of array elements
        for (int i = 0; i < contSumsLength; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) possiblePieces++;
        }
        return possiblePieces;
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int divisibleSumPairs = 0;
        // Save the sum of each pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumPair = ar.get(i) + ar.get(j);
                if (sumPair % k == 0) divisibleSumPairs++;
            }
        }
        return divisibleSumPairs;
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int maxCount = 1, maxCountBirdId = 1;
        Map<Integer, Integer> birdSightCount = new HashMap<>();
        for (Integer birdId : arr) {
            if (birdSightCount.containsKey(birdId)) {
                int newValue = birdSightCount.get(birdId) + 1;
                birdSightCount.put(birdId, birdSightCount.get(birdId) + 1);
                if (newValue > maxCount || (newValue == maxCount && birdId < maxCountBirdId)) {
                    maxCount = newValue;
                    maxCountBirdId = birdId;
                }
            } else {
                birdSightCount.put(birdId, 1);
            }
        }
        return maxCountBirdId;
    }

    public static String dayOfProgrammer(int year) {
        // Write your code here
        int dayOfMonth = 13, month = 9;
        if (year < 1918 && year % 4 == 0) { // julian calendar
            // number of days in a year 365 or 366 minus 14
            dayOfMonth--;
        } else if (year == 1918) {
            dayOfMonth = 26;
        } else { // gregorian calendar
            // number of days in a year 365 or 366
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) dayOfMonth--;
        }
        return String.format("%d.0%d.%d", dayOfMonth, month, year);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String value = "";
            boolean isMultipleOfFive = i % 5 == 0;
            boolean isMultipleOfThree = i % 3 == 0;
            if (isMultipleOfFive && isMultipleOfThree) {
                value = "FizzBuzz";
            } else if (isMultipleOfThree && !isMultipleOfFive) {
                value = "Fizz";
            } else if (!isMultipleOfThree && isMultipleOfFive) {
                value = "Buzz";
            } else {
                value = String.valueOf(i);
            }
            System.out.println(value);
        }
    }

    public static void typeCounter(String sentence) {
        // Write your code here
        Map<String, Integer> typeCount = new HashMap<>(3);
        typeCount.put("string", 0);
        typeCount.put("integer", 0);
        typeCount.put("double", 0);
        for (String word : sentence.split(" ")) {
            String type = "string";
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                type = "integer";
            } else {
                pattern = Pattern.compile("[0-9]+[.]{1}[0-9]+");
                matcher = pattern.matcher(word);
                if (matcher.matches()) {
                    type = "double";
                } else {
                    type = "string";
                }
            }

            Integer count = typeCount.get(type);
            typeCount.put(type, count + 1);
        }
        typeCount.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static String timeConversion(String s) {
        // Write your code here
        String[] time = s.split(":");
        String hr = time[0], min = time[1], sec = time[2].substring(0, 2), newHr = "";
        boolean evening = "pm".equalsIgnoreCase(time[time.length - 1].substring(2));
        if (evening) {
            if ("12".equalsIgnoreCase(hr)) {
                newHr = "12";
            } else {
                newHr = String.valueOf(Integer.parseInt(hr) + 12);
            }
        } else {
            newHr = hr;
            if ("12".equalsIgnoreCase(hr)) {
                newHr = "00";
            }
        }
        return String.format("%s:%s:%s", newHr, min, sec);
    }

    public static String findDay(int month, int day, int year) {
        return LocalDate.of(year, month, day).getDayOfWeek().name();
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        Integer totalBill = bill.stream().reduce(0, Integer::sum) - bill.get(k);
        if (totalBill / 2 == b) {System.out.println("Bon Appetit");} else {
            System.out.println(b - (totalBill / 2));
        }
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here
        if (y1 > y2) return 10000;
        if (m1 > m2) return (m1 - m2) * 500;
        if (d1 > d2) return (d1 - d2) * 15;
        return 0;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        AtomicInteger numberOfPairs = new AtomicInteger();
        Map<Integer, Long> collect = ar.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        collect.forEach((key, value) -> numberOfPairs.addAndGet((int) (value / 2)));
        return numberOfPairs.get();
    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long minCost = 0;
        // if cost is same for both
        if (bc == wc || z >= Math.abs(bc - wc)) minCost += (long) b * bc + (long) w * wc;
            // if cost is different for both
        else minCost += (long) w * Math.min(wc, bc + z) + (long) b * Math.min(bc, wc + z);

        return minCost;
    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int size = container.size();
        // Sum the values in each row and col
        int[] sumCols = new int[size];
        int[] sumRows = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sumRows[i] += container.get(i).get(j);
                sumCols[i] += container.get(j).get(i);
            }
        }
        // Sort the rows and cols
        Arrays.sort(sumRows);
        Arrays.sort(sumCols);
        for (int i = 0; i < size; i++) {
            if (sumRows[i] != sumCols[i]) return "Impossible";
        }
        return "Possible";
    }

    public static int pageCount(int n, int p) {
        // Write your code here
        return Math.min(p / 2, n / 2 - p / 2);
    }

    public static String encryption(String s) {
        // Write your code here
        String trimedString = s.replaceAll("\s+", "");
        int l = trimedString.length();
        double sqrt = Math.sqrt(l);
        int rows = (int) Math.floor(sqrt), cols = (int) Math.ceil(sqrt);
        if (rows * cols < l) {
            if (cols - rows == 1) {
                rows++;
            } else {cols++;}
        }
        System.out.printf("rows : %d, cols : %d\n", rows, cols);

        // encrypt the string Add spaces to rows
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < trimedString.length(); j = j + cols) {
                sb.append(trimedString.charAt(j));
            }
            sb.append(i < cols - 1 ? " " : "");
        }
        System.out.printf("encrypted string '%s'%n", sb.toString());
        return sb.toString();
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleys = 0;
        char lastStep = 'U';
        for (int i = 0; i < steps; i++) {
            if (i == 0) {
                lastStep = path.charAt(i);
                continue;
            } else if (path.charAt(i) == 'U' && lastStep == 'U') {

            }
        }
        return valleys;
    }

    public static void getSmallestAndLargest(String s, int n) {
        // Write your code here
        int substringLength = s.length() - n + 1;
        List<String> substrings = new ArrayList(substringLength);
        for (int i = 0; i < substringLength; i++) {
            substrings.add(s.substring(i, i + n));
        }
//        Collections.sort(substrings);
//        System.out.println(substrings.get(0));
//        System.out.println(substrings.get(substringLength - 1));
        String smallest = substrings.get(0), largest = substrings.get(0);
        for (int i = 0; i < substringLength; i++) {
            if (substrings.get(i).compareTo(smallest) < 0) smallest = substrings.get(i);
            if (substrings.get(i).compareTo(largest) > 0) largest = substrings.get(i);
        }
        System.out.println(smallest);
        System.out.println(largest);
    }
}

public class Solution extends BaseC implements BaseI {
    public static void main(String[] args) throws IOException {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        int n = scan.nextInt();
        // print the length
        Result.getSmallestAndLargest(s, n);

        scan.close();
    }
}
