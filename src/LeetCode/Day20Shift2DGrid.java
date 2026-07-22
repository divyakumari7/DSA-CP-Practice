package LeetCode.Daily_potd.Year26.July;

import java.util.*;

public class Day20Shift2DGrid {

    public static void main(String[] args) {

        Day20Shift2DGrid sol =
                new Day20Shift2DGrid();

        // ============================
        // Test Case 1
        // ============================
        int[][] grid1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int k1 = 1;

        System.out.println("Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1");
        System.out.println("Output: " + sol.shiftGrid(grid1, k1));
        System.out.println("Expected: [[9,1,2],[3,4,5],[6,7,8]]\n");


        // ============================
        // Test Case 2
        // ============================
        int[][] grid2 = {
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13}
        };
        int k2 = 4;

        System.out.println("Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4");
        System.out.println("Output: " + sol.shiftGrid(grid2, k2));
    }


    /*
    ============================
    POTD 20 July
    Shift 2D Grid
    ============================

    Problem:

    Given an m x n grid
    and an integer k.

    Shift the grid k times.

    One shift means:

    1. Element at grid[i][j]
       moves to grid[i][j + 1].

    2. Last element of a row
       moves to the first
       element of the next row.

    3. Last element of the
       entire grid moves to
       grid[0][0].

    Return the final grid.
    */


    /*
    ============================
    Approach:
    Flatten + Reverse Rotation
    ============================

    Idea:

    Convert the 2D grid into
    a 1D list.

    Since shifting the grid
    is equivalent to rotating
    the 1D array to the right,
    use the Reversal Algorithm.

    Steps:

    1. Reverse the entire list.

    2. Reverse the first
       k elements.

    3. Reverse the remaining
       elements.

    Finally,

    rebuild the 2D grid.

    TC:

    O(m × n)

    SC:

    O(m × n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        k %= (n * m);

        List<Integer> arr = new ArrayList<>();

        for (int[] row : grid) {

            for (int num : row) {

                arr.add(num);
            }
        }

        Collections.reverse(arr);

        Collections.reverse(arr.subList(0, k));

        Collections.reverse(arr.subList(k, arr.size()));

        List<List<Integer>> result =
                new ArrayList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            List<Integer> row =
                    new ArrayList<>();

            for (int j = 0; j < m; j++) {

                row.add(arr.get(index++));
            }

            result.add(row);
        }

        return result;
    }
}


/*
============================
Dry Run
============================

Input

grid =

1 2 3

4 5 6

7 8 9

k = 1


Flatten

[1,2,3,4,5,6,7,8,9]


Reverse Entire List

[9,8,7,6,5,4,3,2,1]


Reverse First k Elements

[9,8,7,6,5,4,3,2,1]


Reverse Remaining Elements

[9,1,2,3,4,5,6,7,8]


Rebuild Grid

9 1 2

3 4 5

6 7 8


Answer

[[9,1,2],[3,4,5],[6,7,8]]


============================
Complexities
============================

Time Complexity

Flatten Grid

O(m × n)

Reverse Operations

O(m × n)

Rebuild Grid

O(m × n)

Overall

O(m × n)


Space Complexity

O(m × n)


============================
Pattern Used
============================

1. Matrix Traversal

2. Flattening Matrix

3. Array Rotation

4. Reversal Algorithm

5. Simulation


Best Approach:

Flatten the grid into a
1D list, perform right
rotation using the
Reversal Algorithm, and
reconstruct the 2D grid
 */