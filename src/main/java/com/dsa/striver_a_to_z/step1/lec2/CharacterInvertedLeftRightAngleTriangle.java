package com.dsa.striver_a_to_z.step1.lec2;

public class CharacterInvertedLeftRightAngleTriangle {
    private static void pattern(int n) {
        for (int i = n; i >= 1; i--) {
            /*
             * - Starts at 'A' (ASCII value 65).
             * - Runs until 'A' + (i - 1).
             * - Example:
             *      i = n (say n=5) → ch = 'A' to 'E' → prints A B C D E
             *      i = 4 → ch = 'A' to 'D' → prints A B C D
             *      i = 3 → ch = 'A' to 'C' → prints A B C
             *      i = 2 → ch = 'A' to 'B' → prints A B
             *      i = 1 → ch = 'A' to 'A' → prints A
             *
             * - Each iteration increments ch by 1 ('A' → 'B' → 'C' …).
             */
            for (char ch = 'A'; ch <= 'A' + i - 1; ch++) {
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