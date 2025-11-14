package com.dsa.StriverAtoZ.step1.lec5;


/*
 * Calculate factorial of N using recursion.
 *
 * Mathematical Definition:
 * N! = N × (N-1)!
 * Base Case: 1! = 1
 *
 * Example:
 * 5! = 5 × 4 × 3 × 2 × 1 = 120
 *
 * Recursion Tree (for printFactorial(5)):
 *
 * printFactorial(5)
 *   → 5 * printFactorial(4)
 *          → 4 * printFactorial(3)
 *                → 3 * printFactorial(2)
 *                      → 2 * printFactorial(1)
 *                            → returns 1 (base case)
 *
 * Now the stack unwinds:
 * printFactorial(2) returns 2 * 1 = 2
 * printFactorial(3) returns 3 * 2 = 6
 * printFactorial(4) returns 4 * 6 = 24
 * printFactorial(5) returns 5 * 24 = 120
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)   (recursion stack)
 */

public class FactorialFunction {

    private static int printFactorial(int number) {

        // Base condition: factorial of 1 is 1
        if (number == 1) {
            return 1;
        }

        // Recursive step: n * (n-1)!
        return number * printFactorial(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(printFactorial(5));   // Output: 120
    }
}
