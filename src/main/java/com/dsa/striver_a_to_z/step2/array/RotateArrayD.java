package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArrayD {

    // Brute Force Approach
    // Time Complexity: O(N) | Space Complexity: O(d)
    public static void rotateBrute(int[] arr, int n, int d) {
        d = d % n;
        if (d == 0) return;

        ArrayList<Integer> temp = new ArrayList<>();
        // Store first d elements
        for (int i = 0; i < d; i++) temp.add(arr[i]);

        // Shift remaining elements
        for (int i = d; i < n; i++) arr[i - d] = arr[i];

        // Put back elements
        for (int i = 0; i < d; i++) arr[n - d + i] = temp.get(i);
    }

    // Optimal Approach (Reversal Algorithm)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public static void rotateOptimal(int[] arr, int n, int d) {
        d = d % n;
        if (d == 0) return;

        reverse(arr, 0, d - 1);     // Reverse first part
        reverse(arr, d, n - 1);     // Reverse second part
        reverse(arr, 0, n - 1);     // Reverse whole array
    }

    // Helper for Optimal Approach
    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        System.out.println("Brute Approach: ");
        System.out.println("Original: " + Arrays.toString(arr1));
        // Using Brute Approach
        rotateBrute(arr1, arr1.length, d);
        System.out.println("Rotated by " + d + ": " + Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Optimal Approach: ");
        System.out.println("Original: " + Arrays.toString(arr2));
        // Using Optimal Approach
        rotateOptimal(arr2, arr2.length, d);
        System.out.println("Rotated by " + d + ": " + Arrays.toString(arr2));
    }
}