package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class LeadersInArray {

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(N^2)
     * Space Complexity: O(N) (for storing result)
     */
    public static List<Integer> printLeadersBruteForce(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean leader = true;

            // Check all elements to the right of current element
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    /**
     * Approach 2: Optimal Approach
     * Time Complexity: O(N)
     * Space Complexity: O(N) (for storing result)
     */
    public static List<Integer> printLeadersOptimal(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Initialize with minimum possible value
        int maxFromRight = Integer.MIN_VALUE;

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If the current element is strictly greater than the max seen so far on its right
            if (nums[i] > maxFromRight) {
                ans.add(nums[i]);
                maxFromRight = nums[i]; // Update the max
            }
        }

        // Since we collected leaders from right to left, reverse the list
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard Example
        int[] arr1 = {10, 22, 12, 3, 0, 6};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Brute Force Result: " + printLeadersBruteForce(arr1));
        System.out.println("Optimal Result:     " + printLeadersOptimal(arr1));

        System.out.println("-------------------------");

        // Test Case 2: Strictly Decreasing (All elements are leaders)
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Brute Force Result: " + printLeadersBruteForce(arr2));
        System.out.println("Optimal Result:     " + printLeadersOptimal(arr2));

        System.out.println("-------------------------");

        // Test Case 3: Strictly Increasing (Only the last element is a leader)
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Brute Force Result: " + printLeadersBruteForce(arr3));
        System.out.println("Optimal Result:     " + printLeadersOptimal(arr3));
    }
}