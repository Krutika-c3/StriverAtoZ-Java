package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class FourSum {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^4) | Space: O(2 * no. of quadruplets)
    // ==========================================
    public static List<List<Integer>> fourSumBrute(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        // 4 Nested Loops
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // Use long to prevent integer overflow
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // ==========================================
    // 2. BETTER APPROACH (HASHING)
    // Time: O(N^3) | Space: O(N) + O(quadruplets)
    // ==========================================
    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // HashSet stores elements between j and current k
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add((int) fourth);
                        temp.add(nums[k]);

                        // Sort to handle duplicates correctly in the Set
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    // Add current k to hashset for future iterations
                    hashset.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    // ==========================================
    // 3. OPTIMAL APPROACH (TWO POINTERS)
    // Time: O(N^3) | Space: O(1)
    // ==========================================
    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Two pointers
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);

                        k++;
                        l--;

                        // Skip duplicates for k and l
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum < target) {
                        k++;
                    }
                    else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("--------------------------------------------------");

        // 1. Brute Force
        System.out.println("1. Brute Force Result: " + fourSumBrute(nums, target));

        // 2. Better Approach
        System.out.println("2. Better Result:      " + fourSumBetter(nums, target));

        // 3. Optimal Approach
        // Note: Sorts the array in place, so passed as a clone if we wanted to preserve order for previous methods
        // but since we are running sequentially and Brute/Better don't rely on sorted order (internally), it's fine.
        // However, for strict testing, we pass a clone or re-initialize.
        int[] numsOptimal = nums.clone();
        System.out.println("3. Optimal Result:     " + fourSumOptimal(numsOptimal, target));
    }
}