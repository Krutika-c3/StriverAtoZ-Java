package com.dsa.striver_a_to_z.step2.array;

public class MissingNumber {

    // ---------------------------------------------------------
    // 1. Brute Force Approach
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int missingNumberBrute(int[] a, int n) {
        // Iterate through every number from 1 to N
        for (int i = 1; i <= n; i++) {
            int flag = 0;
            // Linear search for 'i' in the array
            for (int j = 0; j < n - 1; j++) {
                if (a[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;
        }
        return -1;
    }

    // ---------------------------------------------------------
    // 2. Better Approach (Using Hashing)
    // Time Complexity: O(2N) | Space Complexity: O(N)
    // ---------------------------------------------------------
    public static int missingNumberBetter(int[] a, int n) {
        int[] hash = new int[n + 1];

        // Mark present numbers
        for (int i = 0; i < n - 1; i++) {
            hash[a[i]]++;
        }

        // Find the missing one
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) return i;
        }
        return -1;
    }

    // ---------------------------------------------------------
    // 3. Optimal Approach (XOR)
    // Time Complexity: O(N) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int missingNumberOptimal(int[] a, int n) {
        int xor1 = 0;
        int xor2 = 0;

        // XOR elements from array and range simultaneously
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i + 1);
        }
        // XOR with n (since loop ran till n-1)
        xor1 = xor1 ^ n;

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = {1, 2, 4, 5};

        System.out.println("Brute Force: " + missingNumberBrute(a, n));
        System.out.println("Better (Hash): " + missingNumberBetter(a, n));
        System.out.println("Optimal (XOR): " + missingNumberOptimal(a, n));
    }
}