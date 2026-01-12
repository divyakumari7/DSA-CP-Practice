package LeetCode.Daily_potd.Year26.January;

class Day12MinimumTimeVisitingAllPoints {

    /*
     * Problem:
     * Minimum Time Visiting All Points
     *
     * You are given a list of points on a 2D plane.
     * You start at the first point and must visit all points in order.
     *
     * In one second, you can move:
     * - vertically
     * - horizontally
     * - diagonally
     *
     * The task is to calculate the minimum time required
     * to visit all points in the given order.
     */

    // ----------------------------------------------------
    // Approach:
    // ----------------------------------------------------
    // For any two consecutive points:
    // (a, b) -> (x, y)
    //
    // - Horizontal distance = |a - x|
    // - Vertical distance   = |b - y|
    //
    // Since diagonal movement is allowed, we can cover
    // both x and y directions simultaneously.
    //
    // Therefore, the minimum time required to move between
    // two points is:
    //
    //      max(|a - x|, |b - y|)
    //
    // We compute this for every consecutive pair of points
    // and accumulate the total time.

    // ----------------------------------------------------
    // Time Complexity: O(N)
    // ----------------------------------------------------
    // - N = number of points
    // - We iterate through the points array once
    // - Each iteration performs constant-time operations
    //
    // Total Time Complexity = O(N)

    // ----------------------------------------------------
    // Space Complexity: O(1)
    // ----------------------------------------------------
    // - Only a few integer variables are used
    // - No extra data structures
    //
    // Auxiliary Space = O(1)

    public int minTimeToVisitAllPoints(int[][] points) {

        int total = 0;

        // Traverse all consecutive point pairs
        for (int i = 0; i < points.length - 1; i++) {

            // Current point coordinates
            int a = points[i][0];
            int b = points[i][1];

            // Next point coordinates
            int x = points[i + 1][0];
            int y = points[i + 1][1];

            /*
             * Since diagonal movement is allowed,
             * the minimum time required is the maximum
             * of horizontal and vertical distances.
             */
            total += Math.max(Math.abs(a - x), Math.abs(b - y));
        }

        return total;
    }
}
