package com.dsa.StriverAtoZ.step2.sorting;

import java.util.Arrays;

public class QuickSortAscending {

    /**
     * The Partition Function
     * This function takes the first element as the pivot, places it
     * in its correct sorted position, and moves smaller elements to the left
     * and larger elements to the right.
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        // Iterate until the pointers cross
        while (i < j) {

            // 1. Find the first element greater than the pivot (from left)
            // We check (i <= high - 1) to avoid IndexOutOfBounds
            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            // 2. Find the first element smaller than or equal to the pivot (from right)
            // We check (j >= low + 1) to ensure we don't go out of bounds
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            // 3. If i and j haven't crossed, swap them to fix their relative positions
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 4. Place the pivot in its correct position
        // j has crossed i and is now pointing to the last element smaller than pivot
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        // Return the index where the pivot is now placed
        return j;
    }

    /**
     * Main Recursive QuickSort Function
     */
    public static void quickSort(int[] arr, int low, int high) {
        // Base Case: If the range has 1 or 0 elements, it is sorted.
        if (low < high) {

            // 1. Partition the array and get the pivot's correct index
            int pIndex = partition(arr, low, high);

            // 2. Recursively sort the left half
            quickSort(arr, low, pIndex - 1);

            // 3. Recursively sort the right half
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        int n = arr.length;

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, n - 1);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}