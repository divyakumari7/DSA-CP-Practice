package LeetCode.Daily_potd.Year26.January;

public class Day17FindTheLargestAreaOfSquareInsideTwoRectangles  {

    /*
     * Problem:
     * Largest Square Area
     *
     * You are given two arrays:
     * - bottomLeft[i]  = [x1, y1] of the i-th rectangle
     * - topRight[i]    = [x2, y2] of the i-th rectangle
     *
     * Find the maximum possible area of a square that can be formed
     * by the overlapping region of any two rectangles.
     */

    // ----------------------------------------------------
    // Approach:
    // ----------------------------------------------------
    // 1. Consider every pair of rectangles.
    //
    // 2. For each pair, compute the overlapping region:
    //    - top    = min(top y-coordinates)
    //    - right  = min(right x-coordinates)
    //    - bottom = max(left x-coordinates)
    //    - left   = max(bottom y-coordinates)
    //
    // 3. The height and width of the overlap are:
    //    - height = top - left
    //    - width  = right - bottom
    //
    // 4. The largest square that can fit inside this overlap
    //    has side = min(height, width).
    //
    // 5. Track the maximum possible side length across all pairs.
    //
    // 6. Return the square of the maximum side length.

    // ----------------------------------------------------
    // Time Complexity:
    // ----------------------------------------------------
    // Let N = number of rectangles
    //
    // - We check every pair of rectangles
    // - Total pairs = N * (N - 1) / 2
    //
    // Time Complexity:
    // O(N^2)

    // ----------------------------------------------------
    // Space Complexity:
    // ----------------------------------------------------
    // O(1)
    // - Only constant extra variables are used
    // - No additional data structures

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {

        long max = 0;

        // Check all pairs of rectangles
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {

                // Compute overlapping boundaries
                int top = Math.min(topRight[i][1], topRight[j][1]);
                int right = Math.min(topRight[i][0], topRight[j][0]);
                int bottom = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int left = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                /*
                 * ----------------------------------------------------
                 * Alternate Logic (Using if-condition) – COMMENTED
                 * ----------------------------------------------------
                 *
                 * Idea:
                 * Check explicitly whether two rectangles overlap.
                 *
                 * Condition for overlap:
                 * left < top AND bottom < right
                 *
                 * if (left < top && bottom < right) {
                 *     int height = top - left;
                 *     int width  = right - bottom;
                 *     int side   = Math.min(height, width);
                 *     max = Math.max(max, side);
                 * }
                 *
                 * ----------------------------------------------------
                 * Why current solution works without if?
                 * ----------------------------------------------------
                 * - If rectangles do not overlap:
                 *     height or width becomes negative
                 * - min(height, width) becomes negative
                 * - max ignores negative values automatically
                 *
                 * Hence, explicit if-condition is not required.
                 */

                // Height and width of overlap
                int h = (top - left);
                int w = (right - bottom);

                // Largest square side possible in this overlap
                int side = Math.min(h, w);

                max = Math.max(max, side);
            }
        }

        return max * max;
    }
}
