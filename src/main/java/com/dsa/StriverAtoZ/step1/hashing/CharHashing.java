package com.dsa.StriverAtoZ.step1.hashing;

import java.util.Scanner;

public class CharHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Step 1: Input the String ---
        System.out.print("Enter a string (e.g., 'banana'): ");
        String s = sc.next();

        // --- Step 2: Pre-computation ---
        // 256 covers all standard ASCII characters
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        System.out.println(">> Hashing complete for string: " + s);

        // --- Step 3: Fetching ---
        System.out.print("How many characters do you want to check? ");
        int q = sc.nextInt();

        while (q > 0) {
            System.out.print("Enter a character to find: ");
            // Reads the first character of the input
            char c = sc.next().charAt(0);

            System.out.println("Result: '" + c + "' appears " + hash[c] + " times.");
            q--;
        }

        sc.close();
    }
}