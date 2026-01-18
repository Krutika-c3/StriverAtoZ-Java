package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionArrays {

    // Brute Force Approach
    // Time Complexity: O(N1 * N2) | Space Complexity: O(N2)
    public static List<Integer> intersectionBrute(int[] arr1, int[] arr2, int n, int m) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) {
                    ans.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i]) break;
            }
        }
        return ans;
    }

    // Optimal Approach (Two Pointers)
    // Time Complexity: O(N1 + N2) | Space Complexity: O(1)
    public static List<Integer> intersectionOptimal(int[] arr1, int[] arr2, int n, int m) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 3, 5, 6, 6, 7};

        System.out.println("Array 1: " + java.util.Arrays.toString(arr1));
        System.out.println("Array 2: " + java.util.Arrays.toString(arr2));

        System.out.println("Brute Approach: ");
        List<Integer> intersection1 = intersectionBrute(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Intersection: " + intersection1);

        System.out.println("Optimal Approach: ");
        List<Integer> intersection2 = intersectionOptimal(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Intersection: " + intersection2);
    }
}