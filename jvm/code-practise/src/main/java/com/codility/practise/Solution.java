package com.codility.practise;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        System.out.println(Arrays.toString(arr));
        System.out.println("desired sum = " + s);
        ArrayList<Integer> output = new ArrayList<Integer>();
        int[] sumArr = new int[n - 1];
        int lastIndex = -1;
        sumArr[0] = arr[0];
        for (int i = 1; i < n - 1; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
            if (sumArr[i] >= s) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex == -1) {
            output.add(-1);
            return output;
        }

        if (sumArr[lastIndex] == s) {
            output.add(0);
            output.add(lastIndex);
            return output;
        }
        System.out.println("lastIndex = " + lastIndex);
        System.out.println(Arrays.toString(sumArr));
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += arr[j];
//                if (sum == s) {
//                    output.add(i + 1);
//                    output.add(j + 1);
//                    return output;
//                }
//            }
//        }
        output.add(-1);
        return output;
    }
}
