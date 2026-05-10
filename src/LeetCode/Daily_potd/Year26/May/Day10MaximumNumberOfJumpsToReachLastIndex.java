package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day10MaximumNumberOfJumpsToReachLastIndex {

    static int [] dp;

    public static void main(String[] args) {

        Day10MaximumNumberOfJumpsToReachLastIndex sol = new Day10MaximumNumberOfJumpsToReachLastIndex();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {1, 3, 6, 4, 1, 2};
        int target1 = 2;
        System.out.println("Input: nums = [1,3,6,4,1,2], target = 2");
        System.out.println("Output: " + sol.maximumJumps(nums1, target1));
        System.out.println("Expected: 3\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {1, 2, 3, 4};
        int target2 = 0;
        System.out.println("Input: nums = [1,2,3,4], target = 0");
        System.out.println("Output: " + sol.maximumJumps(nums2, target2));
        System.out.println("Expected: -1");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:
    - From index idx, try all previous indices i
    - If valid jump:
        |nums[idx] - nums[i]| <= target
    - Take maximum jumps

    TC: O(2^n)
    SC: O(n)
    */

    /*
    public int find(int [] nums, int idx, int target){

        if(idx == 0) return 0;

        int max = -1001;

        for(int i = idx - 1 ; i >= 0 ; i--){

            int take = -1001;

            if(Math.abs(nums[idx] - nums[i]) <= target){
                take = 1 + find(nums, i, target);
            }

            max = Math.max(max, take);
        }

        return max;
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    TC: O(n^2)
    SC: O(n)
    */

    /*
    public int find(int [] nums, int idx, int target){

        if(dp[idx] != -1) return dp[idx];

        if(idx == 0) return 0;

        int max = -1001;

        for(int i = idx - 1 ; i >= 0 ; i--){

            int take = -1001;

            if(Math.abs(nums[idx] - nums[i]) <= target){
                take = 1 + find(nums, i, target);
            }

            max = Math.max(max, take);
        }

        return dp[idx] = max;
    }
    */


    /*
    ============================
    Approach 3: Tabulation (FINAL)
    ============================

    Idea:
    - dp[idx] = maximum jumps to reach idx
    - Try all previous indices

    TC: O(n^2)
    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for(int idx = 1 ; idx < n ; idx++){

            int max = -1001;

            for(int i = idx - 1 ; i >= 0 ; i--){

                int take = -1001;

                if(nums[idx] - nums[i] <= target && nums[idx] - nums[i] >= -target){
                    take = 1 + dp[i];
                }

                max = Math.max(max, take);
            }

            dp[idx] = max;
        }

        return dp[n - 1] < 0 ? -1 : dp[n - 1];
    }
}