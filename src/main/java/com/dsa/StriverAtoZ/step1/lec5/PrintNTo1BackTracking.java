package com.dsa.StriverAtoZ.step1.lec5;


/*
 * Print numbers from N down to 1 using recursion.
 *
 * Example Call Flow (for printNumbers(1,5)):
 *
 * printNumbers(1,5)
 *   → printNumbers(2,5)
 *       → printNumbers(3,5)
 *           → printNumbers(4,5)
 *               → printNumbers(5,5)
 *                   → printNumbers(6,5)  // base condition triggers
 *
 * After base condition, recursion unwinds (returns backward):
 *
 * printNumbers(5,5) → prints 5
 * printNumbers(4,5) → prints 4
 * printNumbers(3,5) → prints 3
 * printNumbers(2,5) → prints 2
 * printNumbers(1,5) → prints 1
 *
 * This produces:
 * 5
 * 4
 * 3
 * 2
 * 1
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)   (due to recursion stack)
 */

public class PrintNTo1BackTracking {

    private static void printNumbers(int counter, int number) {

        // Base Condition:
        // When counter becomes greater than number, stop recursion.
        if (counter > number) {
            return;
        }

        // Recursive call first:
        // This pushes deeper calls onto the stack.
        printNumbers(counter + 1, number);

        /*
         * Print while coming back (unwinding stack).
         * This reverses the order of output.
         */
        System.out.println(counter);
    }

    public static void main(String[] args) {
        printNumbers(1, 5);  // Output: 5 4 3 2 1
    }
}
