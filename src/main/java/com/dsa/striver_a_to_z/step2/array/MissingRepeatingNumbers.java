package com.dsa.striver_a_to_z.step2.array;

import java.util.Arrays;

public class MissingRepeatingNumbers {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static int[] solveBrute(int[] a) {
        int n = a.length;
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int val : a) {
                if (val == i) count++;
            }
            if (count == 2) repeating = i;
            else if (count == 0) missing = i;

            if (repeating != -1 && missing != -1) break;
        }
        return new int[]{repeating, missing};
    }

    // ==========================================
    // 2. BETTER APPROACH (HASHING)
    // Time: O(2N) | Space: O(N)
    // ==========================================
    public static int[] solveBetter(int[] a) {
        int n = a.length;
        int[] hash = new int[n + 1];

        for (int val : a) hash[val]++;

        int repeating = -1;
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }

    // ==========================================
    // 3. OPTIMAL APPROACH 1 (MATH EQUATIONS)
    // Time: O(N) | Space: O(1)
    // ==========================================
    public static int[] solveMath(int[] a) {
        long n = a.length;
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        long S = 0;
        long S2 = 0;
        for (int val : a) {
            S += val;
            S2 += (long)val * (long)val;
        }

        long val1 = S - SN; // X - Y
        long val2 = S2 - S2N; // X^2 - Y^2
        long val3 = val2 / val1; // X + Y

        long x = (val1 + val3) / 2;
        long y = x - val1;

        return new int[]{(int)x, (int)y};
    }

    // ==========================================
    // 4. OPTIMAL APPROACH 2 (XOR)
    // Time: O(N) | Space: O(1)
    // ==========================================
    public static int[] solveXOR(int[] a) {
        int n = a.length;
        int xr = 0;

        for (int i = 0; i < n; i++) {
            xr ^= a[i];
            xr ^= (i + 1);
        }

        int number = (xr & ~(xr - 1)); // Rightmost set bit
        int zero = 0;
        int one = 0;

        for (int i = 0; i < n; i++) {
            // Process array elements
            if ((a[i] & number) != 0) one ^= a[i];
            else zero ^= a[i];

            // Process 1..N
            if (((i + 1) & number) != 0) one ^= (i + 1);
            else zero ^= (i + 1);
        }

        int cnt = 0;
        for (int val : a) {
            if (val == zero) cnt++;
        }

        if (cnt == 2) return new int[]{zero, one};
        return new int[]{one, zero};
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1}; // N=6. Repeating: 1, Missing: 5

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Expected: [Repeating: 1, Missing: 5]");
        System.out.println("------------------------------------");

        System.out.println("1. Brute Force: " + Arrays.toString(solveBrute(arr)));
        System.out.println("2. Better (Hash): " + Arrays.toString(solveBetter(arr)));
        System.out.println("3. Optimal (Math): " + Arrays.toString(solveMath(arr)));
        System.out.println("4. Optimal (XOR): " + Arrays.toString(solveXOR(arr)));
    }
}
