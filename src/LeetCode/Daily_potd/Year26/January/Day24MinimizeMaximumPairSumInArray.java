package LeetCode.Daily_potd.Year26.January;

import java.util.*;

public class Day24MinimizeMaximumPairSumInArray {

    /*
     * ----------------------------------------------------
     * POTD Day 24
     * Problem:
     * Minimize Maximum Pair Sum in Array
     * ----------------------------------------------------
     *
     * Given:
     * An integer array nums of even length.
     *
     * Task:
     * Pair up all elements such that the
     * maximum pair sum is minimized.
     *
     * Return the minimized maximum pair sum.
     *
     * ----------------------------------------------------
     * Key Observation:
     * ----------------------------------------------------
     * To minimize the maximum pair sum:
     *
     * - Pair the smallest element with the largest
     * - Pair the second smallest with the second largest
     * - Continue this process
     *
     * This balances large numbers with small ones
     * and prevents any pair from becoming too large.
     *
     * ----------------------------------------------------
     * Greedy Insight:
     * ----------------------------------------------------
     * If we pair two large numbers together,
     * the pair sum increases unnecessarily.
     *
     * Pairing smallest + largest guarantees
     * the lowest possible maximum among all pairs.
     */

    public int minPairSum(int[] nums) {

        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        int i = 0;          // Pointer to smallest element
        int j = n - 1;      // Pointer to largest element
        int maxPairSum = 0;

        // Step 2: Form pairs using two-pointer technique
        while (i < j) {

            // Current pair sum
            int pairSum = nums[i] + nums[j];

            // Update maximum pair sum
            maxPairSum = Math.max(maxPairSum, pairSum);

            // Move pointers inward
            i++;
            j--;
        }

        return maxPairSum;
    }

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Sorting: O(N log N)
     * Pairing traversal: O(N)
     *
     * Overall TC: O(N log N)
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
     * Greedy pairing ensures the maximum pair
     * is as small as possible.
     */
}
