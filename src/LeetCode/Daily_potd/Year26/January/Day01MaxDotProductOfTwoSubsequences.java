package LeetCode.Daily_potd.Year26.January;

public class Day01MaxDotProductOfTwoSubsequences {
    Integer [][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return solve(nums1, nums2, 0, 0);
    }
    public int solve(int[] nums1, int[] nums2, int i, int j){
        if(i == nums1.length || j == nums2.length) return -1_000_000_000;
        if(dp[i][j] != null) return dp[i][j];
        int prod = nums1[i] * nums2[j];
        int take_i_j = nums1[i] * nums2[j] + solve(nums1, nums2, i+1, j+1);
        int take_i = solve(nums1, nums2, i+1, j);
        int take_j = solve(nums1, nums2, i, j+1);

        return dp[i][j] = Math.max(Math.max(prod, take_i_j), Math.max(take_i, take_j));
    }
}
// Approach:
// Using top-down dynamic programming (recursion + memoization).
// At each position (i, j) in nums1 and nums2, we have four options:
// 1. Take both nums1[i] and nums2[j] in subsequence: nums1[i] * nums2[j] + solve(i+1, j+1)
// 2. Skip nums1[i]: solve(i+1, j)
// 3. Skip nums2[j]: solve(i, j+1)
// 4. Take only the product of current elements: nums1[i] * nums2[j]
// We memoize the results in dp[i][j] to avoid recomputation.

// Time Complexity: O(m * n)
//   - m = nums1.length, n = nums2.length
//   - Each state (i, j) is computed once, and each computation takes O(1)

// Space Complexity: O(m * n) for dp table + O(m + n) recursion stack
//   - Total ≈ O(m * n)
