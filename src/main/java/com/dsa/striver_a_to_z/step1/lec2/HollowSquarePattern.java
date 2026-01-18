package com.dsa.striver_a_to_z.step1.lec2;

public class HollowSquarePattern {
    private static void pattern(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // Print '*' for boundary cells (first row, last row, first col, last col)
                if (i == 1 || j == 1 || j == n || i == n) {
                    System.out.print("*");
                }
                // Otherwise, print space for inner cells
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }
}
