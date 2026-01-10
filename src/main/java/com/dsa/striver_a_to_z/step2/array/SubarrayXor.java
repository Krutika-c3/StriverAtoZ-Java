package com.dsa.striver_a_to_z.step2.array;

import java.util.HashMap;
import java.util.Map;

public class SubarrayXor {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static int solveBrute(int[] A, int B) {
        int n = A.length;
        int count = 0;

        // Iterate over all possible starting points
        for (int i = 0; i < n; i++) {
            int current_xor = 0;
            // Iterate over all possible ending points
            for (int j = i; j < n; j++) {
                current_xor = current_xor ^ A[j];

                if (current_xor == B) {
                    count++;
                }
            }
        }
        return count;
    }

    // ==========================================
    // 2. OPTIMAL APPROACH (HASHING / PREFIX XOR)
    // Time: O(N) | Space: O(N)
    // ==========================================
    public static int solveOptimal(int[] A, int B) {
        int n = A.length;
        int xr = 0;
        int count = 0;

        // Map to store prefix XOR frequencies
        Map<Integer, Integer> mpp = new HashMap<>();

        // Base case: XOR of 0 has appeared once
        mpp.put(0, 1);

        for (int i = 0; i < n; i++) {
            // Calculate prefix XOR up to current index
            xr = xr ^ A[i];

            // By formula: X = XR ^ K
            int x = xr ^ B;

            // If X exists in map, add its frequency to count
            if (mpp.containsKey(x)) {
                count += mpp.get(x);
            }

            // Update the map with the current prefix XOR
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }

        return count;
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        // Test Case
        int[] A = {4, 2, 2, 6, 4};
        int K = 6;

        System.out.println("Input Array: [4, 2, 2, 6, 4]");
        System.out.println("Target XOR (K): " + K);
        System.out.println("--------------------------------------------------");

        // 1. Brute Force
        int resultBrute = solveBrute(A, K);
        System.out.println("1. Brute Force Result: " + resultBrute);

        // 2. Optimal Approach
        int resultOptimal = solveOptimal(A, K);
        System.out.println("2. Optimal Result:     " + resultOptimal);

        // Verification:
        // Subarrays with XOR 6:
        // [4, 2] -> 4^2 = 6
        // [2, 2, 6] -> 2^2^6 = 6
        // [6] -> 6
        // [4, 2, 2, 6, 4] -> 4^2^2^6^4 = 6
        // Total should be 4
    }
}