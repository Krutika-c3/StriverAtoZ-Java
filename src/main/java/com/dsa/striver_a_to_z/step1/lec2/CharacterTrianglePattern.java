package com.dsa.striver_a_to_z.step1.lec2;

public class CharacterTrianglePattern {
    private static void trianglePattern(int n) {
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            char ch = (char) ('A' + (2 * i - 2));
            for (char k = 'A'; k <= ch; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        trianglePattern(n);
    }
}
