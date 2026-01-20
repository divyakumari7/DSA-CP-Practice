package LeetCode.Daily_potd.Year26.January;

import java.util.*;

public class Day20ConstructTheMinimumBitwiseArray_I {

    /*
     * ----------------------------------------------------
     * POTD Day 20
     * Problem:
     * Minimum Bitwise Array
     * ----------------------------------------------------
     *
     * Important Constraint:
     * ----------------------------------------------------
     * - The given array `nums` contains ONLY prime numbers.
     *
     * - Since all prime numbers (except 2) are odd,
     *   this significantly affects bitwise behavior.
     *
     * - Prime number 2 is the ONLY even prime and
     *   becomes a special edge case in this problem.
     *
     * ----------------------------------------------------
     * Approach:
     * ----------------------------------------------------
     * For each number `req` in the input list:
     *
     * 1. We need to find the smallest integer `j` such that:
     *        (j | (j + 1)) == req
     *
     * 2. If `req == 2`:
     *    - 2 is the only even prime
     *    - No such `j` exists for which (j | j+1) = 2
     *    - Hence, store -1
     *
     * 3. For all other primes:
     *    - They are odd numbers
     *    - Try values of `j` starting from 1
     *    - The first `j` satisfying:
     *          (j | (j + 1)) == req
     *      is the minimum possible answer
     *
     * 4. Store results in the output array.
     *
     * Note:
     * ----------------------------------------------------
     * This brute-force approach works because:
     * - Prime constraints reduce search space
     * - Upper bound on j is small (≤ 1000)
     */

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Let N = size of nums
     *
     * For each prime number:
     * - We try up to 1000 values of j
     *
     * TC = O(N * 1000) ≈ O(N)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(N)
     * Output array storage
     */

    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];
        int k = 0;

        // Traverse each prime number in the list
        for (int i = 0; i < n; i++) {

            int req = nums.get(i);

            // Special case: 2 is the only even prime
            if (req == 2) {
                ans[k++] = -1;
            }
            else {

                // Find smallest j such that (j | (j + 1)) == req
                for (int j = 1; j < 1000; j++) {

                    if ((j | j + 1) == req) {
                        ans[k++] = j;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}

