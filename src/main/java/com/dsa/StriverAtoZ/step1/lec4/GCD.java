package com.dsa.StriverAtoZ.step1.lec4;

public class GCD {

    // Function to find GCD (Greatest Common Divisor)
    static int gcd(int a, int b) {

        /*
         * Euclid’s Algorithm (Mathematical Idea):
         * ---------------------------------------
         * The GCD of two numbers does not change if the larger number
         * is replaced by its remainder when divided by the smaller number.
         *
         * In other words:
         * gcd(a, b) = gcd(a % b, b)  if a > b
         *
         * Why this works:
         * - Suppose a = b × q + r   (where r = a % b)
         * - Any number that divides both a and b must also divide r.
         * - Therefore, gcd(a, b) = gcd(b, r)
         *
         * We repeat this process until one number becomes 0.
         * The non-zero number left is the GCD.
         *
         * The time complexity of Euclid’s algorithm is O(log(min(a, b))).
         */

        // Continue until one of them becomes 0
        while (a > 0 && b > 0) {
            if (a > b)
                a = a % b;  // replace a with remainder of a divided by b
            else
                b = b % a;  // replace b with remainder of b divided by a
        }

        // when one becomes 0, the other is the GCD
        if (a == 0)
            return b;
        else
            return a;
    }

    public static void main(String[] args) {
        int a = 42, b = 24;

        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
    }
}
