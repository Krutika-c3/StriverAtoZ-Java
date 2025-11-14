package com.dsa.StriverAtoZ.step1.lec5;

/*
 * Calculate the sum of first N numbers using recursion
 *           (Parameterised Recursion approach).
 *
 * How Parameterised Recursion Works:
 * - We pass the accumulating result (sum) as a parameter.
 * - When the base condition is reached, we print the final result.
 *
 * Example Call Flow (for printSumParam(1, 5, 0)):
 *
 * printSumParam(1,5,0)
 *   → sum = 0 + 1 = 1
 *   → printSumParam(2,5,1)
 *
 *       → sum = 1 + 2 = 3
 *       → printSumParam(3,5,3)
 *
 *           → sum = 3 + 3 = 6
 *           → printSumParam(4,5,6)
 *
 *               → sum = 6 + 4 = 10
 *               → printSumParam(5,5,10)
 *
 *                   → sum = 10 + 5 = 15
 *                   → printSumParam(6,5,15)
 *
 * Base Condition Hits (counter = 6 > 5):
 * → print 15
 *
 * Output:
 * 15
 *
 * Time Complexity  : O(n)   (each number from 1 to n is processed once)
 * Space Complexity : O(n)   (recursion stack)
 */

public class SumParameter {

    private static void printSumParam(int counter, int number, int sum) {

        // Base Condition
        if (counter > number) {
            System.out.println(sum);  // Print final accumulated sum
            return;
        }

        // Accumulate sum
        sum = sum + counter;

        // Recursive call with updated parameters
        printSumParam(counter + 1, number, sum);
    }

    public static void main(String[] args) {
        printSumParam(1, 5, 0);
    }
}
