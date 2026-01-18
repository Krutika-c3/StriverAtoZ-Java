package com.dsa.striver_a_to_z.step1.lec5;


/*
 * Print numbers from 1 to N using recursion + backtracking.
 *
 * KEY IDEA:
 * - We go DOWN the recursion (from N to 1), doing nothing.
 * - We print only while coming BACK UP (unwinding the stack).
 * - This is why it's called **backtracking**.
 *
 * Example Call Flow (for printNumbers(5,1)):
 *
 * printNumbers(5,1)
 *   → printNumbers(4,1)
 *       → printNumbers(3,1)
 *           → printNumbers(2,1)
 *               → printNumbers(1,1)
 *                   → printNumbers(0,1)  // base condition triggers
 *
 * Now recursion unwinds:
 *
 * printNumbers(1,1) → prints 1
 * printNumbers(2,1) → prints 2
 * printNumbers(3,1) → prints 3
 * printNumbers(4,1) → prints 4
 * printNumbers(5,1) → prints 5
 *
 * Output produced:
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n) (due to recursion stack)
 */
public class Print1ToNBackTracking {

    private static void printNumbers(int counter, int endCount) {

        // Base Condition: stop when counter becomes smaller than endCount
        if (counter < endCount) {
            return;
        }

        // FIRST do recursion (go deep)
        printNumbers(counter - 1, endCount);

        // THEN print while coming back up
        System.out.println(counter);
    }

    public static void main(String[] args) {
        printNumbers(5, 1);
    }
}
