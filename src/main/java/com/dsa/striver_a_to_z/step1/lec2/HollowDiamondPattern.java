package com.dsa.striver_a_to_z.step1.lec2;

public class HollowDiamondPattern {
    private static void pattern(int n) {
        for (int i = 0; i < 2 * n; i++) {

            if (i < n) {  // top half
                for (int stars1 = n - i; stars1 >= 1; stars1--) {
                    System.out.print("*");
                }

                for (int spaces = 0; spaces < 2 * i; spaces++) {
                    System.out.print(" ");
                }

                for (int stars2 = n - i; stars2 >= 1; stars2--) {
                    System.out.print("*");
                }
            } else {  // bottom half
                int j = i - n; // bottom half row index (0 to n-1)

                for (int stars1 = 0; stars1 <= j; stars1++) {
                    System.out.print("*");
                }

                for (int spaces = 0; spaces < 2 * (n - j - 1); spaces++) {
                    System.out.print(" ");
                }

                for (int stars2 = 0; stars2 <= j; stars2++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    private static void patternIfElse(int n) {
        // Total rows = 2 * n (upper half + lower half)
        for (int i = 0; i < 2 * n; i++) {
            int stars;
            int spaces;

            if (i < n) {
                // ---------------- Top half ----------------
                // Number of stars decreases as we move down
                // Row 0 -> n stars, Row 1 -> n-1 stars, ...
                stars = n - i;

                // Number of spaces increases as we move down
                // Row 0 -> 0 spaces, Row 1 -> 2 spaces, Row 2 -> 4 spaces ...
                spaces = 2 * i;
            } else {
                // ---------------- Bottom half ----------------
                // Row index for bottom part (starts again from 0 at middle)
                // Example: if n=5, then i=5 -> bottomRow=0, i=6 -> bottomRow=1 ...
                int bottomRow = i - n;

                // Number of stars increases again in bottom half
                // Row 5 -> 1 star, Row 6 -> 2 stars, Row 7 -> 3 stars ...
                stars = bottomRow + 1;

                // Spaces decrease as we go down in bottom half
                // Formula ensures symmetry with top half
                spaces = 2 * (n - bottomRow - 1);
                // equivalently: spaces = 2 * (2 * n - i - 1);
            }

            // -------- Print the row --------

            // Left stars
            for (int s = 0; s < stars; s++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int sp = 0; sp < spaces; sp++) {
                System.out.print(" ");
            }

            // Right stars
            for (int s = 0; s < stars; s++) {
                System.out.print("*");
            }

            // Move to next row
            System.out.println();
        }
    }

    static void patternStriver(int n) {
        int inis = 0;

        // ---------------- Top half ----------------
        for (int i = 0; i < n; i++) {
            // Left stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }

            // Right stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }

            inis += 2; // Increase spaces as we go down
            System.out.println();
        }

        // Reset spaces for bottom half
        inis = 2 * n - 2;

        // ---------------- Bottom half ----------------
        for (int i = 1; i <= n; i++) {
            // Left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Middle spaces
            for (int j = 0; j < inis; j++) {
                System.out.print(" ");
            }

            // Right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            inis -= 2; // Decrease spaces as we go down
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n);
        System.out.println("------------------");
        patternIfElse(n);
        System.out.println("------------------");
        patternStriver(n);
    }
}
