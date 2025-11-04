package com.dsa.StriverAtoZ.step1.lec4;

import java.util.Scanner;

public class PrimeCheck {

    // Function to check if a number is prime
    static boolean isPrime(int n) {

        // numbers <= 1 are not prime
        if (n <= 1)
            return false;

        int count = 0; // counter for divisors

        // loop from 1 to √n to find divisors
        for (int i = 1; i * i <= n; i++) {
            // if i divides n completely
            if (n % i == 0) {
                // if i and n/i are same (perfect square), count only once
                if (i * i == n)
                    count += 1;
                else
                    // otherwise, count both i and n/i
                    count += 2;
            }
        }

        // A prime number has exactly 2 divisors: 1 and itself
        return count == 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt(); // read the input number

        // check prime and print result
        if (isPrime(n))
            System.out.println("Prime");
        else
            System.out.println("Not Prime");

        sc.close();
    }
}
