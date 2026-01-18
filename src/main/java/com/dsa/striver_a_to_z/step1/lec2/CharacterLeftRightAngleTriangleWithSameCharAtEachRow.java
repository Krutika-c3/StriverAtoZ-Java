package com.dsa.striver_a_to_z.step1.lec2;

public class CharacterLeftRightAngleTriangleWithSameCharAtEachRow {
    private static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            // Select the character for this row
            char ch = (char) ('A' + i);
            // Inner loop prints the character (i+1) times
            for (int j = 0; j <= i; j++) {
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