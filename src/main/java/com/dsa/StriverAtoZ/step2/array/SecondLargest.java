package com.dsa.StriverAtoZ.step2.array;

public class SecondLargest {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int findSecondLargest(int[] arr) {
        int n = arr.length;
        if (n < 2) return -1; // No second largest possible if size < 2

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Case 1: Found a new largest element
            if (arr[i] > largest) {
                secondLargest = largest; // Old largest becomes second
                largest = arr[i];        // Update largest
            }
            // Case 2: Found an element between largest and secondLargest
            // We check arr[i] != largest to handle duplicates (e.g., [7, 7, 5])
            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        // If secondLargest is still MIN_VALUE, it means no valid second largest exists
        // (e.g., input was [1, 1, 1])
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        System.out.println("Second Largest Element: " + findSecondLargest(arr));
        // Expected Output: 5
    }
}