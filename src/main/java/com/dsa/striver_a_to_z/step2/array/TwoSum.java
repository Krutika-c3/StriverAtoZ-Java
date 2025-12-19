package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class TwoSum {

    // =========================================================
    // 1. Brute Force Approach
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // =========================================================

    // Variety 1: Return YES/NO
    public static String bruteForceV1(int[] n, int target) {
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] + n[j] == target) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    // Variety 2: Return Indices
    public static int[] bruteForceV2(int[] n, int target) {
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] + n[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // =========================================================
    // 2. Better Approach (Using Hashing)
    // Time Complexity: O(N) | Space Complexity: O(N)
    // * Optimal for Variety 2 (Indices)
    // =========================================================

    // Variety 1: Return YES/NO
    public static String betterApprochV1(int[] n, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            int num = n[i];
            int moreNeeded = target - num;

            if (map.containsKey(moreNeeded)) {
                return "YES";
            }
            map.put(num, i);
        }
        return "NO";
    }

    // Variety 2: Return Indices
    public static int[] betterApprochV2(int[] n, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            int num = n[i];
            int moreNeeded = target - num;

            if (map.containsKey(moreNeeded)) {
                return new int[]{map.get(moreNeeded), i};
            }
            map.put(num, i);
        }
        return new int[]{};
    }

    // =========================================================
    // 3. Optimal Approach (Two Pointers)
    // Time Complexity: O(N log N) | Space Complexity: O(1)
    // * Optimal for Variety 1 (YES/NO) only.
    // * Note: This modifies the array order due to sorting.
    // =========================================================

    // Variety 1: Return YES/NO
    public static String optimalApproachV1(int[] n, int target) {
        // Sort the array first
        Arrays.sort(n);

        int left = 0;
        int right = n.length - 1;

        while (left < right) {
            int sum = n[left] + n[right];

            if (sum == target) {
                return "YES";
            } else if (sum < target) {
                left++; // Sum is too small, need larger
            } else {
                right--; // Sum is too large, need smaller
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        // Test Data
        int[] arr1 = {2, 6, 5, 8, 11};
        int target = 14;

        System.out.println("--- Brute Force ---");
        System.out.println("Variety 1 (Exists?): " + bruteForceV1(arr1, target));
        int[] resBrute = bruteForceV2(arr1, target);
        System.out.println("Variety 2 (Indices): [" + (resBrute.length > 0 ? resBrute[0] + ", " + resBrute[1] : "") + "]");

        System.out.println("\n--- Better (Hashing) ---");
        System.out.println("Variety 1 (Exists?): " + betterApprochV1(arr1, target));
        int[] resBetter = betterApprochV2(arr1, target);
        System.out.println("Variety 2 (Indices): [" + (resBetter.length > 0 ? resBetter[0] + ", " + resBetter[1] : "") + "]");

        System.out.println("\n--- Optimal (Two Pointers) ---");
        // NOTE: We clone the array because sorting modifies it in-place
        System.out.println("Variety 1 (Exists?): " + optimalApproachV1(arr1.clone(), target));
    }
}