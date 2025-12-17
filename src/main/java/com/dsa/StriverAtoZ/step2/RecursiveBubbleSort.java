package com.dsa.StriverAtoZ.step2;

import java.util.Arrays;

public class RecursiveBubbleSort {

    /**
     * Recursive function to perform Bubble Sort.
     * @param arr The array to be sorted
     * @param n The size of the portion of the array currently being considered
     */
    public static void bubbleSort(int[] arr, int n) {
        // Base Case: If only 1 element is left, it's sorted.
        if (n == 1) {
            return;
        }

        int count = 0; // To track if any swaps happened (Optimization)

        // Perform one pass of Bubble Sort
        // Iterate up to n-2 (i < n-1) because we compare i with i+1
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap logic
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                count++;
            }
        }

        // Optimization: If no swaps occurred in this pass, the array is already sorted.
        if (count == 0) {
            return;
        }

        // Recursive Call: The largest element is now fixed at index n-1.
        // Sort the remaining elements (first n-1 elements).
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr, n);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}