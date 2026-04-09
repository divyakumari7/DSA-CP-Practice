package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class FrogJumpK_05 {

    public static void main(String[] args) {

        FrogJumpK_05 sol = new FrogJumpK_05();

        // ============================
        // Test Case 1
        // ============================
        int[] height1 = {10, 30, 40, 50, 20};
        int k1 = 3;
        System.out.println("Input: [10,30,40,50,20], k = 3");
        System.out.println("Output: " + sol.minCost(height1, k1));
        System.out.println("Expected: 30\n");

        // ============================
        // Test Case 2
        // ============================
        int[] height2 = {10, 20, 10};
        int k2 = 2;
        System.out.println("Input: [10,20,10], k = 2");
        System.out.println("Output: " + sol.minCost(height2, k2));
        System.out.println("Expected: 0");
    }


    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================

    Idea:
    - From index i, frog can jump back up to k steps
    - Try all possibilities and take minimum

    TC: O(k^n) (very high)
    SC: O(n)

    public int minCost(int[] height, int k) {
        return find(height.length - 1, height, k);
    }

    public int find(int n, int[] height, int k){
        if(n == 0) return 0;

        int curr = Integer.MAX_VALUE;

        for(int j = 1; j <= k; j++){
            if(n - j >= 0){
                curr = Math.min(curr,
                        find(n - j, height, k)
                        + Math.abs(height[n] - height[n - j]));
            }
        }

        return curr;
    }
    */


    /*
    ============================
    Approach 2: Memoization (Top-Down DP)
    ============================

    TC: O(n * k)
    SC: O(n)

    int[] dp;

    public int minCost(int[] height, int k) {
        int n = height.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return find(n - 1, height, k);
    }

    public int find(int n, int[] height, int k){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int curr = Integer.MAX_VALUE;

        for(int j = 1; j <= k; j++){
            if(n - j >= 0){
                curr = Math.min(curr,
                        find(n - j, height, k)
                        + Math.abs(height[n] - height[n - j]));
            }
        }

        return dp[n] = curr;
    }
    */


    /*
    ============================
    Approach 3: Tabulation (Bottom-Up DP)
    ============================

    TC: O(n * k)
    SC: O(n)

    public int minCost(int[] height, int k) {

        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for(int i = 1; i < n; i++){

            int curr = Integer.MAX_VALUE;

            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    curr = Math.min(curr,
                            dp[i - j]
                            + Math.abs(height[i] - height[i - j]));
                }
            }

            dp[i] = curr;
        }

        return dp[n - 1];
    }
    */


    /*
    ============================
    Approach 4: Space Optimization
    ============================

    ❌ Not possible to fully optimize to O(1)

    Reason:
    - We need last k states (not constant like 2)
    - So at least O(k) or O(n) needed

    Best we can do = Tabulation
    */


    // ============================
    // FINAL CODE (YOUR STYLE LOOP)
    // ============================

    public int minCost(int[] height, int k) {

        int n = height.length - 1;

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for(int i = 1 ; i <= n ; i++){

            int curr = Integer.MAX_VALUE;

            // Try all jumps from 1 to k
            for(int j = 1 ; j <= k ; j++){

                if(i > j - 1){
                    curr = Math.min(curr,
                            dp[i - j]
                                    + Math.abs(height[i] - height[i - j]));
                }
            }

            dp[i] = curr;
        }

        return dp[n];
    }
}