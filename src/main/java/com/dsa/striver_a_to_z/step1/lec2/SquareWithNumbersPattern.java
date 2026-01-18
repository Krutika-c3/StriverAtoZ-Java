package com.dsa.striver_a_to_z.step1.lec2;

/**
 * SquareWithNumbersPattern
 * <p>
 * This program prints a square pattern of numbers in concentric layers.
 * <p>
 * Example for n = 4:
 * <p>
 * 4 4 4 4 4 4 4
 * 4 3 3 3 3 3 4
 * 4 3 2 2 2 3 4
 * 4 3 2 1 2 3 4
 * 4 3 2 2 2 3 4
 * 4 3 3 3 3 3 4
 * 4 4 4 4 4 4 4
 * <p>
 * ---------------------------
 * LOGIC / THEORY:
 * ---------------------------
 * 1. The square has size (2n - 1) x (2n - 1).
 * 2. The outermost layer is filled with 'n'.
 * 3. Moving one step inside reduces the number by 1, until the center which is always '1'.
 * 4. For each cell (i, j), its value depends on how far it is from the nearest border.
 * - Distance from top    = i
 * - Distance from left   = j
 * - Distance from right  = (2n - 2) - j
 * - Distance from bottom = (2n - 2) - i
 * 5. The minimum of these distances = how deep the cell is inside.
 * 6. Formula for cell value:
 * value = n - minDist
 * where minDist = min(top, left, right, bottom).
 * <p>
 * This ensures:
 * - Outermost border → value = n
 * - Next border → value = n - 1
 * - Next → value = n - 2
 * - Center → value = 1
 * <p>
 * Thus, the square is built as concentric layers of decreasing numbers.
 */
public class SquareWithNumbersPattern {

    // Method to print concentric number square
    private static void pattern(int n) {
        // Loop for each row
        for (int i = 0; i < 2 * n - 1; i++) {
            // Loop for each column
            for (int j = 0; j < 2 * n - 1; j++) {
                // Distances from each border
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int down = (2 * n - 2) - i;

                // Take the minimum distance from any side
                int minDist = Math.min(Math.min(top, down), Math.min(left, right));

                // Number decreases as we move inside
                System.out.print((n - minDist) + " ");
            }
            System.out.println(); // new line after each row
        }
    }

    public static void main(String[] args) {
        int n = 4;
        pattern(n);
    }
}