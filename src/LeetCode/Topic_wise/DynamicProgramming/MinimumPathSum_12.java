package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class MinimumPathSum_12 {

    static int [][] dp;

    public static void main(String[] args) {

        MinimumPathSum_12 sol = new MinimumPathSum_12();

        // ============================
        // Test Case 1
        // ============================
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Input: [[1,3,1],[1,5,1],[4,2,1]]");
        System.out.println("Output: " + sol.minPathSum(grid1));
        System.out.println("Expected: 7\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("Input: [[1,2,3],[4,5,6]]");
        System.out.println("Output: " + sol.minPathSum(grid2));
        System.out.println("Expected: 12");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:
    - To reach cell (i,j), we can come from:
        1. Up    -> (i-1, j)
        2. Left  -> (i, j-1)

    - So:
        minPath(i,j) = grid[i][j] + min(up, left)

    - Base:
        if(i == 0 && j == 0) return grid[0][0]

    - Out of bounds:
        return very large value

    TC: O(2^(m+n))
    SC: O(m+n)
    */


    /*
    public int find(int [][] a, int n, int m){

        if(n < 0 || m < 0) return 1_000_000_007;

        if(n == 0 && m == 0) return a[n][m];

        int up = a[n][m] + find(a, n - 1, m);
        int left = a[n][m] + find(a, n, m - 1);

        return Math.min(up, left);
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    Idea:
    - Same recursion
    - Store answers in dp[n][m]
    - Avoid repeated subproblems

    TC: O(m * n)
    SC: O(m * n) + O(m+n)
    */


    /*
    public int find(int [][] a, int n, int m){

        if(n < 0 || m < 0) return 1_000_000_007;

        if(n == 0 && m == 0) return a[n][m];

        if(dp[n][m] != -1) return dp[n][m];

        int up = a[n][m] + find(a, n - 1, m);
        int left = a[n][m] + find(a, n, m - 1);

        return dp[n][m] = Math.min(up, left);
    }
    */


    /*
    ============================
    Approach 3: Tabulation
    ============================

    Idea:
    - Build dp table from (0,0) to (n,m)
    - For each cell:
        dp[i][j] = grid[i][j] + min(up, left)

    TC: O(m * n)
    SC: O(m * n)
    */


    /*
    public int find(int [][] a, int n, int m){

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){

                if(i == 0 && j == 0) dp[i][j] = a[i][j];
                else{
                    int up = 0, left = 0;

                    if(i > 0) up = dp[i - 1][j];
                    else up = Integer.MAX_VALUE;

                    if(j > 0) left = dp[i][j - 1];
                    else left = Integer.MAX_VALUE;

                    dp[i][j] = a[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[n][m];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized (FINAL)
    ============================

    Idea:
    - Current row depends only on:
        1. previous row
        2. current row left cell

    - So use:
        prev[] -> previous row
        curr[] -> current row

    TC: O(m * n)
    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int minPathSum(int[][] grid) {

        dp = new int[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; i++){
            Arrays.fill(dp[i], -1);
        }

        return find(grid, grid.length - 1, grid[0].length - 1);
    }

    public int find(int [][] a, int n, int m){

        int [] prev = new int[m + 1];

        for(int i = 0 ; i <= n ; i++){

            int[] curr = new int[m + 1];

            for(int j = 0 ; j <= m ; j++){

                if(i == 0 && j == 0) curr[j] = a[i][j];

                else{
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j - 1];

                    curr[j] = a[i][j] + Math.min(up, left);
                }
            }

            prev = curr;
        }

        return prev[m];
    }
}