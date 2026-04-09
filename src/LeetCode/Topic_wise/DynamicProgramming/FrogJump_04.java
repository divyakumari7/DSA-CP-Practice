package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class FrogJump_04 {

    public static void main(String[] args) {

        FrogJump_04 sol = new FrogJump_04();

        // ============================
        // Test Case 1
        // ============================
        int[] height1 = {10, 20, 30, 10};
        System.out.println("Input: [10,20,30,10]");
        System.out.println("Output: " + sol.minCost(height1));
        System.out.println("Expected: 20\n");

        // ============================
        // Test Case 2
        // ============================
        int[] height2 = {30, 10, 60, 10, 60, 50};
        System.out.println("Input: [30,10,60,10,60,50]");
        System.out.println("Output: " + sol.minCost(height2));
        System.out.println("Expected: 40");
    }


    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================

    TC: O(2^n)
    SC: O(n)

    public int minCost(int[] height) {
        return find(height.length - 1, height);
    }

    public int find(int n, int[] height){
        if(n == 0) return 0;

        int left = find(n - 1, height)
                + Math.abs(height[n] - height[n - 1]);

        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = find(n - 2, height)
                    + Math.abs(height[n] - height[n - 2]);
        }

        return Math.min(left, right);
    }
    */


    /*
    ============================
    Approach 2: Memoization (Top-Down DP)
    ============================

    TC: O(n)
    SC: O(n)

    int[] dp;

    public int minCost(int[] height) {
        int n = height.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return find(n - 1, height);
    }

    public int find(int n, int[] height){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int left = find(n - 1, height)
                + Math.abs(height[n] - height[n - 1]);

        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = find(n - 2, height)
                    + Math.abs(height[n] - height[n - 2]);
        }

        return dp[n] = Math.min(left, right);
    }
    */


    /*
    ============================
    Approach 3: Tabulation (Bottom-Up DP)
    ============================

    TC: O(n)
    SC: O(n)

    public int minCost(int[] height) {

        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for(int i = 1; i < n; i++){

            int left = dp[i - 1]
                    + Math.abs(height[i] - height[i - 1]);

            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = dp[i - 2]
                        + Math.abs(height[i] - height[i - 2]);
            }

            dp[i] = Math.min(left, right);
        }

        return dp[n - 1];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized
    ============================

    TC: O(n)
    SC: O(1)

    Idea:
    Only last 2 states needed
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int minCost(int[] height) {

        int n = height.length;

        if(n == 1) return 0;

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for(int i = 1; i < n; i++){

            int left = prev1
                    + Math.abs(height[i] - height[i - 1]);

            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = prev2
                        + Math.abs(height[i] - height[i - 2]);
            }

            int curr = Math.min(left, right);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}