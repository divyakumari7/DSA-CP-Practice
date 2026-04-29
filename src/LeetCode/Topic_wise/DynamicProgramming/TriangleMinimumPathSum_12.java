package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class TriangleMinimumPathSum_12 {

    static int [][] dp;

    public static void main(String[] args) {

        TriangleMinimumPathSum_12 sol = new TriangleMinimumPathSum_12();

        // ============================
        // Test Case 1
        // ============================
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Input: [[2],[3,4],[6,5,7],[4,1,8,3]]");
        System.out.println("Output: " + sol.minimumTotal(triangle1));
        System.out.println("Expected: 11\n");

        // ============================
        // Test Case 2
        // ============================
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));

        System.out.println("Input: [[-10]]");
        System.out.println("Output: " + sol.minimumTotal(triangle2));
        System.out.println("Expected: -10");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:
    - From each cell (row, col), we have 2 choices:
        1. Go straight down      -> (row + 1, col)
        2. Go diagonally down    -> (row + 1, col + 1)

    - Take minimum of both paths.

    TC: O(2^n)
    SC: O(n)

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return find(triangle, 0, 0, n);
    }

    public int find(List<List<Integer>> list, int row, int col, int n){

        if(row == n - 1) return list.get(row).get(col);

        int str = list.get(row).get(col)
                + find(list, row + 1, col, n);

        int dia = list.get(row).get(col)
                + find(list, row + 1, col + 1, n);

        return Math.min(str, dia);
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    Idea:
    - Same recursion
    - Store dp[row][col]
    - Avoid repeated calculations

    TC: O(n * n)
    SC: O(n * n) + O(n)

    static int [][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        dp = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }

        return find(triangle, 0, 0, n);
    }

    public int find(List<List<Integer>> list, int row, int col, int n){

        if(dp[row][col] != -1) return dp[row][col];

        if(row == n - 1) return list.get(row).get(col);

        int str = list.get(row).get(col)
                + find(list, row + 1, col, n);

        int dia = list.get(row).get(col)
                + find(list, row + 1, col + 1, n);

        return dp[row][col] = Math.min(str, dia);
    }
    */


    /*
    ============================
    Approach 3: Tabulation (FINAL)
    ============================

    Idea:
    - Start from last row
    - Last row values are directly stored in dp
    - Move upward row by row
    - For each cell:
        dp[row][col] = triangle[row][col]
                       + min(dp[row+1][col], dp[row+1][col+1])

    TC: O(n * n)
    SC: O(n * n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        dp = new int[n][n];

        // Base case: last row
        for(int i = 0 ; i < n ; i++){
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        // Build answer from bottom to top
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = i ; j >= 0 ; j--){

                int str = triangle.get(i).get(j) + dp[i + 1][j + 1];
                int dia = triangle.get(i).get(j) + dp[i + 1][j];

                dp[i][j] = Math.min(str, dia);
            }
        }

        return dp[0][0];
    }


    /*
    ============================
    Approach 4: Space Optimized
    ============================

    Idea:
    - We only need the row below current row
    - Use one array front[]
    - Update from bottom to top

    TC: O(n * n)
    SC: O(n)

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int [] front = new int[n];

        for(int i = 0 ; i < n ; i++){
            front[i] = triangle.get(n - 1).get(i);
        }

        for(int row = n - 2 ; row >= 0 ; row--){

            int [] curr = new int[n];

            for(int col = row ; col >= 0 ; col--){

                int str = triangle.get(row).get(col) + front[col + 1];
                int dia = triangle.get(row).get(col) + front[col];

                curr[col] = Math.min(str, dia);
            }

            front = curr;
        }

        return front[0];
    }
    */
}