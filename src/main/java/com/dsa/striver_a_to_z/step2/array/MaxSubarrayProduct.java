package com.dsa.striver_a_to_z.step2.array;

public class MaxSubarrayProduct {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static int maxProductBrute(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentProduct = 1;
            for (int j = i; j < n; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }

    // ==========================================
    // 2. OPTIMAL APPROACH (PREFIX/SUFFIX)
    // Time: O(N) | Space: O(1)
    // ==========================================
    public static int maxProductOptimal(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        // Using double or long to prevent overflow during intermediate calculations
        // if inputs are large, though typical constraints fit in double/long.
        double prefix = 1;
        double suffix = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            maxProduct = (int) Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        int[] arr1 = {2, 3, -2, 4}; // Expected: 6
        int[] arr2 = {-2, 0, -1};   // Expected: 0
        int[] arr3 = {-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4}; // Complex case

        System.out.println("Test Case 1: [2, 3, -2, 4]");
        System.out.println("Brute Force: " + maxProductBrute(arr1));
        System.out.println("Optimal:     " + maxProductOptimal(arr1));
        System.out.println();

        System.out.println("Test Case 2: [-2, 0, -1]");
        System.out.println("Brute Force: " + maxProductBrute(arr2));
        System.out.println("Optimal:     " + maxProductOptimal(arr2));
        System.out.println();

        System.out.println("Test Case 3: Complex Mixed");
        System.out.println("Brute Force: " + maxProductBrute(arr3));
        System.out.println("Optimal:     " + maxProductOptimal(arr3));
    }
}
