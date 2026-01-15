package LeetCode.Daily_potd.Year26.January;

import java.util.*;

class Day15MaximizeSquareHoleArea {

    /*
     * Problem:
     * Maximize the Area of Square Hole in Grid
     *
     * You are given a grid of size n x m with some horizontal and vertical bars removed.
     * By removing consecutive bars, you can form square holes.
     *
     * The task is to find the maximum possible area of a square hole.
     */

    // ----------------------------------------------------
    // Approach:
    // ----------------------------------------------------
    // 1. A square hole can only be formed if:
    //    - There are consecutive removed horizontal bars
    //    - There are consecutive removed vertical bars
    //
    // 2. The side length of the square is determined by:
    //    - Maximum consecutive horizontal bars removed + 1
    //    - Maximum consecutive vertical bars removed + 1
    //
    // 3. The maximum possible square side is:
    //        min(maxHorizontalGap, maxVerticalGap)
    //
    // 4. The required answer is:
    //        (side length)²

    // ----------------------------------------------------
    // Time Complexity:
    // ----------------------------------------------------
    // Let:
    // - H = number of horizontal bars removed
    // - V = number of vertical bars removed
    //
    // Sorting horizontal bars: O(H log H)
    // Sorting vertical bars:   O(V log V)
    //
    // Total Time Complexity:
    // O(H log H + V log V)

    // ----------------------------------------------------
    // Space Complexity:
    // ----------------------------------------------------
    // O(1) extra space
    // - Sorting is done in-place
    // - Only constant variables are used

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        // Find maximum consecutive horizontal bars removed
        int maxh = calculate(hBars);

        // Find maximum consecutive vertical bars removed
        int maxv = calculate(vBars);

        // Square side is limited by the smaller direction
        int min = Math.min(maxh, maxv);

        // Return area of the square
        return min * min;
    }

    // ----------------------------------------------------
    // Helper Method:
    // ----------------------------------------------------
    // Calculates maximum consecutive bars removed in one direction
    public int calculate(int[] arr) {

        Arrays.sort(arr);

        int count = 1;
        int max = 1;

        for (int i = 0; i < arr.length - 1; i++) {

            // Check if bars are consecutive
            if (arr[i] + 1 == arr[i + 1]) {
                count++;
            } else {
                count = 1;
            }

            max = Math.max(max, count);
        }

        // +1 because bars create gaps between grid lines
        return max + 1;
    }
}
