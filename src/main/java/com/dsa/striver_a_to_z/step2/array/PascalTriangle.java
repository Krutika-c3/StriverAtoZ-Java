package com.dsa.striver_a_to_z.step2.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // ==========================================
    // HELPER FUNCTIONS
    // ==========================================

    // Calculates nCr efficiently: n! / (r! * (n-r)!)
    public static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Helper to generate a specific row using the optimal formula
    // Time: O(N), Space: O(1)
    public static List<Integer> generateSingleRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // First element

        // 1-based indexing logic adapted for loop
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    // ==========================================
    // VARIATION 1: FIND ELEMENT AT (R, C)
    // ==========================================
    public static long getElementAt(int r, int c) {
        // Formula: (r-1)C(c-1)
        return nCr(r - 1, c - 1);
    }

    // ==========================================
    // VARIATION 2: PRINT NTH ROW
    // ==========================================
    public static void printNthRow(int n) {
        System.out.print("Row " + n + ": ");
        List<Integer> row = generateSingleRow(n);
        for (int val : row) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // ==========================================
    // VARIATION 3: GENERATE TRIANGLE (SIMULATION)
    // ==========================================
    public static List<List<Integer>> generateTriangleSimulation(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1);
            result.add(currentRow);
        }
        return result;
    }

    // ==========================================
    // HIDDEN PATTERNS
    // ==========================================

    // Pattern 1: Sum of Row N is 2^N
    public static long getRowSum(int rowIndex) {
        return 1L << rowIndex; // Bitwise shift for power of 2
    }

    // Pattern 2: Perfect Squares in Column 2 (Index 2)
    // Sum of adjacent elements in col 2 often equals a square (e.g., 3+6=9)
    public static void checkSquareProperty(int rowIndex) {
        List<Integer> row1 = generateSingleRow(rowIndex);
        List<Integer> row2 = generateSingleRow(rowIndex + 1);

        if (row1.size() > 2 && row2.size() > 2) {
            int val1 = row1.get(2);
            int val2 = row2.get(2);
            int sum = val1 + val2;
            System.out.println("Property Check (Rows " + rowIndex + "&" + (rowIndex+1) + "): "
                    + val1 + " + " + val2 + " = " + sum
                    + " (Is Perfect Square? " + (Math.sqrt(sum) % 1 == 0) + ")");
        } else {
            System.out.println("Rows too small to check Square Property.");
        }
    }

    // Pattern 3: Fibonacci from Diagonals
    public static int getFibonacciFromPascal(int n) {
        List<List<Integer>> triangle = generateTriangleSimulation(n + 1);
        int sum = 0;
        // Trace diagonal
        for (int k = 0; k <= n / 2; k++) {
            int row = n - k;
            int col = k;
            if (row < triangle.size() && col < triangle.get(row).size()) {
                sum += triangle.get(row).get(col);
            }
        }
        return sum;
    }

    // ==========================================
    // MAIN DRIVER
    // ==========================================
    public static void main(String[] args) {
        System.out.println("=== PASCAL'S TRIANGLE ===\n");

        // 1. Find Element
        int r = 5;
        int c = 3;
        System.out.println("1. Element at (5, 3): " + getElementAt(r, c));

        // 2. Print Nth Row
        System.out.println("\n2. Print Specific Row:");
        printNthRow(6);

        // 3. Generate Triangle
        System.out.println("\n3. Generated Triangle (First 5 Rows):");
        List<List<Integer>> triangle = generateTriangleSimulation(5);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }

        // 4. Patterns
        System.out.println("\n4. Hidden Patterns:");
        System.out.println("   - Row Sum (Row 4): " + getRowSum(4)); // Should be 16
        System.out.println("   - Fibonacci (Diagonal 4): " + getFibonacciFromPascal(4)); // Should be 5

        System.out.print("   - ");
        checkSquareProperty(4); // Checks 3rd column of row 4 and 5
    }
}