package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class MajorityElementN3 {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static List<Integer> majorityElementBrute(int[] v) {
        int n = v.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Optimization: If we already found 2 elements, stop.
            if (list.isEmpty() || list.get(0) != v[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (v[j] == v[i]) {
                        count++;
                    }
                }

                if (count > n / 3) {
                    list.add(v[i]);
                }
            }
            if (list.size() == 2) break;
        }
        Collections.sort(list); // Sorting for consistent output
        return list;
    }

    // ==========================================
    // 2. BETTER APPROACH (HASHING)
    // Time: O(N) | Space: O(N)
    // ==========================================
    public static List<Integer> majorityElementBetter(int[] v) {
        int n = v.length;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Threshold required
        int mini = (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(v[i], 0);
            map.put(v[i], value + 1);

            // Check if it reached the minimum requirement just now
            if (map.get(v[i]) == mini) {
                list.add(v[i]);
            }

            // Optimization: Stop if we found 2 numbers
            if (list.size() == 2) break;
        }

        Collections.sort(list);
        return list;
    }

    // ==========================================
    // 3. OPTIMAL APPROACH (EXTENDED BOYER-MOORE)
    // Time: O(N) | Space: O(1)
    // ==========================================
    public static List<Integer> majorityElementOptimal(int[] v) {
        int n = v.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // Pass 1: Find potential candidates
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && v[i] != el2) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && v[i] != el1) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) {
                cnt1++;
            } else if (v[i] == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Pass 2: Verify candidates
        List<Integer> ls = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        Collections.sort(ls);
        return ls;
    }

    // ==========================================
    // MAIN DRIVER TO TEST ALL METHODS
    // ==========================================
    public static void main(String[] args) {
        // Test Case: Array with elements appearing > n/3 times
        // Size = 8, n/3 = 2. Elements must appear >= 3 times.
        int[] arr = {11, 33, 33, 11, 33, 11, 5, 5};

        System.out.println("=== MAJORITY ELEMENT (> N/3) TEST ===\n");
        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Target Count: > " + (arr.length/3));

        System.out.println("\n1. Brute Force Result: " + majorityElementBrute(arr));
        System.out.println("2. Better (Hashing) Result: " + majorityElementBetter(arr));
        System.out.println("3. Optimal (Boyer-Moore) Result: " + majorityElementOptimal(arr));

        // Edge Case: Empty or small array
        int[] arr2 = {1, 2};
        System.out.println("\n--- Edge Case [1, 2] ---");
        System.out.println("Optimal Result: " + majorityElementOptimal(arr2));
    }
}