package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day09CyclicallyRotatingAGrid {

    public static void main(String[] args) {

        Day09CyclicallyRotatingAGrid sol = new Day09CyclicallyRotatingAGrid();

        // ============================
        // Test Case 1
        // ============================
        int[][] grid1 = {
                {40, 10},
                {30, 20}
        };
        int k1 = 1;

        System.out.println("Input: grid = [[40,10],[30,20]], k = 1");
        System.out.println("Output: " + Arrays.deepToString(sol.rotateGrid(grid1, k1)));
        System.out.println("Expected: [[10,20],[40,30]]\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] grid2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int k2 = 2;

        System.out.println("Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2");
        System.out.println("Output: " + Arrays.deepToString(sol.rotateGrid(grid2, k2)));
        System.out.println("Expected: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]");
    }


    /*
    ============================
    Approach: Layer by Layer Rotation
    ============================

    Idea:
    - Matrix can be divided into multiple rectangular layers.
    - Each layer is treated like a circular list.
    - Extract all elements of one layer into a list.
    - Rotate that list by k positions.
    - Put the rotated values back into the same layer.

    Steps:
    1. Find total layers:
        layers = min(n, m) / 2

    2. For each layer:
        - Define boundaries:
            top, bottom, left, right

    3. Extract elements in order:
        - top row left → right
        - right column top+1 → bottom
        - bottom row right-1 → left
        - left column bottom-1 → top+1

    4. Rotate the list:
        shift = k % len
        Collections.rotate(vals, -shift)

       Negative shift means anti-clockwise rotation.

    5. Put values back in the same order.

    TC: O(n * m)
    SC: O(n * m) in worst case due to layer list storage
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int[][] rotateGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int layers = (n < m)? n / 2 : m / 2;

        for(int l = 0 ; l < layers ; l++){

            List<Integer> vals = new ArrayList<>();

            int top = l, bottom = n - l - 1;
            int left = l, right = m - l - 1;

            // Extract top row
            for(int i = left ; i <= right ; i++){
                vals.add(grid[top][i]);
            }

            // Extract right column
            for(int i = top + 1 ; i <= bottom ; i++){
                vals.add(grid[i][right]);
            }

            // Extract bottom row
            for(int i = right - 1 ; i >= left ; i--){
                vals.add(grid[bottom][i]);
            }

            // Extract left column
            for(int i = bottom - 1 ; i >= top + 1 ; i--){
                vals.add(grid[i][left]);
            }

            int len = vals.size();
            int shift = k % len;

            // Rotate anti-clockwise
            Collections.rotate(vals, -shift);

            int idx = 0;

            // Put back top row
            for(int i = left ; i <= right ; i++){
                grid[top][i] = vals.get(idx++);
            }

            // Put back right column
            for(int i = top + 1 ; i <= bottom ; i++){
                grid[i][right] = vals.get(idx++);
            }

            // Put back bottom row
            for(int i = right - 1 ; i >= left ; i--){
                grid[bottom][i] = vals.get(idx++);
            }

            // Put back left column
            for(int i = bottom - 1 ; i >= top + 1 ; i--){
                grid[i][left] = vals.get(idx++);
            }
        }

        return grid;
    }
}