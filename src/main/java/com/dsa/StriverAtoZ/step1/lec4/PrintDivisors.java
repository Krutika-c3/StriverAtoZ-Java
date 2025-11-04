package com.dsa.StriverAtoZ.step1.lec4;

import java.util.*;

public class PrintDivisors {

    static void printDivisors(int n) {
        // TreeSet automatically stores elements in sorted order without duplicates
        Set<Integer> divisors = new TreeSet<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }

        // print all divisors
        for (int d : divisors) {
            System.out.print(d + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.print("Divisors of " + n + ": ");
        printDivisors(n);

        sc.close();
    }
}
