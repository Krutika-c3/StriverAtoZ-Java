package com.dsa.striver_a_to_z.step2.array;

import java.util.*;

public class MaxProfit {

    // ---------------------------------------------------------
    // Method 1: Brute Force Approach
    // Logic: Try every pair of buy (i) and sell (j) days.
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int maxProfitBrute(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }
        return maxProfit;
    }

    // ---------------------------------------------------------
    // Method 2: Optimal Approach (Linear Scan)
    // Logic: Track the minimum price found so far and calculate
    // the potential profit if sold today.
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int maxProfitOptimal(int[] prices) {
        // Handle edge case for empty array
        if (prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Calculate the profit if we sell on the current day (i)
            // having bought at the lowest price found so far
            int cost = prices[i] - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, cost);

            // Update the minimum price found so far for future iterations
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        // Example Array: [7, 1, 5, 3, 6, 4]
        // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println("--- Best Time to Buy and Sell Stock ---");
        System.out.println("Stock Prices: " + Arrays.toString(prices));

        // 1. Run Brute Force
        int bruteResult = maxProfitBrute(prices);
        System.out.println("Max Profit (Brute Force): " + bruteResult);

        // 2. Run Optimal
        int optimalResult = maxProfitOptimal(prices);
        System.out.println("Max Profit (Optimal):     " + optimalResult);
    }
}