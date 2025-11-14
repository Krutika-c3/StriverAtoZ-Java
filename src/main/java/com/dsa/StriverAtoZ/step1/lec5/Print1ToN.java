package com.dsa.StriverAtoZ.step1.lec5;

/*
 * Print all numbers from `counter` to `number` using recursion
 *
 * Recursion Flow:
 * printNumbers(1,5)
 *   → printNumbers(2,5)
 *       → printNumbers(3,5)
 *           → printNumbers(4,5)
 *               → printNumbers(5,5)
 *                   → printNumbers(6,5)  // base condition hits, stops
 *
 * Time Complexity  : O(n)
 * Every call prints once + makes one recursive call.
 *
 * Space Complexity : O(n)
 * Due to recursion stack (n stack frames for n calls).
 */

public class Print1ToN {

    private static void printNumbers(int counter, int number) {

        // Base Condition (stopping condition)
        // When counter becomes greater than number, stop recursion
        if (counter > number) {
            return;
        }

        // Print the number for the current call
        System.out.println(counter);

        // Recursive Call
        // We pass counter + 1 to the next call.
        printNumbers(counter + 1, number);
    }

    public static void main(String[] args) {
        printNumbers(1, 5);
    }
}
