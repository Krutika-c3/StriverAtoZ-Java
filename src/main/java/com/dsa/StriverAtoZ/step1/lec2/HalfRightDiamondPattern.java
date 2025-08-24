package com.dsa.StriverAtoZ.step1.lec2;

public class HalfRightDiamondPattern {
    private static void diamondPattern(int n) {
        // Top half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Bottom half (start from n-1 to avoid duplicate middle row)
        for (int i = 1; i <= n - 1; i++) {
            int stars = n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void simpleDiamondPattern(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n) {
                stars = 2 * n - i;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        diamondPattern(n);
        System.out.println("------------------");
        simpleDiamondPattern(n);
    }
}

