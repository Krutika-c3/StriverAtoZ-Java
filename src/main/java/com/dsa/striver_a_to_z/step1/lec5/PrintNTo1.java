package com.dsa.striver_a_to_z.step1.lec5;

/*
 * Print numbers from N down to 1 using recursion.
 *
 * Example Call Flow (for printNumbers(5,1)):
 *
 * printNumbers(5,1)
 *   → printNumbers(4,1)
 *       → printNumbers(3,1)
 *           → printNumbers(2,1)
 *               → printNumbers(1,1)
 *                   → printNumbers(0,1)   // base condition triggers
 *
 * After base condition, recursion stops returning back to previous calls:
 *
 * printNumbers(1,1) → prints 1
 * printNumbers(2,1) → prints 2
 * printNumbers(3,1) → prints 3
 * printNumbers(4,1) → prints 4
 * printNumbers(5,1) → prints 5
 *
 * This produces:
 * 5
 * 4
 * 3
 * 2
 * 1
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)  // due to recursion stack
 */
public class PrintNTo1 {

    private static void printNumbers(int counter, int endCount) {

        // Base Condition: stop when counter becomes smaller than endCount
        if (counter < endCount) {
            return;
        }

        // Print the current value
        System.out.println(counter);

        // Recursive call: decrease counter toward the base condition
        printNumbers(counter - 1, endCount);
    }

    public static void main(String[] args) {
        printNumbers(5, 1);
    }
}
