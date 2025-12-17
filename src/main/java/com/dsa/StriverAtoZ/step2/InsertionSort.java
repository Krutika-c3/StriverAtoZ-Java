package com.dsa.StriverAtoZ.step2;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 45, 32, 5, 23};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
