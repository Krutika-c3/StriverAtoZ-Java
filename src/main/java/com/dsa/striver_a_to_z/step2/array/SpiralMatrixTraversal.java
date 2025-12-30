package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {

    // ==========================================
    // Optimal Approach: Simulation
    // Time: O(N*M), Space: O(N*M) for output
    // ==========================================
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;      // rows
        int m = matrix[0].length;   // columns

        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;

        while (top <= bottom && left <= right) {

            // 1. Move from Left to Right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // Top row is processed

            // 2. Move from Top to Bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // Right column is processed

            // 3. Move from Right to Left
            // Check if there are rows remaining
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // Bottom row is processed
            }

            // 4. Move from Bottom to Top
            // Check if there are columns remaining
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; // Left column is processed
            }
        }

        return ans;
    }

    // Helper method to print the matrix for visualization
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                // Formatting for better alignment
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Data: 4x4 Matrix
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Calculate Spiral Order
        List<Integer> result = spiralOrder(matrix);

        System.out.println("\nSpiral Order Traversal:");
        System.out.println(result);
    }
}