package com.dsa.StriverAtoZ.step1.hashing;

import java.util.HashMap;
import java.util.Scanner;

public class MapHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Step 1: Input ---
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter " + n + " numbers (Large/Negative allowed): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // --- Step 2: Pre-computation (HashMap) ---
        // Key = Number, Value = Frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            // Get existing count (default 0) and add 1
            int currentFreq = map.getOrDefault(num, 0);
            map.put(num, currentFreq + 1);
        }
        System.out.println(">> Map created successfully!");

        // --- Step 3: Fetching ---
        System.out.print("How many queries? ");
        int q = sc.nextInt();

        while (q > 0) {
            System.out.print("Enter number to find: ");
            int number = sc.nextInt();

            // Fetch from Map
            if (map.containsKey(number)) {
                System.out.println("Result: " + number + " appears " + map.get(number) + " times.");
            } else {
                System.out.println("Result: " + number + " appears 0 times.");
            }
            q--;
        }

        sc.close();
    }
}