package com.dsa.striver_a_to_z.step2.array;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySum {

    // ==========================================
    // Approach 1: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    // ==========================================
    public static int solveBruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        // Iterate over every possible starting point
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // Iterate over every possible ending point
            for (int j = i; j < n; j++) {
                sum += nums[j];

                // If sum matches k, we found a valid subarray
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // ==========================================
    // Approach 2: Optimal Approach (Prefix Sum + HashMap)
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    // ==========================================
    public static int solveOptimal(int[] nums, int k) {
        // Map to store prefix sums and their frequencies
        // Key: Prefix Sum, Value: Count of occurrences
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize with 0 having 1 occurrence to handle subarrays starting from index 0
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            // Update current prefix sum
            currentSum += num;

            // Check if (currentSum - k) exists in map
            // If it exists, it means we found subarrays summing to k
            int remove = currentSum - k;
            if (map.containsKey(remove)) {
                count += map.get(remove);
            }

            // Update the map with the current prefix sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    // ==========================================
    // Main Method to Run and Test
    // ==========================================
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;

        // Test Case 3 (Negative numbers)
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;

        System.out.println("--- Test Case 1 ---");
        System.out.println("Array: [1, 1, 1], k: 2");
        System.out.println("Brute Force Result: " + solveBruteForce(nums1, k1));
        System.out.println("Optimal Result:     " + solveOptimal(nums1, k1));
        System.out.println();

        System.out.println("--- Test Case 2 ---");
        System.out.println("Array: [1, 2, 3], k: 3");
        System.out.println("Brute Force Result: " + solveBruteForce(nums2, k2));
        System.out.println("Optimal Result:     " + solveOptimal(nums2, k2));
        System.out.println();

        System.out.println("--- Test Case 3 ---");
        System.out.println("Array: [3, 4, 7, 2, -3, 1, 4, 2], k: 7");
        System.out.println("Brute Force Result: " + solveBruteForce(nums3, k3));
        System.out.println("Optimal Result:     " + solveOptimal(nums3, k3));
    }
}