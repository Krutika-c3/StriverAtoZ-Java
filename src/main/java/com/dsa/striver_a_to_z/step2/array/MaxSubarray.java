package com.dsa.striver_a_to_z.step2.array;

public class MaxSubarray {

    // ---------------------------------------------------------
    // Approach 1: Brute Force (Printing)
    // Logic: Same as Brute Force Sum, but we track start/end indices.
    // ---------------------------------------------------------
    public static void printMaxSubarrayBrute(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > maxi) {
                    maxi = sum;
                    ansStart = i;
                    ansEnd = j;
                }
            }
        }
        printArrayRange(arr, ansStart, ansEnd, "Brute Force");
    }
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)


    // ---------------------------------------------------------
    // Approach 2: Better Approach (Printing)
    // Logic: Same as Better Sum, tracking indices when max is updated.
    // ---------------------------------------------------------
    public static void printMaxSubarrayBetter(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxi) {
                    maxi = sum;
                    ansStart = i;
                    ansEnd = j;
                }
            }
        }
        printArrayRange(arr, ansStart, ansEnd, "Better Approach");
    }
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)


    // ---------------------------------------------------------
    // Approach 3: Optimal (Kadane's Algorithm with Printing)
    // Logic: Track a 'tempStart'. Whenever sum is reset to 0,
    // update 'tempStart' to the current index. When max is updated,
    // lock in 'ansStart' and 'ansEnd'.
    // ---------------------------------------------------------
    public static void printMaxSubarrayOptimal(int[] arr, int n) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;

        int start = 0; // Tracks the starting index of the CURRENT running sum
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < n; i++) {
            // If sum is 0, it means we effectively started a new subarray at i
            // Note: This logic works because we reset sum to 0 below.
            if (sum == 0) start = i;

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        printArrayRange(arr, ansStart, ansEnd, "Optimal Approach");
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)


    // Helper method to print the array segment
    private static void printArrayRange(int[] arr, int start, int end, String approachName) {
        System.out.print(approachName + " Subarray: [");
        if (start != -1 && end != -1) {
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + (i < end ? ", " : ""));
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;

        printMaxSubarrayBrute(arr, n);
        printMaxSubarrayBetter(arr, n);
        printMaxSubarrayOptimal(arr, n);
    }
}
