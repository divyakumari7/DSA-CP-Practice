package LeetCode.Daily_potd.Year26.January;

import java.util.*;

class Day16MaximumSquareAreaByRemovingFences {

    /*
     * Problem:
     * Maximum Square Area by Removing Fences From a Field
     *
     * You are given a rectangular field of size m x n.
     * Some horizontal and vertical fences can be removed.
     *
     * After removing fences, you want to form the largest possible square.
     * Return the area of the largest square modulo 1e9 + 7.
     * If no square can be formed, return -1.
     */

    // ----------------------------------------------------
    // Approach:
    // ----------------------------------------------------
    // 1. Collect all horizontal fence positions including boundaries (1 and m).
    // 2. Collect all vertical fence positions including boundaries (1 and n).
    //
    // 3. Compute all possible distances between every pair of horizontal fences.
    //    These distances represent all possible heights of rectangles.
    //
    // 4. Compute all possible distances between every pair of vertical fences.
    //    These distances represent all possible widths of rectangles.
    //
    // 5. Find the maximum distance that appears in BOTH sets.
    //    This common distance represents the side of the largest possible square.
    //
    // 6. Return square of that distance modulo 1e9 + 7.
    //    If no common distance exists, return -1.

    // ----------------------------------------------------
    // Time Complexity:
    // ----------------------------------------------------
    // Let:
    // - H = number of horizontal fences + 2 (boundaries)
    // - V = number of vertical fences + 2 (boundaries)
    //
    // Generating all horizontal distances: O(H^2)
    // Generating all vertical distances:   O(V^2)
    // Checking common distances:           O(H^2)
    //
    // Total Time Complexity:
    // O(H^2 + V^2)

    // ----------------------------------------------------
    // Space Complexity:
    // ----------------------------------------------------
    // - Horizontal distances set: O(H^2)
    // - Vertical distances set:   O(V^2)
    // - Fence lists:              O(H + V)
    //
    // Total Space Complexity:
    // O(H^2 + V^2)

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        List<Long> h = new ArrayList<>();
        List<Long> v = new ArrayList<>();

        // Add field boundaries
        h.add((long) 1);
        h.add((long) m);
        v.add((long) 1);
        v.add((long) n);

        // Add removable fences
        for (long x : hFences) h.add(x);
        for (long x : vFences) v.add(x);

        Set<Long> hh = new HashSet<>();
        Set<Long> vv = new HashSet<>();

        // Compute all possible horizontal distances
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hh.add(Math.abs(h.get(i) - h.get(j)));
            }
        }

        // Compute all possible vertical distances
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                vv.add(Math.abs(v.get(i) - v.get(j)));
            }
        }

        // Find the maximum common distance
        long max = -1;
        for (long x : hh) {
            if (vv.contains(x)) {
                max = Math.max(max, x);
            }
        }

        if (max == -1) return -1;

        return (int) ((max * max) % 1_000_000_007);
    }
}
