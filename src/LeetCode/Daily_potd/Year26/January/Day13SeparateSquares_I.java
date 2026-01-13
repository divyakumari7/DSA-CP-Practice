package LeetCode.Daily_potd.Year26.January;

class Day13SeparateSquares_I {

    /*
     * Problem:
     * Separate Squares
     *
     * You are given multiple squares represented as:
     * [x, y, l] -> bottom-left corner (x, y) and side length l
     *
     * Find the minimum y-coordinate of a horizontal line such that
     * the total area of squares above the line is equal to the total
     * area of squares below the line.
     *
     * Overlapping areas are counted independently.
     */

    // ----------------------------------------------------
    // Approach:
    // ----------------------------------------------------
    // 1. First, determine the vertical search space:
    //    - lowest y-coordinate among all squares
    //    - highest y-coordinate (y + side length)
    //
    // 2. Compute the total area of all squares.
    //    The required area below the line is totalArea / 2.
    //
    // 3. Use Binary Search on the y-axis to find the smallest
    //    y-coordinate where the area below the line is at least half.
    //
    // 4. For a guessed y = mid:
    //    - Calculate how much area of each square lies below mid.
    //    - Sum it up.
    //
    // 5. Adjust binary search bounds based on comparison
    //    with required half area.
    //
    // 6. Stop when precision is within 1e-5.

    // ----------------------------------------------------
    // Time Complexity:
    // ----------------------------------------------------
    // Let:
    // - N = number of squares
    // - Binary search runs for a fixed precision (≈ log range)
    //
    // For each binary search step:
    // - We iterate over all squares → O(N)
    //
    // Total Time Complexity:
    // O(N * log(R))
    // where R is the vertical coordinate range
    // (log factor is small due to fixed precision)

    // ----------------------------------------------------
    // Space Complexity:
    // ----------------------------------------------------
    // O(1)
    // - Only constant extra variables are used
    // - No additional data structures

    public double separateSquares(int[][] squares) {

        double low = Integer.MAX_VALUE;
        double high = Integer.MIN_VALUE, mid = 0.0;
        double total = 0.0;

        // Determine search boundaries and total area
        for (int[] sq : squares) {
            low = Math.min(low, sq[1]);
            high = Math.max(high, sq[1] + sq[2]);
            total += (double) sq[2] * (double) sq[2];
        }

        double half = total / 2;

        // Binary search on y-coordinate
        while (high - low > 1e-5) {

            mid = low + (high - low) / 2;

            // Area below the horizontal line at height mid
            double below = get(squares, mid);

            if (below >= half) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    // ----------------------------------------------------
    // Helper Method:
    // ----------------------------------------------------
    // Calculates total area of all square portions
    // lying below the horizontal line at height = mid
    public double get(int[][] squares, double mid) {

        double below = 0.0;

        for (int[] sq : squares) {

            double yLow = (double) sq[1];
            double yHigh = (double) sq[1] + (double) sq[2];

            // Entire square is below the line
            if (mid >= yHigh) {
                below += (double) sq[2] * (double) sq[2];
            }
            // Partially intersecting the line
            else if (mid >= yLow && mid < yHigh) {
                below += (double) sq[2] * (double) (mid - yLow);
            }
        }

        return below;
    }
}
