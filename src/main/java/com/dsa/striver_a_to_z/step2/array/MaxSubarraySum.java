package com.dsa.striver_a_to_z.step2.array;

public class MaxSubarraySum {

    // ---------------------------------------------------------
    // Approach 1: Brute Force
    // Logic: Iterate through all possible subarrays (i to j),
    // calculate sum using a third loop (k), and compare.
    // ---------------------------------------------------------
    public static long maxSubarraySumBrute(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = 0;
                // Calculate sum of subarray arr[i...j]
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)


    // ---------------------------------------------------------
    // Approach 2: Better Approach
    // Logic: Optimize by carrying the sum forward in the inner loop.
    // Avoids the third loop (k).
    // ---------------------------------------------------------
    public static long maxSubarraySumBetter(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                // Add current element to running sum of this subarray
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)


    // ---------------------------------------------------------
    // Approach 3: Optimal (Kadane's Algorithm)
    // Logic: Iterate once. Add elements to sum. If sum > max, update max.
    // If sum becomes negative, discard it (reset to 0) as it won't help future subarrays.
    // ---------------------------------------------------------
    public static long maxSubarraySumOptimal(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum drops below zero, reset it
            if (sum < 0) {
                sum = 0;
            }
        }

        // Optional: If you need to handle the case where all numbers are negative
        // and an empty subarray (sum 0) is allowed, verify maxi here.

        return maxi;
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)


    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;

        System.out.println("Brute Force Sum: " + maxSubarraySumBrute(arr, n));
        System.out.println("Better Sum:      " + maxSubarraySumBetter(arr, n));
        System.out.println("Optimal Sum:     " + maxSubarraySumOptimal(arr, n));
    }
}