package com.hackerrank.practise.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Medium {
    /**
     * @param arr    array of integers
     * @param target Target sum
     * @return array of indices of the two numbers such that they add up to a specific target,
     * index1 must be less than index2 and both index1 and index2 are not zero-based.
     */
    public static String twoSumTwo(int[] arr, int target) {
        // Write your code here.
        // array is sorted in ascending order
        int start = 0, end = arr.length - 1;
        while (true) {
            if (arr[start] + arr[end] == target) return (start + 1) + " " + (end + 1);
            if (arr[start] + arr[end] > target) end--;
            if (arr[start] + arr[end] < target) start++;
        }
    }

    /**
     * https://www.codingninjas.com/studio/problems/reading_6845742?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
     *
     * @param n      number of books
     * @param book   array of pages in each book
     * @param target target number of pages
     * @return YES if it is possible to read exactly target pages, otherwise NO
     */
    public static String read(int n, int[] book, int target) {
        // Write your code here.
        HashSet<Integer> hashSet = new HashSet<>();
        for (int j : book) {
            int remaining = target - j;
            if (hashSet.contains(remaining)) return "YES";
            else hashSet.add(j);
        }
        return "NO";
    }


    /**
     * https://www.codingninjas.com/studio/problems/majority-element_6783241?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
     * <p>
     * Return the majority element from the given array.
     * A majority element in an array A[] of size n is an element that appears more than n/2 times in the array.
     *
     * @param v array of integers
     * @return majority element
     */
    public static int majorityElement(int[] v) {
        // Write your code here
        if (v.length == 1) return v[0];

        HashMap map = new HashMap<Integer, Integer>();
        for (int i : v) {
            if (!map.containsKey(i)) map.put(i, 1);
            else {
                int count = (int) map.get(i);
                if (count + 1 > v.length / 2) return i;
                else map.put(i, count + 1);
            }
        }
        return -1;
    }


    /**
     * https://www.codingninjas.com/studio/problems/spiral-matrix_6922069?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
     * You are given a matrix of size m*n. Traverse the matrix in spiral form.
     *
     * @param MATRIX matrix of integers
     * @return array of integers
     */
    public static int[] spiralMatrix(int[][] MATRIX) {
        // Write your code here.
        int totalCells = MATRIX.length * MATRIX[0].length;
        int startRow = 0, endRow = MATRIX.length - 1;
        int startCol = 0, endCol = MATRIX[0].length - 1;
        int[] result = new int[totalCells];
        // loop
        for (int i = 0; i < totalCells - 1 || startCol == endCol; ) {

            // move right
            if (i == totalCells) break;
            for (int j = startCol; j <= endCol; j++) {
                result[i++] = MATRIX[startRow][j];
            }
            startRow++;

            // move down
            if (i == totalCells) break;
            for (int j = startRow; j <= endRow; j++) {
                result[i++] = MATRIX[j][endCol];
            }
            endCol--;

            // move left
            if (i == totalCells) break;
            for (int j = endCol; j >= startCol; j--) {
                result[i++] = MATRIX[endRow][j];
            }
            endRow--;

            // move up
            if (i == totalCells) break;
            for (int j = endRow; j >= startRow; j--) {
                result[i++] = MATRIX[j][startCol];
            }
            startCol++;
        }
        return result;
    }


    /**
     * https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_6194560?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
     *
     * @param prices array of prices
     * @return maximum profit
     */
    public static int bestTimeToBuyAndSellStock(int[] prices) {
        // Write your code here.
        int minIndx = 0, maxIndx = prices.length - 1;
        int i = 0, maxProfit = Integer.MIN_VALUE;
        while (i < prices.length / 2 || i < maxIndx) {
            if (prices[i] < prices[minIndx] && i <= maxIndx) {
                minIndx = i;
                maxProfit = Math.max(maxProfit, prices[maxIndx] - prices[minIndx]);
            }

            int revIndex = prices.length - 1 - i;
            if (prices[revIndex] > prices[maxIndx] && revIndex < maxIndx && revIndex >= minIndx) {
                maxIndx = revIndex;
                maxProfit = Math.max(maxProfit, prices[maxIndx] - prices[minIndx]);
            }
            i++;
        }
        return maxProfit;
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        if (q.size() == 1) {
            System.out.println(1);
        } else {
            int maxSwap = 0;
            // as max swap can be two check if a number is out of poistion by 2
            for (int i = 0; i < q.size(); i++) {
                int num = q.get(i);
                int diff = Math.abs(num - i);
                if (diff > maxSwap) {
                    maxSwap = Math.max(maxSwap, diff);
                    if (maxSwap > 2) {
                        System.out.println("Too Chaotic");
                        return;
                    }
                }
            }
            System.out.println(maxSwap);
        }
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int num = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n * m; i++) {
            int colIndx = i % n, rowIndx = i / n;
            String key = colIndx + "" + rowIndx;
            int value = grid[rowIndx][colIndx];
            if (value < 2) continue;

            // increase the time
            num++;
            set.add(key);
            for (int j = 0; j < 4; j++) {
                int col = colIndx, row = rowIndx;
                if (j == 0) col++;
                if (j == 1) col--;
                if (j == 2) row++;
                if (j == 3) row--;
                // if row or column is in range and orange is fresh
                key = col + "" + row;
                if (set.contains(key)) continue;
                if (row < m && row >= 0 && col < n && col >= 0 && grid[row][col] == 1) {
                    // rott the orange in array
                    grid[row][col] = 2;
                    set.add(key);
                }
            }
        }
        return set.contains(1) ? -1 : num;
    }
}
