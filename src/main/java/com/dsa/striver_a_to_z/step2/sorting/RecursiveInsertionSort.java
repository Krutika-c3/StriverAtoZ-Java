package com.dsa.striver_a_to_z.step2.sorting;


import java.util.Arrays;

public class RecursiveInsertionSort {

    /**
     * Recursive function to perform Insertion Sort.
     * @param arr The array to be sorted
     * @param i The current index being processed (start with 0 or 1)
     * @param n The size of the array
     */
    public static void insertionSort(int[] arr, int i, int n) {
        // Base Case: If i reaches n, all elements are sorted.
        if (i == n) {
            return;
        }

        int j = i;

        // INNER LOGIC: Shift/Swap the element to its correct position
        // This loop pushes the current element 'back' into the sorted portion
        while (j > 0 && arr[j - 1] > arr[j]) {

            // Swap arr[j] and arr[j-1]
            int temp = arr[j];
            arr[j] = arr[j - 1];
            arr[j - 1] = temp;

            // Move pointer to the left to continue comparing
            j--;
        }

        // Recursive Call: Process the next element
        insertionSort(arr, i + 1, n);
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        // Start recursion from index 0
        insertionSort(arr, 0, n);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}