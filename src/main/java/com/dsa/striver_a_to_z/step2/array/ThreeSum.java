package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class ThreeSum {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^3) | Space: O(2 * Unique Triplets)
    // ==========================================
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }

    // ==========================================
    // 2. BETTER APPROACH (HASHING)
    // Time: O(N^2) | Space: O(N)
    // ==========================================
    public static List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);

                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    st.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }

    // ==========================================
    // 3. OPTIMAL APPROACH (TWO POINTERS)
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Crucial Step

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for i

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        System.out.println("Input Array: " + Arrays.toString(arr));

        // 1. Brute Force
        System.out.println("Brute Force: " + threeSumBrute(arr));

        // 2. Better
        System.out.println("Better (Hashing): " + threeSumBetter(arr));

        // 3. Optimal (We clone array to avoid sorting it for other methods if order mattered,
        // but here brute/better don't depend on sort, though optimal modifies it in-place)
        int[] arrForOptimal = arr.clone();
        System.out.println("Optimal (Two Pointer): " + threeSumOptimal(arrForOptimal));
    }
}