package com.dsa.striver_a_to_z.step2.array;

public class CheckSorted {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static boolean isSorted(int[] arr) {
        // Iterate starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Logic: If current element is smaller than previous, the order is broken.
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] sortedArr = {1, 2, 2, 3, 4};
        int[] unsortedArr = {1, 2, 1, 3};

        System.out.println("Is sortedArr sorted? " + isSorted(sortedArr));   // Output: true
        System.out.println("Is unsortedArr sorted? " + isSorted(unsortedArr)); // Output: false
    }
}