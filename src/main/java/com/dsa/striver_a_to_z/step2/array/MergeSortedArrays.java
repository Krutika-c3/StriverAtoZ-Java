package com.dsa.striver_a_to_z.step2.array;

import java.util.Arrays;

public class MergeSortedArrays {

    // ==========================================
    // 1. BRUTE FORCE APPROACH (Using Extra Space)
    // Time: O(N + M) | Space: O(N + M)
    // ==========================================
    public static void mergeBruteForce(long[] arr1, long[] arr2, int n, int m) {
        long[] arr3 = new long[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        // Merge two arrays into arr3
        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index++] = arr1[left++];
            } else {
                arr3[index++] = arr2[right++];
            }
        }

        // Copy remaining elements
        while (left < n) arr3[index++] = arr1[left++];
        while (right < m) arr3[index++] = arr2[right++];

        // Copy back to arr1 and arr2
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
    }

    // ==========================================
    // 2. OPTIMAL APPROACH 1 (Two Pointers + Sort)
    // Time: O(min(N, M)) + Sorting | Space: O(1)
    // ==========================================
    public static void mergeOptimal1(long[] arr1, long[] arr2, int n, int m) {
        int left = n - 1;
        int right = 0;

        // Swap if element in arr1 is greater than element in arr2
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                // Since arrays are sorted, if we hit this, we are done swapping
                break;
            }
        }

        // Restore order
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // ==========================================
    // 3. OPTIMAL APPROACH 2 (Gap Method / Shell Sort)
    // Time: O((N+M) * log(N+M)) | Space: O(1)
    // ==========================================

    // Helper to swap elements if they are in wrong order
    private static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void mergeOptimal2(long[] arr1, long[] arr2, int n, int m) {
        int len = n + m;
        // Initial Gap: ceil((n+m)/2)
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // Case 1: Left pointer in arr1, Right pointer in arr2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // Case 2: Both pointers in arr2
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // Case 3: Both pointers in arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }

            // Break if gap was 1 to avoid infinite loop
            if (gap == 1) break;

            // Reduce gap
            gap = (gap / 2) + (gap % 2);
        }
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        // Initial Arrays
        long[] originalArr1 = {1, 3, 5, 7};
        long[] originalArr2 = {0, 2, 6, 8, 9};

        System.out.println("=== MERGE SORTED ARRAYS WITHOUT EXTRA SPACE ===\n");
        System.out.println("Input Arrays:");
        System.out.println("Arr1: " + Arrays.toString(originalArr1));
        System.out.println("Arr2: " + Arrays.toString(originalArr2));
        System.out.println("---------------------------------------------");

        // --- TEST 1: Brute Force ---
        long[] a1 = originalArr1.clone();
        long[] a2 = originalArr2.clone();

        mergeBruteForce(a1, a2, a1.length, a2.length);

        System.out.println("1. Brute Force Result:");
        System.out.println("Arr1: " + Arrays.toString(a1));
        System.out.println("Arr2: " + Arrays.toString(a2));
        System.out.println();

        // --- TEST 2: Optimal 1 (Two Pointers) ---
        a1 = originalArr1.clone();
        a2 = originalArr2.clone();

        mergeOptimal1(a1, a2, a1.length, a2.length);

        System.out.println("2. Optimal Approach 1 (Two Pointers):");
        System.out.println("Arr1: " + Arrays.toString(a1));
        System.out.println("Arr2: " + Arrays.toString(a2));
        System.out.println();

        // --- TEST 3: Optimal 2 (Gap Method) ---
        a1 = originalArr1.clone();
        a2 = originalArr2.clone();

        mergeOptimal2(a1, a2, a1.length, a2.length);

        System.out.println("3. Optimal Approach 2 (Gap Method):");
        System.out.println("Arr1: " + Arrays.toString(a1));
        System.out.println("Arr2: " + Arrays.toString(a2));
    }
}