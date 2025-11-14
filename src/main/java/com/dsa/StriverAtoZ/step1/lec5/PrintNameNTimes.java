package com.dsa.StriverAtoZ.step1.lec5;

/*
 * Recursion Tree (for printName(1,5)):
 *
 * printName(1,5)
 *   → printName(2,5)
 *       → printName(3,5)
 *           → printName(4,5)
 *               → printName(5,5)
 *                   → printName(6,5)  // stops here due to base condition
 *
 * Depth of Recursion = 5
 * Time Complexity = O(n)
 * Space Complexity = O(n)  (due to recursion stack)
 */

public class PrintNameNTimes {

    private static void printName(int counter, int number) {

        // Base Condition (stopping condition)
        // When counter becomes greater than number, stop recursion
        if (counter > number) {
            return;
        }

        // Print the name for the current call
        System.out.println("Striver");

        // Recursive Call
        // We pass counter + 1 to the next call.
        printName(counter + 1, number);
    }

    public static void main(String[] args) {
        printName(1, 5);
    }
}
