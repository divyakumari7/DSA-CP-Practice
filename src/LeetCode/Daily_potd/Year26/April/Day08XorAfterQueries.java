package LeetCode.Daily_potd.Year26.April;

import java.util.*;

public class Day08XorAfterQueries {

    /*
     * ----------------------------------------------------
     * POTD Day 08 (April)
     * Problem:
     * XOR After Queries
     * ----------------------------------------------------
     *
     * Given:
     * - nums[] → initial array
     * - queries[][] → each query contains:
     *      [l, r, k, v]
     *
     * For each query:
     * - Start from index l
     * - Jump in steps of k until r
     * - Multiply nums[idx] by v (mod 1e9+7)
     *
     * Task:
     * After processing all queries,
     * return XOR of all elements in nums.
     *
     * ----------------------------------------------------
     * Approach:
     * ----------------------------------------------------
     * 1. Process each query one by one:
     *
     * 2. For a query [l, r, k, v]:
     *    - Start from index l
     *    - Keep jumping:
     *          idx += k
     *      until idx <= r
     *
     * 3. At each valid index:
     *    - Multiply nums[idx] with v
     *    - Take modulo (1e9+7) to avoid overflow
     *
     * 4. After all queries:
     *    - Compute XOR of entire array
     *
     * ----------------------------------------------------
     * Key Insight:
     * ----------------------------------------------------
     * - Each query updates only specific indices
     *   (controlled by step size k)
     *
     * - Direct simulation is used since
     *   pattern is non-contiguous
     *
     * - Modulo ensures values stay within int range
     *
     */


    public int xorAfterQueries(int[] nums, int[][] queries) {

        int n = nums.length;

        // Step 1: Process all queries
        for(int i = 0 ; i < queries.length ; i++){

            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            int idx = l;

            // Step 2: Update elements in steps of k
            while(idx <= r){

                nums[idx] = (int)(((long)nums[idx] * v) % 1_000_000_007);

                idx += k;
            }
        }

        // Step 3: Compute XOR of final array
        int ans = nums[0];

        for(int i = 1 ; i < n ; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }


    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Let:
     * Q = number of queries
     * N = size of array
     *
     * For each query:
     * - We traverse roughly (r - l)/k elements
     *
     * Worst case:
     * k = 1 → full traversal → O(N)
     *
     * So overall:
     * TC = O(Q * N)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(1)
     *
     * (In-place modification of array)
     *
     * ----------------------------------------------------
     * Why this works:
     * ----------------------------------------------------
     * - Each query directly updates required indices
     * - No extra data structures used
     * - Simple simulation approach
     *
     * ----------------------------------------------------
     * Limitation:
     * ----------------------------------------------------
     * - Not optimal for large Q and N
     * - Can be optimized using advanced techniques
     *   (like difference arrays / grouping by k)
     */
}