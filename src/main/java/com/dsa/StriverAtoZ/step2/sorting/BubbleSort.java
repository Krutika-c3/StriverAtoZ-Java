package com.dsa.StriverAtoZ.step2.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = n - 1; i >= 1; i--) {
            int didSwap = 0;

            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = 1;
                }
            }

            // Optimization: If no swaps, array is sorted
            if (didSwap == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 45, 32, 5, 23};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}