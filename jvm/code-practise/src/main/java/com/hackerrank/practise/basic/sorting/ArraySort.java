package com.hackerrank.practise.basic.sorting;

import java.util.Arrays;

public class ArraySort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high) {
        int max = low;
        // take the pivot element
        int pivot = arr[high];

        // rearrange - compare the pivot with each element in the array
        for (int i = low; i < high; i++) {
            // swap the elements and increase the max
            if (arr[i] < pivot) {
                arr[i] = (arr[max] + arr[i] - (arr[max] = arr[i]));
                max++;
            }
        }
        // swap pivot with the max
        arr[high] = (arr[max] + arr[high] - (arr[max] = arr[high]));
        return max;
    }

    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // step 1: partition the array
            int partition = partition(arr, low, high);
            // step 3: pass the array and the pivot
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        bubbleSort(arr);
        insertionSort(arr);

        quickSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));
        arr = new int[]{8, 7, 6, 1, 0, 9, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));
        arr = new int[]{8, 7, 6, 1, 0, 9, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
