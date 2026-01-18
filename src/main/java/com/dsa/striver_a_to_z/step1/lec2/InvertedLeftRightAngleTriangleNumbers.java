package com.dsa.striver_a_to_z.step1.lec2;

public class InvertedLeftRightAngleTriangleNumbers {

    private static void trianglePatternUsingPositiveOuterLoop(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePatternUsingPositiveOuterLoop(n);
    }

}
