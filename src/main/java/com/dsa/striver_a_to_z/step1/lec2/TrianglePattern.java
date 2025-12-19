package com.dsa.striver_a_to_z.step1.lec2;

public class TrianglePattern {
    private static void trianglePattern(int n) {
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
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePattern(n);
    }
}
