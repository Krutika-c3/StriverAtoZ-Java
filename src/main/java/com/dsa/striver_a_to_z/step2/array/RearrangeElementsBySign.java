package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class RearrangeElementsBySign {

    // ==========================================
    // Variety 1: Equal Number of Positives and Negatives
    // ==========================================

    // Approach 1: Brute Force (Using separate lists)
    public static int[] rearrangeEqualBrute(int[] nums) {
        // Create a copy so we don't modify the original array for other tests
        int[] result = Arrays.copyOf(nums, nums.length);

        int n = result.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positives and negatives
        for (int i = 0; i < n; i++) {
            if (result[i] > 0) pos.add(result[i]);
            else neg.add(result[i]);
        }

        // Place them back alternately
        for (int i = 0; i < n / 2; i++) {
            result[2 * i] = pos.get(i);
            result[2 * i + 1] = neg.get(i);
        }

        return result;
    }

    // Approach 2: Optimal (1-Pass using pointers)
    public static int[] rearrangeEqualOptimal(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return ans;
    }

    // ==========================================
    // Variety 2: Unequal Number of Positives and Negatives
    // ==========================================

    // Approach: Segregate and Append Leftovers
    public static int[] rearrangeUnequal(int[] input) {
        // Create a copy to keep original array clean
        int[] nums = Arrays.copyOf(input, input.length);

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                nums[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                nums[index] = neg.get(i);
                index++;
            }
        }
        return nums;
    }

    // ==========================================
    // Main Method
    // ==========================================
    public static void main(String[] args) {
        // Test Case 1: Equal Positives and Negatives
        int[] arr1 = {3, 1, -2, -5, 2, -4};
        System.out.println("--- Variety 1: Equal Counts ---");
        System.out.println("Original Array: " + Arrays.toString(arr1));

        // Test Brute Force
        int[] bruteResult = rearrangeEqualBrute(arr1);
        System.out.println("Result (Brute Force): " + Arrays.toString(bruteResult));

        // Test Optimal
        int[] optimalResult = rearrangeEqualOptimal(arr1);
        System.out.println("Result (Optimal):     " + Arrays.toString(optimalResult));


        System.out.println("\n--- Variety 2: Unequal Counts ---");

        // Test Case 2: More Positives
        int[] arr2 = {1, 2, -4, -5, 3, 6};
        System.out.println("Original Array (More Positives): " + Arrays.toString(arr2));
        System.out.println("Result: " + Arrays.toString(rearrangeUnequal(arr2)));

        // Test Case 3: More Negatives
        int[] arr3 = {-1, -2, 3, 4, -3, -8};
        System.out.println("\nOriginal Array (More Negatives): " + Arrays.toString(arr3));
        System.out.println("Result: " + Arrays.toString(rearrangeUnequal(arr3)));
    }
}