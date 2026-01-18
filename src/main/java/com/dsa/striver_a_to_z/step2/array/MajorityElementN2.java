package com.dsa.striver_a_to_z.step2.array;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementN2 {

    // =========================================================
    // 1. Brute Force Approach
    // Logic: Check every element and count its frequency manually.
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // =========================================================
    public static int solveBrute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1; // Return -1 if no majority element found
    }

    // =========================================================
    // 2. Better Approach (Using Hashing)
    // Logic: Use a map to store frequencies and find the winner.
    // Time Complexity: O(N) | Space Complexity: O(N)
    // =========================================================
    public static int solveBetter(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check map for majority
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1; // Return -1 if no majority element found
    }

    // =========================================================
    // 3. Optimal Approach (Moore's Voting Algorithm)
    // Logic: Cancel out non-majority elements. The survivor is the candidate.
    // Time Complexity: O(N) | Space Complexity: O(1)
    // =========================================================
    public static int solveOptimal(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        // Phase 1: Voting - Find a candidate
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verification - Confirm the candidate is actually majority
        // This is crucial for the "No Majority" case
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                count1++;
            }
        }

        if (count1 > n / 2) {
            return element;
        }
        return -1; // Return -1 if candidate failed verification
    }

    // =========================================================
    // Main Method to Run Tests
    // =========================================================
    public static void main(String[] args) {
        // --- Test Case 1: Majority Exists ---
        System.out.println("--- Test Case 1: Majority Exists ---");
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Input Array: " + java.util.Arrays.toString(nums));

        System.out.println("Brute Force:    " + solveBrute(nums));
        System.out.println("Better (Map):   " + solveBetter(nums));
        System.out.println("Optimal (Moores): " + solveOptimal(nums));

        // --- Test Case 2: No Majority Exists ---
        System.out.println("\n--- Test Case 2: No Majority Exists ---");
        int[] numsNoMajority = {1, 2, 3, 4, 1, 2}; // Length 6. Max freq is 2 (not > 3)
        System.out.println("Input Array: " + java.util.Arrays.toString(numsNoMajority));

        System.out.println("Brute Force:    " + solveBrute(numsNoMajority));   // Expected: -1
        System.out.println("Better (Map):   " + solveBetter(numsNoMajority));  // Expected: -1
        System.out.println("Optimal (Moores): " + solveOptimal(numsNoMajority)); // Expected: -1
    }
}