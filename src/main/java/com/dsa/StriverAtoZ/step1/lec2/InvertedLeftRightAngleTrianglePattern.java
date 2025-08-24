package com.dsa.StriverAtoZ.step1.lec2;

public class InvertedLeftRightAngleTrianglePattern {
    private static void trianglePatternUsingNegativeOuterLoop(int n) {
        for (int i = n; i >= 1; i--) {
            int stars = n - i + 1;
            for (int j = n; j >= stars; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void trianglePatternUsingPositiveOuterLoop(int n) {
        for (int i = 1; i <= n; i++) {
            int stars = n - i + 1;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePatternUsingNegativeOuterLoop(n);
        System.out.println("------------------");
        trianglePatternUsingPositiveOuterLoop(n);
    }
}
