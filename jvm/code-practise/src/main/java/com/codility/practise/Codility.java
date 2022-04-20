package com.codility.practise;

import java.util.HashMap;
import java.util.HashSet;

public class Codility {

    public static String intToBinary(int n) {
        StringBuilder number = new StringBuilder();
        while (n > 0) {
            number = new StringBuilder((n % 2 == 0 ? "0" : "1")).append(number);
            n = n / 2;
        }
        return number.toString();
    }

    public static int maxBinaryGap(String binary) {
        // If no binary gap present
        if (!binary.contains("0")) return 0;
        if (!binary.substring(1).contains("1")) return 0;

        char[] array = binary.toCharArray();
        int length, j, maxLength = 0, arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] == '0') {
                // Loop till you encounter 1
                j = i;
                while (array[j] != '1') {
                    j++;
                    if (j == arrayLength) break;
                }
                // Return max length
                if (j == arrayLength && array[j - 1] != '1') {
                    return maxLength;
                } else {
                    // Compute length
                    length = j - i;
                    i = j;
                    if (length > maxLength) { maxLength = length;}
                }
            }
        }
        return maxLength;
    }

    public static int[] rotateArray(int[] A, int K) {
        int length = A.length;
        // Return null if empty array
        if (length == 0) return new int[0];

        int[] newRange = new int[length];
        // Change K to remainder, handel if rotation greater than length
        int rotation = K > length ? K % length : K;
        int pivot = length - rotation;

        for (int i = 0; i < length; i++) {
            newRange[i] = i < rotation ? length - rotation + i : pivot + i - length;
        }

        int[] rotatedArray = new int[length];
        for (int i = 0; i < length; i++) {
            rotatedArray[i] = A[newRange[i]];
        }
        // Return the Rotated array
        return rotatedArray;
    }

    public static int oddOccurrencesInArra(int[] A) {
        int len = A.length;
        if (len == 1) return A[0];

        HashMap<Integer, Integer> arrayCount = new HashMap<>();

        for (int key : A) arrayCount.put(key, arrayCount.containsKey(key) ? arrayCount.get(key) + 1 : 1);

        for (Integer key : arrayCount.keySet()) {
            if (arrayCount.get(key) % 2 == 1) return key;
        }
        return 0;
    }

    public static int frogJump(int X, int Y, int D) {
        int i = (Y - X) / D;
        while (X + D * i < Y) {
            i++;
        }
        return i;
    }

    public static int missingElem(int[] A) {
        int len = A.length + 1;
        if (len == 1) return 1;

        int sum = len % 2 == 0 ? (len / 2) * (len + 1) : ((len + 1) / 2) * len;

        int actSum = 0;
        for (int i = 0; i < A.length; i++) {
            actSum += A[i];
        }
        return sum - actSum;
    }

    public static int tapeEquilibrium(int[] A) {
        int len = A.length;

        if (len == 2) return Math.abs(A[0] - A[1]);
        int minDiff = Integer.MAX_VALUE;
        int arraySum = 0;
        for (int i = 0; i < len; i++) {
            arraySum += A[i];
        }
        int sum1 = A[0];
        for (int p = 1; p < len; p++) {
            int diff = 0;
            if (p > 1) {
                sum1 += A[p - 1];
            }
            diff = Math.abs(2 * sum1 - arraySum);
            // Check and take min number
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    /*
    Refer the problem statement below
    https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
    */
    public static int frog_river_one(int X, int[] A) {
        int len = A.length;
        if (X == 1) return 0;

        HashSet<Integer> count = new HashSet<Integer>();
        count.add(A[0]); // Add first element to the set
        for (int i = 1; i < len; i++) {
            count.add(A[i]);
            if (count.size() == X) {
                return i;
            }
        }

        return -1;
    }

    /*
    https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
     */
    public static int[] maxCounters(int N, int[] A) {
        int len = A.length, minvValue = 0, maxCounter = 0;
        int[] counter = new int[N];
        if (len == 1) {
            counter[A[0] - 1] = A[0] <= N ? 1 : 0;
            return counter;
        }
        // Loop for each element in Array
        for (int i = 0; i < len; i++) {
            int value = A[i] - 1;
            if (A[i] <= N) {
                counter[value] = counter[value] <= minvValue ? minvValue + 1 : counter[value] + 1;
                // Increase MaxCounter
                if (maxCounter < counter[value]) maxCounter = counter[value];
            } else {
                minvValue = maxCounter;
            }
//            System.out.println("minvValue = " + minvValue);
//            System.out.println(Arrays.toString(counter));
        }

        // Add min value te each element
        for (int j = 0; j < N; j++) {
            if (counter[j] < minvValue) counter[j] = counter[j] = minvValue;
        }

        return counter;
    }

    /*
    https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/*/
    public static int permCheck(int[] A) {
        int len = A.length;
        if (len == 1 && A[0] != 1) return 0;
        if (len == 1) return 1;

        HashSet<Integer> set = new HashSet<>();
        int maxElement = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] > len) return 0;
            set.add(A[i]);
            if (set.size() < i + 1) return 0;
            if (maxElement < A[i]) maxElement = A[i];
        }
//        System.out.println(maxElement + " - " + len);
        return maxElement == len ? 1 : 0;
    }

    /*
    Refer the problem here
    https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
    */
    public static int missingInteger(int[] A) {
        int len = A.length;
        if (len == 1) return 1 == A[0] ? 2 : 1;

        int minElement = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int value : A) {
            if (value > 0) {
                if (minElement > value) minElement = value;
                set.add(value);
            }
        }
        if (minElement != 1) return 1;

        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    public static int countDiv(int A, int B, int K) {
        return B / K - A / K + (A % K == 0 ? 1 : 0);
    }

    public static int[] genomicRangeQuery(String S, int[] P, int[] Q) {
        HashMap<String, Integer> impactFactors = new HashMap<>();
        impactFactors.put("A", 1);
        impactFactors.put("C", 2);
        impactFactors.put("G", 3);
        impactFactors.put("T", 4);
        int len = S.length();
        if (len == 1) return new int[]{impactFactors.get(S)};

        int m = P.length;
        int[] minWeights = new int[m];
        int[][] prefixSum = new int[4][len + 1];

        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            prefixSum[0][i + 1] = prefixSum[0][i] + (c == 'A' ? 1 : 0);
            prefixSum[1][i + 1] = prefixSum[1][i] + (c == 'C' ? 1 : 0);
            prefixSum[2][i + 1] = prefixSum[2][i] + (c == 'G' ? 1 : 0);
            prefixSum[3][i + 1] = prefixSum[3][i] + (c == 'T' ? 1 : 0);
        }

//        int b = 0;
//        for (String s : impactFactors.keySet()) {
//            System.out.println(String.format("%s : %s", s, Arrays.toString(prefixSum[b])));
//            b++;
//        }

        // Loop for the length
        for (int i = 0; i < m; i++) {
            int p = P[i], q = Q[i] + 1;
            if (prefixSum[0][q] - prefixSum[0][p] > 0) minWeights[i] = impactFactors.get("A");
            else if (prefixSum[1][q] - prefixSum[1][p] > 0) minWeights[i] = impactFactors.get("C");
            else if (prefixSum[2][q] - prefixSum[2][p] > 0) minWeights[i] = impactFactors.get("G");
            else if (prefixSum[3][q] - prefixSum[3][p] > 0) minWeights[i] = impactFactors.get("T");
        }
        return minWeights;
    }

    public static int minAverage(int[] A) {
        int len = A.length;
        if (len == 2) return 0;

        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = A[i] + prefixSum[i];
        }
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(prefixSum));
        int startIndex = 0;
        double minAvg = Integer.MAX_VALUE;
        // Take max count of 2 as minimum average will occur with 2 or 3 values only
        for (int count = 2; count <= 4; count++) {
            for (int j = 0; j < len + 1 - count; j++) {
                double avg = (prefixSum[j + count] - prefixSum[j]) * 1.0f / count;
                if (minAvg > avg) {
                    minAvg = avg;
                    startIndex = j;
                }
            }
        }
        return startIndex;
    }

}
