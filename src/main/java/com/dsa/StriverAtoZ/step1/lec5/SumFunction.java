package com.dsa.StriverAtoZ.step1.lec5;


/*
 * Calculate the sum of first N numbers using
 *           Functional Recursion (return-based recursion).
 *
 * Idea:
 * - Instead of passing the sum as a parameter (parameterized recursion),
 *   this method returns partial sums and builds the final answer
 *   during the unwinding phase of recursion.
 *
 * Base Case:
 *   If number == 0 → return 0
 *
 * Recursive Case:
 *   return number + printSumFunc(number - 1)
 *
 * Example Call Flow (for printSumFunc(5)):
 *
 * printSumFunc(5)
 *   → 5 + printSumFunc(4)
 *
 *       printSumFunc(4)
 *       → 4 + printSumFunc(3)
 *
 *           printSumFunc(3)
 *           → 3 + printSumFunc(2)
 *
 *               printSumFunc(2)
 *               → 2 + printSumFunc(1)
 *
 *                   printSumFunc(1)
 *                   → 1 + printSumFunc(0)
 *
 *                       printSumFunc(0)
 *                       → returns 0 (base case)
 *
 * Now recursion unwinds and computes:
 *
 * printSumFunc(1) = 1 + 0  = 1
 * printSumFunc(2) = 2 + 1  = 3
 * printSumFunc(3) = 3 + 3  = 6
 * printSumFunc(4) = 4 + 6  = 10
 * printSumFunc(5) = 5 + 10 = 15
 *
 * Output:
 * 15
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)  (due to recursion stack)
 */
public class SumFunction {

    private static int printSumFunc(int number) {

        // Base Condition
        if (number == 0) {
            return 0;
        }

        // Recursive call + adding current number
        return number + printSumFunc(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(printSumFunc(5));
    }
}
