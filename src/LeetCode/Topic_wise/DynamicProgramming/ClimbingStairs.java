package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class ClimbingStairs {

    public static void main(String[] args) {

        ClimbingStairs sol = new ClimbingStairs();

        // ============================
        // Test Case 1
        // ============================
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + sol.climbStairs(n1));
        System.out.println("Expected: 3\n");

        // ============================
        // Test Case 2
        // ============================
        int n2 = 5;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + sol.climbStairs(n2));
        System.out.println("Expected: 8");
    }


    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================
    TC: O(2^n)
    SC: O(n) recursion stack

    public int climbStairs(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    */


    /*
    ============================
    Approach 2: Memoization (Top-Down DP)
    ============================
    TC: O(n)
    SC: O(n) + recursion stack

    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(n);
    }

    public int find(int n){
        if(n <= 2) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = find(n - 1) + find(n - 2);
        return dp[n];
    }
    */


    /*
    ============================
    Approach 3: Tabulation (Bottom-Up DP)
    ============================
    TC: O(n)
    SC: O(n)

    public int climbStairs(int n) {
        if(n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized DP (Most Optimal)
    ============================
    TC: O(n)
    SC: O(1)
    */

    public int climbStairs(int n) {
        if(n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;

        for(int i = 3; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}