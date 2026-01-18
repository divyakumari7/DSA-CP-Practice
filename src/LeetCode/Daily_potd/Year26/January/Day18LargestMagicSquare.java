package LeetCode.Daily_potd.Year26.January;

class Day18LargestMagicSquare {

    /*
     * ----------------------------------------------------
     * POTD Day 18
     * Problem: Largest Magic Square
     * ----------------------------------------------------
     *
     * Approach:
     * ----------------------------------------------------
     * 1. A magic square is a k x k subgrid where:
     *    - All row sums are equal
     *    - All column sums are equal
     *    - Both diagonal sums are equal
     *
     * 2. We try all possible square sizes k:
     *    - Start from the largest possible size
     *    - Go down to size 2
     *
     * 3. For each size k:
     *    - Slide a k x k window over the grid
     *    - For each starting position (i, j),
     *      check whether the subgrid is magic
     *
     * 4. As soon as we find a valid magic square,
     *    return its size (since we check from largest).
     *
     * 5. If no magic square of size ≥ 2 is found,
     *    return 1 (single cell is always magic).
     */

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Let N = number of rows, M = number of columns
     *
     * - We try all possible square sizes: min(N, M)
     * - For each size k:
     *     - We scan all possible top-left positions: O(N * M)
     *     - Each check takes O(k²) time
     *
     * Overall:
     * O(min(N, M) * N * M * k²)
     *
     * In worst case (square grid):
     * O(N⁵)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(1)
     * - No extra data structures used
     * - Only variables for sum calculations
     */

    public int largestMagicSquare(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        // Try square sizes from largest to smallest
        for (int k = Math.min(n, m); k >= 2; k--) {

            // Iterate over all possible top-left positions
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {

                    // Check if current k x k subgrid is magic
                    if (check(grid, i, j, k)) return k;
                }
            }
        }

        // If no magic square larger than 1 is found
        return 1;
    }

    /*
     * ----------------------------------------------------
     * Helper Function: check()
     * ----------------------------------------------------
     * Checks whether a k x k subgrid starting at (r, c)
     * forms a magic square.
     */
    public static boolean check(int[][] grid, int r, int c, int k) {

        int target = 0;

        // Step 1: Calculate target sum using first row
        for (int j = c; j < c + k; j++) {
            target += grid[r][j];
        }

        // Step 2: Check sum of all rows
        for (int i = r; i < r + k; i++) {
            int rowsum = 0;
            for (int j = c; j < c + k; j++) {
                rowsum += grid[i][j];
            }
            if (rowsum != target) return false;
        }

        // Step 3: Check sum of all columns
        for (int i = c; i < c + k; i++) {
            int colsum = 0;
            for (int j = r; j < r + k; j++) {
                colsum += grid[j][i];
            }
            if (colsum != target) return false;
        }

        // Step 4: Check both diagonals
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
            diag2 += grid[r + i][c + k - 1 - i];
        }

        return diag1 == target && diag2 == target;
    }
}
