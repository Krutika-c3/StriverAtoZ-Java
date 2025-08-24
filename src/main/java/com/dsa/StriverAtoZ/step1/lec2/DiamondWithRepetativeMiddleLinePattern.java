package com.dsa.StriverAtoZ.step1.lec2;

public class DiamondWithRepetativeMiddleLinePattern {
    private static void trianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
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
        for (int i = n; i >= 1; i--) {
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
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePattern(n);
    }
}
