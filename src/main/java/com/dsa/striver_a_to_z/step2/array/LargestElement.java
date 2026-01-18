package com.dsa.striver_a_to_z.step2.array;

public class LargestElement {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int findLargest(int[] arr) {
        if (arr.length == 0) return -1; // Handle empty array

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 2};
        System.out.println("Largest Element: " + findLargest(arr));
        // Expected Output: 5
    }
}
