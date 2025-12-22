package com.dsa.striver_a_to_z.step2.array;

import java.util.Arrays;

public class NextPermutation {

    /**
     * Optimal Approach: O(N) Time | O(1) Space
     * Modifies the array in-place to the next lexicographical permutation.
     */
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1; // Index of the break point

        // Step 1: Find the break point
        // Traverse from right to left to find the first element that is smaller than the next one
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: If break point doesn't exist, the array is in descending order.
        // Reverse the whole array to get the smallest permutation.
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the next greater element to swap with the break point
        // Traverse from right to left to find the first element greater than nums[ind]
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // Step 4: Reverse the right half (elements after the break point)
        // This places the remaining elements in ascending order to ensure the smallest lexicographical value
        reverse(nums, ind + 1, n - 1);
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Main method to run and test the code
    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] arr1 = {1, 3, 2};
        System.out.println("Original Array: " + Arrays.toString(arr1));
        nextPermutation(arr1);
        System.out.println("Next Permutation: " + Arrays.toString(arr1));

        System.out.println("-------------------");

        // Test Case 2: Last permutation (descending order)
        int[] arr2 = {3, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(arr2));
        nextPermutation(arr2);
        System.out.println("Next Permutation: " + Arrays.toString(arr2)); // Should wrap to [1, 2, 3]

        System.out.println("-------------------");

        // Test Case 3: Array with duplicates
        int[] arr3 = {1, 1, 5};
        System.out.println("Original Array: " + Arrays.toString(arr3));
        nextPermutation(arr3);
        System.out.println("Next Permutation: " + Arrays.toString(arr3));
    }
}