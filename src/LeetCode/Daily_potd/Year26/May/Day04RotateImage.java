package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day04RotateImage {

    public static void main(String[] args) {

        Day04RotateImage sol = new Day04RotateImage();

        // ============================
        // Test Case 1
        // ============================
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Input: [[1,2,3],[4,5,6],[7,8,9]]");
        sol.rotate(matrix1);
        System.out.println("Output: " + Arrays.deepToString(matrix1));
        System.out.println("Expected: [[7,4,1],[8,5,2],[9,6,3]]\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        System.out.println("Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        sol.rotate(matrix2);
        System.out.println("Output: " + Arrays.deepToString(matrix2));
        System.out.println("Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
    }


    /*
    ============================
    Approach 1: Extra Matrix
    ============================

    Idea:
    - Create a new matrix ans[][]
    - For every cell matrix[i][j],
      place it at ans[j][n - 1 - i]

    TC: O(n^2)
    SC: O(n^2)

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] ans = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
    */


    /*
    ============================
    Approach 2: Transpose + Reverse (FINAL)
    ============================

    Idea:
    - To rotate matrix by 90 degrees clockwise:
        1. Transpose the matrix
        2. Reverse every row

    Example:
    Original:
        1 2 3
        4 5 6
        7 8 9

    After transpose:
        1 4 7
        2 5 8
        3 6 9

    After reversing rows:
        7 4 1
        8 5 2
        9 6 3

    TC: O(n^2)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose matrix
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n / 2 ; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}