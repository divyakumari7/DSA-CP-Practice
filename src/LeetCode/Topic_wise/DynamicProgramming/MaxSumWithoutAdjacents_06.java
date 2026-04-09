package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class MaxSumWithoutAdjacents_06 {

    public static void main(String[] args) {

        MaxSumWithoutAdjacents_06 sol = new MaxSumWithoutAdjacents_06();

        // ============================
        // Test Case 1
        // ============================
        int[] arr1 = {3, 2, 7, 10};
        System.out.println("Input: [3,2,7,10]");
        System.out.println("Output: " + sol.findMaxSum(arr1));
        System.out.println("Expected: 13\n");

        // ============================
        // Test Case 2
        // ============================
        int[] arr2 = {3, 2, 5, 10, 7};
        System.out.println("Input: [3,2,5,10,7]");
        System.out.println("Output: " + sol.findMaxSum(arr2));
        System.out.println("Expected: 15");
    }


    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================

    Idea:
    - At each index, we have 2 choices:
        1. Pick current element → move to i-2
        2. Skip current element → move to i-1

    TC: O(2^n)
    SC: O(n)

    public int findMaxSum(int arr[]) {
        return find(arr, arr.length - 1);
    }

    public int find(int [] arr, int n){

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

    public int findMaxSum(int arr[]) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return find(arr, arr.length - 1);
    }

    public int find(int [] arr, int n){

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

    public int findMaxSum(int arr[]) {

        int n = arr.length;
        int [] dp = new int[n];

        dp[0] = arr[0];

        for(int i = 1 ; i < n ; i++){

            int take = arr[i];
            if(i > 1) take = arr[i] + dp[i - 2];

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
    - Only last 2 states needed
    - prev  → dp[i-1]
    - prev2 → dp[i-2]

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int findMaxSum(int arr[]) {

        int n = arr.length - 1;

        int prev2 = 0;
        int prev = arr[0];
        int ans = arr[0];

        for(int i = 1 ; i <= n ; i++){

            // Pick
            int take = arr[i];
            if(i > 1) take = arr[i] + prev2;

            // Not pick
            int nottake = prev;

            // Max
            ans = Math.max(take, nottake);

            // Shift
            prev2 = prev;
            prev = ans;
        }

        return ans;
    }
}