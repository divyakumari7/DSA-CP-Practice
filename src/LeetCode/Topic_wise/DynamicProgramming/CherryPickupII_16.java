package LeetCode.Topic_wise.DynamicProgramming;

import java.util.*;

public class CherryPickupII_16 {

    static int[][][] dp;

    public static void main(String[] args) {

        CherryPickupII_16 sol =
                new CherryPickupII_16();

        // ============================
        // Test Case 1
        // ============================
        int[][] grid1 = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        System.out.println("Input: [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]");
        System.out.println("Output: " + sol.cherryPickup(grid1));
        System.out.println("Expected: 24\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] grid2 = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };

        System.out.println("Input: [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]");
        System.out.println("Output: " + sol.cherryPickup(grid2));
        System.out.println("Expected: 28");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:

    Two robots start from

    Robot 1 -> (0,0)

    Robot 2 -> (0,m-1)

    At every row both robots can move

    1. Left Diagonal
    2. Down
    3. Right Diagonal

    Hence,

    Total 3 × 3 = 9 possibilities.

    If both robots reach the
    same cell, count cherries once.

    Otherwise,
    collect cherries from both cells.

    TC: O(9^n)

    SC: O(n)
    */


    /*
    public int find(int i, int j1, int j2, int[][] grid){

        if(j1 < 0 || j2 < 0 ||
           j1 >= grid[0].length ||
           j2 >= grid[0].length)
            return -1_000_000_007;

        if(i == grid.length - 1){

            if(j1 == j2)
                return grid[i][j1];

            return grid[i][j1] + grid[i][j2];
        }

        int max = -1_000_000_007;

        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){

            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){

                int value;

                if(j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                value += find(i + 1,
                              j1 + dj1,
                              j2 + dj2,
                              grid);

                max = Math.max(max, value);
            }
        }

        return max;
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    Idea:

    State:

    dp[row][robot1Column][robot2Column]

    Store answer for every state.

    Number of states

    = n × m × m

    Each state explores

    9 transitions.

    TC: O(n × m² × 9)

    SC: O(n × m²) + O(n)
    */


    /*
    public int find(int i, int j1, int j2, int[][] grid){

        if(j1 < 0 || j2 < 0 ||
           j1 >= grid[0].length ||
           j2 >= grid[0].length)
            return -1_000_000_007;

        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        if(i == grid.length - 1){

            if(j1 == j2)
                return grid[i][j1];

            return grid[i][j1] + grid[i][j2];
        }

        int max = -1_000_000_007;

        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){

            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){

                int value;

                if(j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                value += find(i + 1,
                              j1 + dj1,
                              j2 + dj2,
                              grid);

                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
    */


    /*
    ============================
    Approach 3: Tabulation
    ============================

    Idea:

    Build DP from the last row
    towards the first row.

    DP State:

    dp[row][robot1][robot2]

    Every state checks
    all 9 possible moves.

    TC: O(n × m² × 9)

    SC: O(n × m²)
    */


    /*
    public int find(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        for(int j1 = 0 ; j1 < m ; j1++){

            for(int j2 = 0 ; j2 < m ; j2++){

                if(j1 == j2)
                    dp[n - 1][j1][j2] =
                            grid[n - 1][j1];

                else
                    dp[n - 1][j1][j2] =
                            grid[n - 1][j1] +
                            grid[n - 1][j2];
            }
        }

        for(int i = n - 2 ; i >= 0 ; i--){

            for(int j1 = 0 ; j1 < m ; j1++){

                for(int j2 = 0 ; j2 < m ; j2++){

                    int max = -1_000_000_007;

                    for(int dj1 = -1 ; dj1 <= 1 ; dj1++){

                        for(int dj2 = -1 ; dj2 <= 1 ; dj2++){

                            int value;

                            if(j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] +
                                        grid[i][j2];

                            if(j1 + dj1 >= 0 &&
                               j1 + dj1 < m &&
                               j2 + dj2 >= 0 &&
                               j2 + dj2 < m)

                                value += dp[i + 1]
                                           [j1 + dj1]
                                           [j2 + dj2];

                            else
                                value += -1_000_000_007;

                            max = Math.max(max, value);
                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m - 1];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized
    ============================

    Idea:

    Current row depends only on
    the next row.

    Replace 3D DP by

    front[m][m]

    curr[m][m]

    TC: O(n × m² × 9)

    SC: O(m²)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return find(0, 0, m - 1, grid);
    }

    public int find(int i, int j1, int j2, int[][] grid) {

        if (j1 < 0 || j2 < 0 ||
                j1 >= grid[0].length ||
                j2 >= grid[0].length) {

            return -1_000_000_007;
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        if (i == grid.length - 1) {

            if (j1 == j2)
                return grid[i][j1];

            return grid[i][j1] + grid[i][j2];
        }

        int max = -1_000_000_007;

        for (int dj1 = -1; dj1 <= 1; dj1++) {

            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int value;

                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                value += find(i + 1,
                        j1 + dj1,
                        j2 + dj2,
                        grid);

                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}


/*
============================
Dry Run
============================

Input

3 1 1
2 5 1
1 5 5
2 1 1

Robot 1 starts at column 0.

Robot 2 starts at column 2.

At every row both robots
choose one among

Left Diagonal
Down
Right Diagonal

The optimal path collects

24 cherries.

Answer

24


============================
Complexities
============================

Recursion

TC : O(9^n)

SC : O(n)


Memoization

TC : O(n × m² × 9)

SC : O(n × m²) + O(n)


Tabulation

TC : O(n × m² × 9)

SC : O(n × m²)


Space Optimized

TC : O(n × m² × 9)

SC : O(m²)


============================
Pattern Used
============================

1. Dynamic Programming

2. 3D DP

3. Multiple Starting Points

4. Grid DP

5. Memoization

6. Tabulation

7. Space Optimization


Best Approach:

Space Optimized
3D Dynamic Programming.
*/