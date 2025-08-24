package com.dsa.StriverAtoZ.step1.lec2;

public class CharacterLeftRightAngleTriangleWithReverseCharAtEachRow {
    private static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            // -------------------------------
            // Find the starting character for this row
            // -------------------------------
            // 'A' has ASCII value 65.
            // Formula: lastChar = 'A' + (n - i - 1)
            //
            // Row i=0 → 'A' + (5 - 0 - 1) = 'A' + 4 = 'E'
            // Row i=1 → 'A' + (5 - 1 - 1) = 'A' + 3 = 'D'
            // Row i=2 → 'A' + (5 - 2 - 1) = 'A' + 2 = 'C'
            // Row i=3 → 'A' + (5 - 3 - 1) = 'A' + 1 = 'B'
            // Row i=4 → 'A' + (5 - 4 - 1) = 'A' + 0 = 'A'
            //
            // So each new row starts one letter earlier in the alphabet.
            char lastChar = (char) ('A' + (n - i - 1));

            // -------------------------------
            // Print characters from lastChar down to 'A'
            // -------------------------------
            // Example:
            //   If lastChar = 'E' → prints: E D C B A
            //   If lastChar = 'C' → prints: C B A
            //   If lastChar = 'A' → prints: A
            for (char ch = lastChar; ch >= 'A'; ch--) {
                System.out.print(ch + " ");
            }
            System.out.println(); // Move to the next row
        }
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }
}
