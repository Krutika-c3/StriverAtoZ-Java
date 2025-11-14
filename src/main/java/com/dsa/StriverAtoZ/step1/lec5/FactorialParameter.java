package com.dsa.StriverAtoZ.step1.lec5;


/*
 * Calculate factorial of N using parameterized recursion.
 *
 * Concept:
 * Instead of returning values (like functional recursion),
 * we carry the running factorial in the parameter `fact`.
 *
 * Example:
 * For N = 5:
 * 1 × 2 × 3 × 4 × 5 = 120
 *
 * Call Flow (for printFactorial(1, 5, 1)):
 *
 * printFactorial(1,5,1)
 *   → printFactorial(2,5,1×1 = 1)
 *       → printFactorial(3,5,1×2 = 2)
 *           → printFactorial(4,5,2×3 = 6)
 *               → printFactorial(5,5,6×4 = 24)
 *                   → printFactorial(6,5,24×5 = 120) // base condition hit
 *
 * Base condition reached → print result:
 * Output = 120
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)   (recursion stack)
 *
 * Note:
 * - This is "parameterized recursion":
 *       the result is stored in parameters and printed at the end.
 * - No return value is needed.
 */
public class FactorialParameter {

    private static void printFactorial(int counter, int number, int fact) {

        // Base Condition: stop when counter passes the number
        if (counter > number) {
            System.out.println(fact);
            return;
        }

        // Multiply current counter into factorial
        fact = fact * counter;

        // Recursive call with updated counter and factorial
        printFactorial(counter + 1, number, fact);
    }

    public static void main(String[] args) {
        printFactorial(1, 5, 1); // Output: 120
    }
}
