package com.dsa.striver_a_to_z.step2.array;

public class RotateImage {

    // ==========================================
    // Approach 1: Brute Force (Using Dummy Matrix)
    // Time: O(N*N), Space: O(N*N)
    // ==========================================
    public static void rotateBruteForce(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        // 1. Calculate new positions in a temporary array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        // 2. Copy back to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    // ==========================================
    // Approach 2: Optimal (Transpose + Reverse)
    // Time: O(N*N), Space: O(1)
    // ==========================================
    public static void rotateOptimal(int[][] matrix) {
        int n = matrix.length;

        // 1. Transpose the matrix
        // (Swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse every row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    // Helper method to reverse a single 1D array (row)
    private static void reverseRow(int[] row) {
        int start = 0;
        int end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }

    // Helper method to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Data
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Create a copy for the second approach so we start fresh
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix1);

        System.out.println("\n--- Brute Force Approach ---");
        rotateBruteForce(matrix1);
        printMatrix(matrix1);

        System.out.println("\n--- Optimal Approach (In-Place) ---");
        rotateOptimal(matrix2);
        printMatrix(matrix2);
    }
}