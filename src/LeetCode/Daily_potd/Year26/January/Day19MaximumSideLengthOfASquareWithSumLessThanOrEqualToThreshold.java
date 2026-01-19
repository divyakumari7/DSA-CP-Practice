package LeetCode.Daily_potd.Year26.January;

class Day19MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

    /*
     * ----------------------------------------------------
     * POTD Day 19
     * Problem:
     * Maximum Side Length of a Square
     * With Sum Less Than or Equal to Threshold
     * ----------------------------------------------------
     *
     * Approach:
     * ----------------------------------------------------
     * 1. Build a 2D prefix sum matrix where
     *    pref[i][j] represents the sum of elements
     *    from (0,0) to (i-1,j-1).
     *
     * 2. Using prefix sum, we can compute the sum
     *    of any k x k submatrix in O(1).
     *
     * 3. Try all possible square sizes k starting from
     *    the maximum possible size (min(rows, cols))
     *    down to 1.
     *
     * 4. For each size k:
     *    - Slide a k x k window across the matrix
     *    - Calculate submatrix sum using prefix sum
     *    - If sum ≤ threshold, return k immediately
     *
     * 5. Since we check larger sizes first,
     *    the first valid k is the maximum answer.
     */

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Prefix sum construction: O(m * n)
     * Checking all square sizes: O(min(m, n) * m * n)
     *
     * Overall TC:
     * O(min(m, n) * m * n)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(m * n)
     * Extra space used for prefix sum matrix
     */

    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length, n = mat[0].length;

        // Prefix sum matrix
        int[][] pref = new int[m + 1][n + 1];

        // Step 1: Build prefix sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                        + pref[i - 1][j]
                        + pref[i][j - 1]
                        - pref[i - 1][j - 1];
            }
        }

        int sum = 0;

        // Step 2: Try square sizes from large to small
        for (int k = Math.min(m, n); k >= 1; k--) {
            for (int i = k; i <= m; i++) {
                for (int j = k; j <= n; j++) {

                    // Calculate sum of current k x k square
                    sum = pref[i][j]
                            - pref[i - k][j]
                            - pref[i][j - k]
                            + pref[i - k][j - k];

                    // Check threshold condition
                    if (sum <= threshold) {
                        return k;
                    }
                }
            }
        }

        return 0;
    }
}
