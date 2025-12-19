package com.dsa.StriverAtoZ.step2.array;

import java.util.*;

public class MaxConsecutiveOnes {

    // ---------------------------------------------------------
    // Optimal Approach
    // Time Complexity: O(N) | Space Complexity: O(1)
    // ---------------------------------------------------------
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
                maxi = Math.max(maxi, cnt);
            } else {
                cnt = 0;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println("Max Consecutive Ones: " + findMaxConsecutiveOnes(nums));
    }
}
