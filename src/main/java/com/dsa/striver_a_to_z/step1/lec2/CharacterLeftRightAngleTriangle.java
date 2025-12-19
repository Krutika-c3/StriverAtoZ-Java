package com.dsa.striver_a_to_z.step1.lec2;

public class CharacterLeftRightAngleTriangle {
    private static void pattern(int n) {
        for (int i = 0; i < n; i++) {

            // Inner loop -> prints characters for the current row
            // 'A' is the starting character in ASCII (65)
            // For row i, we go from 'A' up to 'A' + i
            // Example: i=0 → 'A' to 'A' (prints A)
            //          i=1 → 'A' to 'B' (prints A B)
            //          i=2 → 'A' to 'C' (prints A B C)
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }
}