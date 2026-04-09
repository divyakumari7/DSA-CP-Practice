package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class HouseRobber_07 {

    public static void main(String[] args) {

        HouseRobber_07 sol = new HouseRobber_07();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: [1,2,3,1]");
        System.out.println("Output: " + sol.rob(nums1));
        System.out.println("Expected: 4\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Input: [2,7,9,3,1]");
        System.out.println("Output: " + sol.rob(nums2));
        System.out.println("Expected: 12");
    }


    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================

    Idea:
    - At each house:
        1. Rob → skip next (i-2)
        2. Skip → go to next (i-1)

    TC: O(2^n)
    SC: O(n)

    public int rob(int[] nums) {
        return find(nums, nums.length - 1);
    }

    int find(int [] arr, int n){

        if(n < 0) return 0;
        if(n == 0) return arr[n];

        int pick = arr[n] + find(arr, n - 2);
        int notpick = find(arr, n - 1);

        return Math.max(pick, notpick);
    }
    */


    /*
    ============================
    Approach 2: Memoization (Top-Down DP)
    ============================

    TC: O(n)
    SC: O(n)

    int [] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return find(nums, nums.length - 1);
    }

    int find(int [] arr, int n){

        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        if(n == 0) return arr[n];

        int pick = arr[n] + find(arr, n - 2);
        int notpick = find(arr, n - 1);

        return dp[n] = Math.max(pick, notpick);
    }
    */


    /*
    ============================
    Approach 3: Tabulation (Bottom-Up DP)
    ============================

    TC: O(n)
    SC: O(n)

    public int rob(int[] nums) {

        int n = nums.length;
        int [] dp = new int[n];

        dp[0] = nums[0];

        for(int i = 1 ; i < n ; i++){

            int take = nums[i];
            if(i > 1) take = nums[i] + dp[i - 2];

            int nottake = dp[i - 1];

            dp[i] = Math.max(take, nottake);
        }

        return dp[n - 1];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized (FINAL)
    ============================

    Idea:
    - prev  → dp[i-1]
    - prev2 → dp[i-2]

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    int [] dp;

    public int rob(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return find(nums, nums.length - 1);
    }

    int find(int [] arr, int n){

        int prev2 = 0;
        int prev = arr[0];
        int ans = arr[0];

        for(int i = 1 ; i <= n ; i++){

            // Rob current house
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