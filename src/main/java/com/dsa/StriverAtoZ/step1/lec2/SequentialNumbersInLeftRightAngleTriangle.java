package com.dsa.StriverAtoZ.step1.lec2;

public class SequentialNumbersInLeftRightAngleTriangle {
    private static void trianglePattern(int n) {
        int numbers = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(numbers++ + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePattern(n);
    }
}
