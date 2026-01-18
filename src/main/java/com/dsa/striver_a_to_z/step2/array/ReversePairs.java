package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePairs {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static int reversePairsBrute(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2L * nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // ==========================================
    // 2. OPTIMAL APPROACH (MERGE SORT)
    // Time: O(N log N) | Space: O(N)
    // ==========================================
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Merge two sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) temp.add(arr[left++]);
        while (right <= high) temp.add(arr[right++]);

        for (int i = 0; i < temp.size(); i++) {
            arr[low + i] = temp.get(i);
        }
    }

    private static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            // Count valid pairs (arr[i] > 2 * arr[right])
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;

        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);

        // Count before merge
        cnt += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);
        return cnt;
    }

    public static int reversePairsOptimal(int[] nums) {
        // Use a clone to preserve the original array if needed
        return mergeSort(nums, 0, nums.length - 1);
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1}; // Expected: 2 -> (3, 1), (3, 1)

        System.out.println("Input Array: " + Arrays.toString(arr));

        // Brute Force
        System.out.println("Brute Force Count: " + reversePairsBrute(arr));

        // Optimal (Note: this modifies the array due to sorting)
        // Passing a clone to ensure subsequent tests (if any) use fresh data
        int[] arrForOptimal = arr.clone();
        System.out.println("Optimal Count: " + reversePairsOptimal(arrForOptimal));
    }
}
