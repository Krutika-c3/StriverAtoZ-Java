package com.dsa.StriverAtoZ.step1.lec5;


/*
    RECURSION TREE FOR f(4)

            f(4)
           /    \
       f(3)      f(2)
      /   \      /   \
   f(2)  f(1)  f(1)  f(0)
   /   \
f(1)  f(0)

Values:
f(0) = 0
f(1) = 1

So:
f(2) = 1 + 0 = 1
f(3) = f(2) + f(1) = 1 + 1 = 2
f(4) = f(3) + f(2) = 2 + 1 = 3

TIME COMPLEXITY OF RECURSIVE FIBONACCI

-   The recurrence:
        T(n) = T(n-1) + T(n-2) + O(1)

    At each call, the function calls itself twice (except at n=0 or n=1).
    So the recursion tree grows *exponentially*.

    ➤ The height of the recursion tree is n
    ➤ The number of nodes in the tree is approximately 2^n

    Therefore:

        Time Complexity:  O(2^n)   (Exponential)
        Space Complexity: O(n)     (Recursion stack depth)

    Why O(2^n)?
    - Every f(n) recomputes f(n-1) and f(n-2)
    - f(n-1) again recomputes its own f(n-2) and f(n-3)
    - Huge repeated work → grows like Fibonacci itself → ~1.618^n ≈ 2^n

*/

public class FibonacciRecursion {

    // Recursive Fibonacci function
    public static int fib(int n) {
        if (n <= 1) {
            return n;   // base case
        }
        return fib(n - 1) + fib(n - 2); // recursive case
    }

    public static void main(String[] args) {

        int[] tests = {4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        for (int n : tests) {
            System.out.println("fib(" + n + ") = " + fib(n));
        }
    }
}
