package com.dsa.striver_a_to_z.step1.lec2;

public class DiamondPattern {
    private static void diamondPattern(int n) {
        // Top half
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            int stars = 2 * i - 1;
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Bottom half (starst from n-1 to avoid duplicate middle row)
        for (int i = n - 1; i >= 1; i--) {
            int spaces = n - i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            int stars = 2 * i;
            for (int k = 1; k <= stars - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        diamondPattern(n);
    }
}

