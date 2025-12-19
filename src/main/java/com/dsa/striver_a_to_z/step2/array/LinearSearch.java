package com.dsa.striver_a_to_z.step2.array;

public class LinearSearch {

    // Optimal Approach
    // Time Complexity: O(N) | Space Complexity: O(1)
    public static int search(int[] arr, int n, int num) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 50, 30, 70, 80};
        int target = 30;

        int index = search(arr, arr.length, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }
}