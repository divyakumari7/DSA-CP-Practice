package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class HouseRobber2_08 {

    public static void main(String[] args) {

        HouseRobber2_08 sol = new HouseRobber2_08();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {2, 3, 2};
        System.out.println("Input: [2,3,2]");
        System.out.println("Output: " + sol.rob(nums1));
        System.out.println("Expected: 3\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Input: [1,2,3,1]");
        System.out.println("Output: " + sol.rob(nums2));
        System.out.println("Expected: 4");
    }


    /*
    ============================
    Problem Understanding
    ============================

    - Houses are arranged in a CIRCLE
    - First and last house are adjacent ❗

    So we CANNOT take both nums[0] and nums[n-1]

    ------------------------------------------------
    Trick:
    ------------------------------------------------
    Break into TWO linear problems:

    1. Take houses [0 → n-2]
    2. Take houses [1 → n-1]

    Answer = max(case1, case2)
    */


    /*
    ============================
    Approach 1: Recursion
    ============================

    Same as House Robber I, but applied twice

    TC: O(2^n)
    SC: O(n)

    (Skipped implementation here to avoid repetition)
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    TC: O(n)
    SC: O(n)

    (Same logic as House Robber I)
    */


    /*
    ============================
    Approach 3: Tabulation
    ============================

    TC: O(n)
    SC: O(n)

    (Same as previous problem)
    */


    /*
    ============================
    Approach 4: Space Optimized (FINAL)
    ============================

    TC: O(n)
    SC: O(1)

    Use prev & prev2
    Solve twice:
        [0 → n-2]
        [1 → n-1]
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int rob(int[] nums) {

        // Edge case
        if(nums.length == 1) return nums[0];

        // Case 1: exclude last
        int [] a = new int[nums.length - 1];
        for(int i = 0 ; i < nums.length - 1 ; i++){
            a[i] = nums[i];
        }

        // Case 2: exclude first
        int [] b = new int[nums.length - 1];
        int k = 0;
        for(int i = 1 ; i < nums.length ; i++){
            b[k] = nums[i];
            k++;
        }

        // Take max of both cases
        return Math.max(find(a, a.length - 1),
                find(b, b.length - 1));
    }


    // ============================
    // SAME LOGIC AS HOUSE ROBBER 1
    // ============================

    int find(int [] arr, int n){

        int prev2 = 0;        // dp[i-2]
        int prev = arr[0];    // dp[i-1]
        int ans = arr[0];

        for(int i = 1 ; i <= n ; i++){

            // Take current house
            int take = arr[i];
            if(i > 1) take = arr[i] + prev2;

            // Skip current house
            int nottake = prev;

            // Max profit
            ans = Math.max(take, nottake);

            // Shift window
            prev2 = prev;
            prev = ans;
        }

        return ans;
    }
}