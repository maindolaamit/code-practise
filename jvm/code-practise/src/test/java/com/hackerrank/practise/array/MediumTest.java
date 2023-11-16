package com.hackerrank.practise.array;

import com.hackerrank.practise.array.Medium;
import com.utils.Utility;
import kotlin.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.hackerrank.practise.array.Medium.*;
import static org.junit.jupiter.api.Assertions.*;

class MediumTest {

    @Test
    void test_read() {
        assertEquals("YES", read(4, new int[]{1, 2, 3, 4}, 4));
        assertEquals("NO", read(2, new int[]{1, 2}, 1));
    }

    @Test
    void test_twoSumTwo() {
        assertEquals("3 4", twoSumTwo(new int[]{1, 3, 4, 5, 7, 11}, 9));
    }

    @Test
    void test_majorityElement() {
        // 2 2 1 3 1 1 3 1 1
        assertEquals(1, Medium.majorityElement(new int[]{2, 2, 1, 3, 1, 1, 3, 1, 1}));
        assertEquals(4, Medium.majorityElement(new int[]{4}));
        // -53 75 56 56 56
        assertEquals(56, Medium.majorityElement(new int[]{-53, 75, 56, 56, 56}));
    }

    @Test
    void test_spiralMatrix() {
        //1 5 9 13
        //14 15 16 17
        //19 20 21 50
        //59 60 71 80

        int[][] matrix = new int[][]{
                {1, 5, 9, 13},
                {14, 15, 16, 17},
                {19, 20, 21, 50},
                {59, 60, 71, 80}
        };
        int[] result = spiralMatrix(matrix);
        System.out.println(Arrays.toString(result));


//        1 3 7 9
//        10 12 15 17
//        19 20 21 50
        matrix = new int[][]{
                {1, 3, 7, 9},
                {10, 12, 15, 17},
                {19, 20, 21, 50}
        };
        result = spiralMatrix(matrix);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void test_bestTimeToBuyAndSellStock() throws IOException {
//        assertEquals(5, bestTimeToBuyAndSellStock(new int[]{7, 1, 5, 4, 3, 6}));
//        assertEquals(0, bestTimeToBuyAndSellStock(new int[]{5, 4, 3, 2, 1}));
//        assertEquals(4, bestTimeToBuyAndSellStock(new int[]{7, 7, 9, 8, 6, 7, 6, 10, 5}));
//        assertEquals(4, bestTimeToBuyAndSellStock(new int[]{7, 7, 9, 8, 6, 7, 6, 10, 5, 3, 3, 2}));

        // read data from the file
        List<Pair<Integer, List<Integer>>> arr = Utility.readInputFromFileForIntArray("src/main/resources/bestTimeToBuyAndSellStock.txt");

        for (Pair<Integer, List<Integer>> pair : arr) {
            int[] arr2 = pair.getSecond().stream().mapToInt(i -> i).toArray();
            int result = bestTimeToBuyAndSellStock(arr2);
            System.out.println(" target : " + pair.getFirst() + " result : " + result + " " + Arrays.toString(pair.getSecond().toArray()));
            assertEquals(pair.getFirst(), result);
        }
    }

    @Test
    void test_minimumBribes() {
        minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
    }

    @Test
    void test_orangesRotting() {
        assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, orangesRotting(new int[][]{{0, 2}}));
    }
}