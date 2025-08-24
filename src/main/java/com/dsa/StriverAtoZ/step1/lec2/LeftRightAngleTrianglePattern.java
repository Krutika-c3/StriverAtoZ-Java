package com.dsa.StriverAtoZ.step1.lec2;

public class LeftRightAngleTrianglePattern {
    private static void trianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
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
