package com.dsa.StriverAtoZ.step2.array;

public class MissingNumber {

    // ---------------------------------------------------------
    // 1. Brute Force Approach
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int missingNumberBrute(int[] a, int N) {
        // Iterate through every number from 1 to N
        for (int i = 1; i <= N; i++) {
            int flag = 0;
            // Linear search for 'i' in the array
            for (int j = 0; j < N - 1; j++) {
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
    public static int missingNumberBetter(int[] a, int N) {
        int[] hash = new int[N + 1];

        // Mark present numbers
        for (int i = 0; i < N - 1; i++) {
            hash[a[i]]++;
        }

        // Find the missing one
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) return i;
        }
        return -1;
    }

    // ---------------------------------------------------------
    // 3. Optimal Approach (XOR)
    // Time Complexity: O(N) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int missingNumberOptimal(int[] a, int N) {
        int xor1 = 0;
        int xor2 = 0;

        // XOR elements from array and range simultaneously
        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i + 1);
        }
        // XOR with N (since loop ran till N-1)
        xor1 = xor1 ^ N;

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] a = {1, 2, 4, 5};

        System.out.println("Brute Force: " + missingNumberBrute(a, N));
        System.out.println("Better (Hash): " + missingNumberBetter(a, N));
        System.out.println("Optimal (XOR): " + missingNumberOptimal(a, N));
    }
}