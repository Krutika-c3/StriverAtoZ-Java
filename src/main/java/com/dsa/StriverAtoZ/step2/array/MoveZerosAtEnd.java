package com.dsa.StriverAtoZ.step2.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosAtEnd {

    // Brute Force Approach
    // Time Complexity: O(2N) | Space Complexity: O(N)
    public static void moveZerosBrute(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : arr) {
            if (i != 0) temp.add(i);
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        for (int i = temp.size(); i < n; i++) {
            arr[i] = 0;
        }
    }

    // Optimal Approach (Two Pointers)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public static void moveZerosOptimal(int[] arr, int n) {
        int j = -1;
        // Find first zero
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;

        // Move non-zeros forward
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Brute Approach: ");
        int[] arr1 = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        System.out.println("Original: " + Arrays.toString(arr1));
        moveZerosBrute(arr1, arr1.length);
        System.out.println("Zeros Moved: " + Arrays.toString(arr1));

        System.out.println("Optimal Approach: ");
        int[] arr2 = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        System.out.println("Original: " + Arrays.toString(arr2));
        moveZerosOptimal(arr2, arr2.length);
        System.out.println("Zeros Moved: " + Arrays.toString(arr2));
    }
}