package com.dsa.StriverAtoZ.step2.array;

public class RemoveDuplicates {

    // Time Complexity: O(N)
    // Space Complexity: O(1) - In-place modification
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        // 'i' tracks the position of the last unique element found
        int i = 0;

        // 'j' scans the array to find new unique elements
        for (int j = 1; j < arr.length; j++) {
            // Logic: If arr[j] is different from arr[i], it's a new unique number
            if (arr[j] != arr[i]) {
                i++;             // Move unique pointer forward
                arr[i] = arr[j]; // Place the new unique number there
            }
        }

        // Return the count of unique elements (index + 1)
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3};

        int k = removeDuplicates(arr);

        System.out.println("Count of unique elements: " + k); // Output: 3
        System.out.print("Modified Array (First " + k + " elements): ");
        for (int x = 0; x < k; x++) {
            System.out.print(arr[x] + " ");
        }
        // Expected Output: 1 2 3
    }
}
