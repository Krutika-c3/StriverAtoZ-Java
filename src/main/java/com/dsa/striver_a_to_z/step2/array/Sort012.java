package com.dsa.striver_a_to_z.step2.array;

import java.util.Arrays;

public class Sort012 {

    // =========================================================
    // 1. Brute Force Approach
    // Logic: Use standard sorting library.
    // Time Complexity: O(N log N) | Space Complexity: O(1)
    // =========================================================
    public static void sortBrute(int[] nums) {
        Arrays.sort(nums);
    }

    // =========================================================
    // 2. Better Approach (Counting Sort Variant)
    // Logic: Count frequency of 0, 1, 2 and overwrite array.
    // Time Complexity: O(2N) | Space Complexity: O(1)
    // =========================================================
    public static void sortBetter(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;

        // Pass 1: Count occurrences
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
        }

        // Pass 2: Overwrite array based on counts
        for (int i = 0; i < cnt0; i++) nums[i] = 0;
        for (int i = cnt0; i < cnt0 + cnt1; i++) nums[i] = 1;
        for (int i = cnt0 + cnt1; i < nums.length; i++) nums[i] = 2;
    }

    // =========================================================
    // 3. Optimal Approach (Dutch National Flag Algorithm)
    // Logic: Single pass using 3 pointers (low, mid, high).
    // Time Complexity: O(N) | Space Complexity: O(1)
    // =========================================================
    public static void sortOptimal(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Case 0: Swap with low, move both low and mid forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Case 1: Already in correct place, just move mid
                mid++;
            } else {
                // Case 2: Swap with high, decrement high.
                // Don't move mid (need to check swapped element)
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap elements
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // =========================================================
    // Main Method to Run Tests
    // =========================================================
    public static void main(String[] args) {
        int[] originalArray = {2, 0, 2, 1, 1, 0};

        System.out.println("Original Array: " + Arrays.toString(originalArray));

        // Test Brute Force
        int[] arr1 = originalArray.clone(); // Clone to keep original fresh
        sortBrute(arr1);
        System.out.println("Brute Force:    " + Arrays.toString(arr1));

        // Test Better Approach
        int[] arr2 = originalArray.clone();
        sortBetter(arr2);
        System.out.println("Better (Count): " + Arrays.toString(arr2));

        // Test Optimal Approach
        int[] arr3 = originalArray.clone();
        sortOptimal(arr3);
        System.out.println("Optimal (DNF):  " + Arrays.toString(arr3));
    }
}