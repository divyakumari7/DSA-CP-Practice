package LeetCode.Daily_potd.Year26.January;

import java.util.*;

public class Day21ConstructTheMinimumBitwiseArray_II {

    /*
     * ----------------------------------------------------
     * POTD Day 21
     * Problem:
     * Minimum Bitwise Array
     * ----------------------------------------------------
     *
     * Given:
     * nums[] where each number is a PRIME.
     *
     * For each number `req`, find the smallest integer `j`
     * such that:
     *
     *      (j | (j + 1)) == req
     *
     * If no such `j` exists, return -1.
     *
     * ----------------------------------------------------
     * Key Observations:
     * ----------------------------------------------------
     * 1. (j | (j + 1)) always produces an ODD number.
     * 2. Among primes, only 2 is EVEN.
     *    → So for req = 2, answer is always -1.
     *
     * 3. For any odd prime `req`, a valid `j` always exists.
     *
     * ----------------------------------------------------
     * Optimized Bit-Manipulation Insight:
     * ----------------------------------------------------
     * If:
     *      (j | (j + 1)) = req
     *
     * Then:
     * - req ends with consecutive 1s in binary
     * - req + 1 flips those trailing 1s to 0
     *
     * The lowest set bit of (req + 1) tells us
     * how many trailing 1s were present.
     *
     * Let:
     *      x = req + 1
     *      lowestPower = x & (-x)
     *
     * Then the minimum valid j is:
     *
     *      j = req - (lowestPower / 2)
     *
     * ----------------------------------------------------
     * One-line Mathematical Reasoning (for primes):
     * ----------------------------------------------------
     * Since odd primes end with binary 1, removing half of
     * the lowest power-of-two factor from (req + 1)
     * reconstructs the smallest j.
     */

    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];

        // Process each number independently
        for (int i = 0; i < n; i++) {

            int req = nums.get(i);

            // Prime 2 is the only even prime → no solution
            if (req == 2) {
                ans[i] = -1;
                continue;
            }

            // Step 1: Increment req
            int x = req + 1;

            // Step 2: Extract lowest power of 2 from x
            int lowestPower = x & (-x);

            // Step 3: Compute minimum j
            ans[i] = req - (lowestPower / 2);
        }

        return ans;
    }

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * O(N)
     * Each element is processed in constant time.
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(N)
     * Result array storage.
     *
     * ----------------------------------------------------
     * Why this beats brute force:
     * ----------------------------------------------------
     * Brute force tries many j values per req.
     * This solution derives j directly using bit math.
     */
}
