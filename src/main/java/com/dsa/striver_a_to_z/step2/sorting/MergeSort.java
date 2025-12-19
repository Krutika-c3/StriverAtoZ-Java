package com.dsa.striver_a_to_z.step2.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * Merges two sorted subarrays into the original array.
     *
     * @param arr  The array to be sorted
     * @param low  The starting index of the left subarray
     * @param mid  The ending index of the left subarray
     * @param high The ending index of the right subarray
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        // Temporary list to store sorted elements
        List<Integer> temp = new ArrayList<>();

        int left = low;      // Starting index of left half
        int right = mid + 1; // Starting index of right half

        // --- MAIN COMPARISON LOOP ---
        // Continue the loop as long as BOTH the left and right halves have elements remaining.
        // 'left' tracks the current index in the left half (from low to mid).
        // 'right' tracks the current index in the right half (from mid+1 to high).
        while (left <= mid && right <= high) {

            // Compare the current element from the left half with the current element from the right half.
            // We want to pick the smaller of the two to ensure the merged list is sorted.
            if (arr[left] <= arr[right]) {

                // If the left element is smaller (or equal), add it to our temporary list.
                temp.add(arr[left]);

                // Move the 'left' pointer forward to look at the next element in the left half.
                left++;

            } else {

                // If the right element is smaller, add that one to the temporary list instead.
                temp.add(arr[right]);

                // Move the 'right' pointer forward to look at the next element in the right half.
                right++;
            }
        }

        // --- HANDLING LEFTOVERS ---

        // After the main comparison loop finishes, one of the halves (left or right)
        // might still have elements left over. Since the sub-arrays were already sorted,
        // we simply copy any remaining elements to the end of our temporary list.

        // CHECK LEFT HALF:
        // If the 'left' pointer hasn't passed 'mid' yet, it means there are numbers
        // remaining in the left sub-array that were larger than everything in the right sub-array.
        while (left <= mid) {
            temp.add(arr[left]); // Add the remaining left element to temp
            left++;              // Move to the next element
        }

        // CHECK RIGHT HALF:
        // If the 'right' pointer hasn't passed 'high' yet, it means there are numbers
        // remaining in the right sub-array. We append them now.
        // (Note: Only one of these two while loops will actually execute, never both).
        while (right <= high) {
            temp.add(arr[right]); // Add the remaining right element to temp
            right++;              // Move to the next element
        }

        // --- COPY BACK ---

        // Transfer sorted elements from 'temp' back to the original 'arr'.
        // We start filling 'arr' at the 'low' index specific to this recursion frame.
        for (int i = 0; i < temp.size(); i++) {
            arr[low + i] = temp.get(i);
        }
    }

    /**
     * Main recursive function to perform merge sort.
     *
     * @param arr  The array to be sorted
     * @param low  The starting index
     * @param high The ending index
     */
    public static void mergeSort(int[] arr, int low, int high) {
        // Base/Break case: If the array has 1 element (low >= high), it is already sorted.
        if (low >= high) {
            return; // go back in recursion
        }

        int mid = (low + high) / 2;

        // 1. DIVIDE: Recursively sort the left half
        mergeSort(arr, low, mid);

        // 2. DIVIDE: Recursively sort the right half
        mergeSort(arr, mid + 1, high);

        // 3. MERGE: Combine the two sorted halves
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {2, 45, 32, 5, 23};
        int n = arr.length;

        System.out.println("Before Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(arr, 0, n - 1);

        System.out.println("After Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}