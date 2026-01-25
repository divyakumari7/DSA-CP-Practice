package LeetCode.Daily_potd.Year26.January;

import java.util.*;

public class Day25MinimumDifferenceBetweenHighestAndLowestOfKScores {

    /*
     * ----------------------------------------------------
     * POTD Day 25
     * Problem:
     * Minimum Difference Between Highest and Lowest
     * of K Scores
     * ----------------------------------------------------
     *
     * Given:
     * An integer array nums[] and an integer k.
     *
     * Task:
     * Select any k elements such that the difference
     * between the maximum and minimum among them
     * is minimized.
     *
     * Return this minimum difference.
     *
     * ----------------------------------------------------
     * Key Observation:
     * ----------------------------------------------------
     * If the array is sorted:
     * - Any group of k consecutive elements will have
     *   the smallest possible max–min difference
     *   for that window.
     *
     * So the problem reduces to checking all
     * subarrays of size k in the sorted array.
     *
     * ----------------------------------------------------
     * Sliding Window Insight:
     * ----------------------------------------------------
     * After sorting:
     * For each window of size k:
     *
     * Difference = nums[i + k - 1] - nums[i]
     *
     * The minimum among all such differences
     * is the answer.
     */

    public int minimumDifference(int[] nums, int k) {

        int n = nums.length;
        int max = Integer.MAX_VALUE;

        // Edge case: only one score
        if (n == 1) return 0;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Slide window of size k
        for (int i = 0; i <= n - k; i++) {

            // Difference between highest and lowest in window
            max = Math.min(max, nums[i + k - 1] - nums[i]);
        }

        return max;
    }

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Sorting: O(N log N)
     * Sliding window traversal: O(N)
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
     * Sorting groups close values together.
     * Checking consecutive windows guarantees
     * the minimum possible score difference.
     */
}
