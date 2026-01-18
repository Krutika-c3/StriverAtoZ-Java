package com.dsa.striver_a_to_z.step1.lec2;

public class HollowXPattern {
    private static void pattern(int n) {
        int inis = 2 * n - 2;

        // ---------------- Top half ----------------
        for (int i = 0; i < n; i++) {
            // Left stars
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }

            // Right stars
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }

            inis -= 2; // Decrease spaces as we go down
            System.out.println();
        }

        // Reset spaces for bottom half
        inis = 2;

        // ---------------- Bottom half ----------------
        for (int i = n; i > 1; i--) {
            // Left stars
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int j = 1; j <= inis; j++) {
                System.out.print(" ");
            }

            // Right stars
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("*");
            }

            inis += 2; // Increase spaces as we go down
            System.out.println();
        }
    }

    private static void patternStriver(int n) {
        int spaces = 2 * n - 2;

        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;

            // After the middle row, stars start decreasing
            if (i > n) {
                stars = 2 * n - i;
            }

            // Left stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            // Spaces in the middle
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Right stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();

            // Adjust spaces: shrink till middle, then expand
            if (i < n) {
                spaces -= 2;
            } else {
                spaces += 2;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n);
        System.out.println("------------------");
        patternStriver(n);
    }
}
