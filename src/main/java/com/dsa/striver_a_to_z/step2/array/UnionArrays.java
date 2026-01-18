package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class UnionArrays {

    // Brute Force Approach
    // Time Complexity: O(N logN) | Space Complexity: O(N)
    public static List<Integer> findUnionBrute(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr1) set.add(i);
        for (int i : arr2) set.add(i);
        return new ArrayList<>(set);
    }

    // Optimal Approach (Two Pointers)
    // Time Complexity: O(N1 + N2) | Space Complexity: O(1) (excluding return list)
    public static List<Integer> findUnionOptimal(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;
        List<Integer> unionList = new ArrayList<>();

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                    unionList.add(arr1[i]);
                }
                i++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
                    unionList.add(arr2[j]);
                }
                j++;
            }
        }

        // Process remaining elements of arr1
        while (i < n) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
                unionList.add(arr1[i]);
            }
            i++;
        }

        // Process remaining elements of arr2
        while (j < m) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
                unionList.add(arr2[j]);
            }
            j++;
        }

        return unionList;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5, 6};

        System.out.println("Array 1: " + java.util.Arrays.toString(arr1));
        System.out.println("Array 2: " + java.util.Arrays.toString(arr2));

        System.out.println("Brute Approach: ");
        List<Integer> union1 = findUnionBrute(arr1, arr2);
        System.out.println("Union:   " + union1);

        System.out.println("Optimal Approach: ");
        List<Integer> union2 = findUnionOptimal(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Union:   " + union2);
    }
}