package com.dsa.striver_a_to_z.step2.array;
import java.util.*;

public class LongestSubarray {

    // =========================================================
    // 1. Brute Force Approach
    // Logic: Iterate all subarrays and check sums.
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // =========================================================
    public static int solveBrute(int[] a, long k) {
        int n = a.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            long currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += a[j];
                if (currentSum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // =========================================================
    // 2. Better Approach (Prefix Sum + HashMap)
    // Logic: Uses reverse math (Sum - K).
    // * Note: This is OPTIMAL if the array has Negatives.
    // * It is "Better" for Positives due to O(N) space.
    // Time Complexity: O(N) | Space Complexity: O(N)
    // =========================================================
    public static int solveBetter(int[] nums, long k) {
        int n = nums.length;

        // HashMap to store <PrefixSum, Index>
        // Key: The cumulative sum.
        // Value: The FIRST index where this sum was encountered.
        Map<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int maxLen = 0;

        // INITIALIZATION IS CRITICAL:
        // We put (0, -1) to handle the case where the sub-array starts from index 0.
        // Example: nums = [3, ...], k = 3.
        // Current Sum = 3. Remainder = 3 - 3 = 0.
        // If map has (0, -1), length = CurrentIndex(0) - (-1) = 1. Correct.
        preSumMap.put(0L, -1);

        for (int i = 0; i < n; i++) {
            // 1. Calculate the running prefix sum
            sum += nums[i];

            // 2. Calculate the 'remaining' sum we are looking for in the past.
            // If CurrentSum = X, and we want a subarray of sum K,
            // then we need to find a previous point where sum was (X - K).
            long rem = sum - k;

            // 3. Check if this 'remaining' sum exists in our history (map)
            if (preSumMap.containsKey(rem)) {
                // If it exists, the subarray between that previous index and
                // the current index 'i' sums to 'k'.
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // 4. Update the map with the current sum
            // CRITICAL logic for "Longest" Subarray:
            // We only add the 'sum' if it is NOT already present.
            // Why? Because if we saw sum 'S' at index 2, and again at index 5,
            // keeping index 2 allows us to form a longer subarray later.
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    // =========================================================
    // 3. Optimal Approach (Two Pointers / Greedy)
    // Logic: Sliding window. Expand right, shrink left if sum > k.
    // * MOST OPTIMAL for Positives and Zeros (O(1) Space).
    // * FAILS for Negatives.
    // Time Complexity: O(2N) | Space Complexity: O(1)
    // =========================================================
    public static int solveOptimal(int[] a, long k) {
        int n = a.length;
        int left = 0;
        int right = 0;
        long sum = a[0]; // Initialize sum with the first element
        int maxLen = 0;

        // Iterate while the right pointer is within bounds
        while (right < n) {

            // Condition 1: Shrink Window from Left
            // While sum is greater than K, we must remove elements from the left
            // because adding more from the right will only increase it (since no negatives).
            // 'left <= right' check ensures pointers don't cross.
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // Condition 2: Check for Valid Window
            // If the current window sum exactly matches K, check length.
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move the right pointer forward to expand the window
            right++;

            // Condition 3: Add new element
            // Before adding, ensure 'right' hasn't exceeded array bounds
            if (right < n) {
                sum += a[right];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // --- Test Case 1: Positives Only ---
        // Expected Answer: 3 (Subarray: 1, 1, 1, 1, ..., but wait: {3, 3} is sum 6 length 2. {1,2,3} is 6 length 3.)
        int[] aPositive = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        long kPositive = 6;

        System.out.println("--- Test Case 1: Positives Only ---");
        System.out.println("Brute Force: " + solveBrute(aPositive, kPositive));
        System.out.println("Better (Map): " + solveBetter(aPositive, kPositive));
        System.out.println("Optimal (2Ptr): " + solveOptimal(aPositive, kPositive));

        // --- Test Case 2: With Negatives ---
        // Array: {10, -5, 2} with k = 7.
        // Logic: 10 + (-5) + 2 = 7. Expected Length: 3.
        // NOTE: Optimal (Two Pointer) will FAIL here.
        // Trace: Starts at 10. 10 > 7, so it shrinks (removes 10). Window is lost. Result 0.
        int[] aNegative = {10, -5, 2};
        long kNegative = 7;

        System.out.println("\n--- Test Case 2: With Negatives ---");
        System.out.println("Brute Force: " + solveBrute(aNegative, kNegative)); // Works
        System.out.println("Better (Map): " + solveBetter(aNegative, kNegative)); // Works (Most Optimal for negatives)
    }
}