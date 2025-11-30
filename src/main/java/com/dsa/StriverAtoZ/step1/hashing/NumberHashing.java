package com.dsa.StriverAtoZ.step1.hashing;

import java.util.Scanner;

public class NumberHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Step 1: Input the Array ---
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements (Max value 12): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // --- Step 2: Pre-computation (Hashing) ---
        // Creating a hash array of size 13 (indices 0 to 12)
        int[] hash = new int[13];
        for (int num : arr) {
            if (num < 13) {
                hash[num] += 1;
            }
        }
        System.out.println(">> Pre-computation complete! Frequencies stored.");

        // --- Step 3: Fetching (Queries) ---
        System.out.print("How many numbers do you want to search for? ");
        int q = sc.nextInt();

        while (q > 0) {
            System.out.print("Enter number to count: ");
            int number = sc.nextInt();

            // Fetching logic
            if (number < 13) {
                System.out.println("Result: " + number + " appears " + hash[number] + " times.");
            } else {
                System.out.println("Result: 0 (Number is too big for this hash array)");
            }
            q--;
        }

        System.out.println(">> Done!");
        sc.close();
    }
}