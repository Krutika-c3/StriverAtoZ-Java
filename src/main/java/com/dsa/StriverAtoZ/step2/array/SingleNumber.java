package com.dsa.StriverAtoZ.step2.array;

import java.util.*;

public class SingleNumber {

    // ---------------------------------------------------------
    // 1. Brute Force Approach
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int getSingleElementBrute(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == num) cnt++;
            }
            if (cnt == 1) return num;
        }
        return -1;
    }

    // ---------------------------------------------------------
    // 2. Better Approach (Using Hashing)
    // Time Complexity: O(N + MaxElement) | Space Complexity: O(MaxElement)
    // ---------------------------------------------------------
    public static int getSingleElementBetter(int[] arr) {
        int n = arr.length;
        // Find max element for array sizing
        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1) return arr[i];
        }
        return -1;
    }

    // ---------------------------------------------------------
    // 3. Optimal Approach (XOR)
    // Time Complexity: O(N) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int getSingleElementOptimal(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};

        System.out.println("Brute Force: " + getSingleElementBrute(arr));
        System.out.println("Better (Hash): " + getSingleElementBetter(arr));
        System.out.println("Optimal (XOR): " + getSingleElementOptimal(arr));
    }
}
