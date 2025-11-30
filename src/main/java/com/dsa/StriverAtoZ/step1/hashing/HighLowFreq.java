package com.dsa.StriverAtoZ.step1.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HighLowFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Step 1: Input ---
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // --- Step 2: Build the Map (Hashing) ---
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // --- Step 3: Find Max/Min Frequency ---
        // MAX starts at 0 (Floor): So the first real count we find will instantly be higher.
        // MIN starts at n (Ceiling): So the first real count we check (which is always <= n) will be lowed.
        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

        // Iterate over the Map Entries
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            // --- CHECK FOR HIGHEST FREQUENCY ---
            // "Is this current count strictly greater than the highest count we have seen so far?"
            if (count > maxFreq) {
                maxFreq = count;   // Update the record for highest frequency
                maxEle = element;  // Update the element that holds this record
            }

            // --- CHECK FOR LOWEST FREQUENCY ---
            // "Is this current count strictly smaller than the lowest count we have seen so far?"
            if (count < minFreq) {
                minFreq = count;   // Update the record for lowest frequency
                minEle = element;  // Update the element that holds this record
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Element with Max Frequency: " + maxEle + " (Count: " + maxFreq + ")");
        System.out.println("Element with Min Frequency: " + minEle + " (Count: " + minFreq + ")");
        System.out.println("--------------------------------");

        sc.close();
    }
}