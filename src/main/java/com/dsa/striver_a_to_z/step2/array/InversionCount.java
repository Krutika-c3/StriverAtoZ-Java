package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionCount {

    // ==========================================
    // 1. BRUTE FORCE APPROACH
    // Time: O(N^2) | Space: O(1)
    // ==========================================
    public static int countInversionsBrute(int[] a) {
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
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
    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[low + i] = temp.get(i);
        }
        return cnt;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;

        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public static int countInversionsOptimal(int[] a) {
        // We clone to keep original array safe if needed, though here we just sort it.
        // int[] arrCopy = a.clone();
        return mergeSort(a, 0, a.length - 1);
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};

        System.out.println("Input Array: " + Arrays.toString(arr));

        // Brute Force
        int countBrute = countInversionsBrute(arr);
        System.out.println("Brute Force Count: " + countBrute);

        // Optimal - Note: This sorts the array in place!
        // We pass a clone to demonstrate, though the function signature uses 'arr'
        int[] arrForOptimal = arr.clone();
        int countOptimal = countInversionsOptimal(arrForOptimal);
        System.out.println("Optimal Count: " + countOptimal);
    }
}