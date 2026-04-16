package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class UniquePaths_10 {

    static int [][] dp;

    public static void main(String[] args) {

        UniquePaths_10 sol = new UniquePaths_10();

        // ============================
        // Test Case 1
        // ============================
        int m1 = 3, n1 = 3;
        System.out.println("Input: m=3, n=3");
        System.out.println("Output: " + sol.numberOfPaths(m1, n1));
        System.out.println("Expected: 6\n");

        // ============================
        // Test Case 2
        // ============================
        int m2 = 2, n2 = 3;
        System.out.println("Input: m=2, n=3");
        System.out.println("Output: " + sol.numberOfPaths(m2, n2));
        System.out.println("Expected: 3");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:
    - From any cell (i,j), we can move:
        → up (i-1, j)
        → left (i, j-1)

    TC: Exponential
    SC: O(path length)
    */

    /*
    public int helper(int m, int n){

        if(m < 0 || n < 0) return 0;
        if(m == 0 && n == 0) return 1;

        int up = helper(m - 1, n);
        int left = helper(m, n - 1);

        return up + left;
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    TC: O(m * n)
    SC: O(m * n)
    */

    /*
    public int helper(int m, int n){

        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        if(m == 0 && n == 0) return 1;

        int up = helper(m - 1, n);
        int left = helper(m, n - 1);

        return dp[m][n] = up + left;
    }
    */


    /*
    ============================
    Approach 3: Tabulation
    ============================

    TC: O(m * n)
    SC: O(m * n)
    */

    /*
    public int helper(int m, int n){

        dp[0][0] = 1;

        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){

                if(i == 0 && j == 0) continue;

                int up = 0, left = 0;

                if(i > 0) up = dp[i - 1][j];
                if(j > 0) left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m][n];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized (FINAL)
    ============================

    Idea:
    - Only previous row needed
    - Use 1D array

    TC: O(m * n)
    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int numberOfPaths(int m, int n) {

        dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(m - 1, n - 1);
    }

    public int helper(int m, int n){

        int [] dp = new int[n + 1];

        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){

                if(i == 0 && j == 0) dp[j] = 1;

                else{
                    int up = dp[j];
                    int left = 0;

                    if(j > 0) left = dp[j - 1];

                    dp[j] = up + left;
                }
            }
        }

        return dp[n];
    }
}