package com.dsa.StriverAtoZ.step2;

import java.util.Arrays;

public class QuickSortDescending {

    public static int partitionDescending(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            // CHANGE 1: Find the first element SMALLER than pivot (from left)
            // (In ascending, this was <= pivot)
            while (i <= high - 1 && arr[i] >= pivot) {
                i++;
            }

            // CHANGE 2: Find the first element GREATER than pivot (from right)
            // (In ascending, this was > pivot)
            while (j >= low + 1 && arr[j] < pivot) {
                j--;
            }

            // Swap if they haven't crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionDescending(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int n = arr.length;

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, n - 1);

        System.out.println("After Sorting (Descending):");
        System.out.println(Arrays.toString(arr));
    }
}