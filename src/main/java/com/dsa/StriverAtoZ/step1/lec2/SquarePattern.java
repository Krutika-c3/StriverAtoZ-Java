package com.dsa.StriverAtoZ.step1.lec2;

public class SquarePattern {

    private static void perfectSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        // Print square pattern of size n
        perfectSquare(n);
    }
}
