package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class MinimumFallingPathSum_14 {

    static int[][] dp;

    public static void main(String[] args) {

        MinimumFallingPathSum_14 sol =
                new MinimumFallingPathSum_14();

        // ============================
        // Test Case 1
        // ============================
        int[][] matrix1 = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println("Input: [[2,1,3],[6,5,4],[7,8,9]]");
        System.out.println("Output: " + sol.minFallingPathSum(matrix1));
        System.out.println("Expected: 13\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] matrix2 = {
                {-19, 57},
                {-40, -5}
        };

        System.out.println("Input: [[-19,57],[-40,-5]]");
        System.out.println("Output: " + sol.minFallingPathSum(matrix2));
        System.out.println("Expected: -59");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:

    We start from any column of the
    last row.

    From every cell we can move to

    1. Up
    2. Upper Left Diagonal
    3. Upper Right Diagonal

    Take the minimum among them.

    Base Case:

    row == 0

    Return matrix[0][col]

    Out of bounds

    Return very large value.

    TC: O(3^n)

    SC: O(n)
    */


    /*
    public int find(int [][] matrix, int row, int col, int n){

        if(col < 0 || col >= n)
            return Integer.MAX_VALUE;

        if(row == 0)
            return matrix[row][col];

        int up = find(matrix, row - 1, col, n);

        int leftDiagonal =
                find(matrix, row - 1, col - 1, n);

        int rightDiagonal =
                find(matrix, row - 1, col + 1, n);

        return matrix[row][col] +
                Math.min(up,
                Math.min(leftDiagonal,
                        rightDiagonal));
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    Idea:

    Same recursion.

    Store every state
    dp[row][col].

    Avoid repeated computation.

    TC: O(n²)

    SC: O(n²) + O(n)
    */


    /*
    public int find(int [][] matrix, int row, int col, int n){

        if(col < 0 || col >= n)
            return Integer.MAX_VALUE;

        if(row == 0)
            return matrix[row][col];

        if(dp[row][col] != -1)
            return dp[row][col];

        int up =
                find(matrix, row - 1, col, n);

        int leftDiagonal =
                find(matrix, row - 1, col - 1, n);

        int rightDiagonal =
                find(matrix, row - 1, col + 1, n);

        return dp[row][col] =
                matrix[row][col] +
                Math.min(up,
                Math.min(leftDiagonal,
                        rightDiagonal));
    }
    */


    /*
    ============================
    Approach 3: Tabulation
    ============================

    Idea:

    First row is the base.

    Every cell depends on

    1. Upper
    2. Upper Left
    3. Upper Right

    Fill the DP table row by row.

    TC: O(n²)

    SC: O(n²)
    */


    /*
    public int find(int [][] matrix, int n){

        for(int j = 0 ; j < n ; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1 ; i < n ; i++){

            for(int j = 0 ; j < n ; j++){

                int up = dp[i - 1][j];

                int leftDiagonal =
                        Integer.MAX_VALUE;

                int rightDiagonal =
                        Integer.MAX_VALUE;

                if(j > 0)
                    leftDiagonal =
                            dp[i - 1][j - 1];

                if(j < n - 1)
                    rightDiagonal =
                            dp[i - 1][j + 1];

                dp[i][j] =
                        matrix[i][j] +
                        Math.min(up,
                        Math.min(leftDiagonal,
                                rightDiagonal));
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int j = 0 ; j < n ; j++){
            ans = Math.min(ans,
                    dp[n - 1][j]);
        }

        return ans;
    }
    */


    /*
    ============================
    Approach 4: Space Optimized
    ============================

    Idea:

    Current row depends only on
    previous row.

    Maintain

    front[] -> previous row

    curr[] -> current row

    TC: O(n²)

    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        dp = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }

        return find(matrix, n);
    }

    public int find(int[][] matrix, int n){

        int[] front = new int[n];

        for(int j = 0 ; j < n ; j++){
            front[j] = matrix[0][j];
        }

        for(int i = 1 ; i < n ; i++){

            int[] curr = new int[n];

            for(int j = 0 ; j < n ; j++){

                int up = front[j];

                int leftDiagonal =
                        Integer.MAX_VALUE;

                int rightDiagonal =
                        Integer.MAX_VALUE;

                if(j > 0)
                    leftDiagonal =
                            front[j - 1];

                if(j < n - 1)
                    rightDiagonal =
                            front[j + 1];

                curr[j] =
                        matrix[i][j] +
                                Math.min(up,
                                        Math.min(leftDiagonal,
                                                rightDiagonal));
            }

            front = curr;
        }

        int ans = Integer.MAX_VALUE;

        for(int j = 0 ; j < n ; j++){
            ans = Math.min(ans, front[j]);
        }

        return ans;
    }
}


/*
============================
Dry Run
============================

Input:

2 1 3
6 5 4
7 8 9

First Row

2 1 3

Second Row

8 6 5

Third Row

13 13 14

Minimum

13


============================
Complexities
============================

Recursion

TC : O(3^n)

SC : O(n)


Memoization

TC : O(n²)

SC : O(n²) + O(n)


Tabulation

TC : O(n²)

SC : O(n²)


Space Optimized

TC : O(n²)

SC : O(n)


============================
Pattern Used
============================

1. Dynamic Programming

2. Grid DP

3. Memoization

4. Tabulation

5. Space Optimization


Best Approach:

Space Optimized DP
using previous row.
*/