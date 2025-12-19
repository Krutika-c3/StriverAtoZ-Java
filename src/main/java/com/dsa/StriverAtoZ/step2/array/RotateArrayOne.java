package com.dsa.StriverAtoZ.step2.array;

import java.util.Arrays;

public class RotateArrayOne {

    // Optimal Approach
    // Time Complexity: O(N) | Space Complexity: O(1)
    public static void solve(int[] arr, int n) {
        if (n == 0) return;

        int temp = arr[0]; // Store the first element

        // Shift elements to the left
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the end
        arr[n - 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original: " + Arrays.toString(arr));

        solve(arr, arr.length);

        System.out.println("Rotated:  " + Arrays.toString(arr));
    }
}