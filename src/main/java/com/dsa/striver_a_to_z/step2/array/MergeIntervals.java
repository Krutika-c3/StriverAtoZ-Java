package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class MergeIntervals {

    // Helper method to print the result
    public static void printResult(List<List<Integer>> result) {
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[" + result.get(i).get(0) + ", " + result.get(i).get(1) + "]");
            if (i < result.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Brute Force Approach
    public static List<List<Integer>> mergeBruteForce(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    // Optimal Approach
    public static List<List<Integer>> mergeOptimal(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                int lastEnd = ans.get(ans.size() - 1).get(1);
                ans.get(ans.size() - 1).set(1, Math.max(lastEnd, arr[i][1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        // To test Brute Force, we need a fresh copy or ensure sort doesn't affect logic flow
        // Since optimal modifies the list in place, let's run them independently

        System.out.println("Input: [[1,3],[2,6],[8,10],[15,18]]");

        System.out.print("Brute Force Output: ");
        printResult(mergeBruteForce(intervals));

        System.out.print("Optimal Output: ");
        printResult(mergeOptimal(intervals));
    }
}
