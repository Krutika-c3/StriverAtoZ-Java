package com.dsa.StriverAtoZ.step1.lec1;

/* 
 * Time complexity
 * Rate at which the time taken increases with respect to the input size.
 * Time complexity != time taken by the algorithm.
 *  - Time taken can vary based on the machine, compiler, and other factors.
 * 
 * Big O (O) Notation:
 * - Used to describe the upper bound of an algorithm's time complexity.
 * - Represents the worst-case scenario.
 * - Focuses on the highest order term, ignoring constants and lower order terms.
 * 
 * Omega (Ω) Notation:
 * - Describes the lower bound of an algorithm's time complexity.
 * - Represents the best-case scenario.
 * - Indicates the minimum time required for any input.
 * 
 * Theta (Θ) Notation:
 * - Describes the tight bound of an algorithm's time complexity.
 * - Represents both the upper and lower bounds.
 * - Indicates the exact asymptotic behavior for large input sizes.
 * 
 */
public class TimeComplexity {

    // This method uses two nested loops.
    // The outer loop runs from i = 0 to i < n (so n times).
    // For each value of i, the inner loop runs from j = 0 to j < n (also n times).
    // For every single run of the outer loop, the inner loop runs completely.
    // So, total number of iterations = n * n.
    // Example: If n = 2, total iterations = 2 * 2 = 4.
    // This is why the time complexity is O(n^2): as n grows, the number of steps grows very fast.
    public static void nestedLoopsWithSameLoops(int n) {
        for (int i = 0; i < n; i++) { // outer loop
            for (int j = 0; j < n; j++) { // inner loop
                System.out.println("i: " + i + ", j: " + j); // O(1) operation
            }
        }
    }

    public static void nestedLoopsWithDifferentLoops(int n) {
        // The outer loop runs from i = 0 to i < n (n times).
        // The inner loop runs from j = 0 to j < i.
        // So, when i = 0, inner loop runs 0 times.
        // When i = 1, inner loop runs 1 time.
        // When i = 2, inner loop runs 2 times.
        // ...
        // When i = n-1, inner loop runs (n-1) times.
        // Total number of iterations = 0 + 1 + 2 + ... + (n-1) = n(n-1)/2. (sum of first n natural numbers)
        // This is O(n^2) time complexity, but about half as many steps as the previous function.
        for (int i = 0; i < n; i++) { // outer loop
            for (int j = 0; j < i; j++) { // inner loop
                System.out.println("i: " + i + ", j: " + j); // O(1) operation
            }
        }
    }

    public static void main(String[] args) {
        // Example of O(n^2) time complexity
        int n = 5; // Size of input
        nestedLoopsWithSameLoops(n); // Calling the nested loops function
        // The time complexity of this function is O(n^2)
        // because there are two nested loops, each running n times.
        // For example, if n = 5, the total number of iterations will be 5 * 5 = 25.

        nestedLoopsWithDifferentLoops(n); // Calling the nested loops function with different inner loop
        // The time complexity of this function is also O(n^2)
        // because the outer loop runs n times and the inner loop runs a total of n(n
        // - 1)/2 times, which is still proportional to n^2.
        // For example, if n = 5, the total number of iterations will be 0 + 1 + 2 + 3 + 4 = 10.
        // This is still O(n^2) because we focus on the highest order term.
        // Note: The actual number of iterations is less than the previous function,
        // but in Big O notation, we only care about the growth rate as n increases.
        // So, both functions have O(n^2) time complexity.

    }
}
