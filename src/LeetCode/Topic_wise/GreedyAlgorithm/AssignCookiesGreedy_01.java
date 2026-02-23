package LeetCode.Topic_wise.GreedyAlgorithm;
import java.util.*;

public class AssignCookiesGreedy_01 {

    /*
     * ----------------------------------------------------
     * 01 Greedy Practice
     * Problem:
     * Assign Cookies
     * ----------------------------------------------------
     *
     * Given:
     * g[] → greed factor of children
     * s[] → sizes of cookies
     *
     * Each child can receive at most one cookie.
     * A child is satisfied if:
     *
     *      cookie_size >= greed_factor
     *
     * Task:
     * Return the maximum number of satisfied children.
     *
     * ----------------------------------------------------
     * Greedy Strategy:
     * ----------------------------------------------------
     * Always try to satisfy the least greedy child first
     * using the smallest available cookie.
     *
     * Why?
     * - Small cookies cannot satisfy highly greedy children.
     * - So we reserve larger cookies for larger greed.
     *
     * This local optimal choice leads to global maximum.
     */

    public int findContentChildren(int[] g, int[] s) {

        // Edge case: no cookies available
        if (s.length == 0) return 0;

        // Step 1: Sort both arrays
        Arrays.sort(g);   // sort greed factors
        Arrays.sort(s);   // sort cookie sizes

        int i = 0;  // pointer for children
        int j = 0;  // pointer for cookies

        /*
         * Step 2:
         * Try to satisfy children one by one
         * using available cookies.
         */
        while (j < s.length && i < g.length) {

            // If current cookie can satisfy current child
            if (g[i] <= s[j]) {
                i++;  // child satisfied
            }

            // Move to next cookie
            j++;
        }

        // i represents total satisfied children
        return i;
    }

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Sorting g: O(N log N)
     * Sorting s: O(M log M)
     * Two-pointer traversal: O(N + M)
     *
     * Overall TC: O(N log N + M log M)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(1)
     * (Ignoring sorting internal space)
     *
     * ----------------------------------------------------
     * Why this works:
     * ----------------------------------------------------
     * Greedy choice:
     * Always satisfy the smallest greed first.
     *
     * This prevents wasting large cookies
     * on small greed values.
     */
}