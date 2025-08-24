package com.dsa.StriverAtoZ.step1.lec2;

public class ZeroOnePattern {

    private static void trianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // Condition: if sum of row and column index is even -> print 1, else print 0
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePattern(n);
    }
}
