package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day01RotateFunction {

    public static void main(String[] args) {

        Day01RotateFunction sol = new Day01RotateFunction();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {4, 3, 2, 6};
        System.out.println("Input: [4,3,2,6]");
        System.out.println("Output: " + sol.maxRotateFunction(nums1));
        System.out.println("Expected: 26\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {100};
        System.out.println("Input: [100]");
        System.out.println("Output: " + sol.maxRotateFunction(nums2));
        System.out.println("Expected: 0");
    }


    /*
    ============================
    Approach 1: Brute Force
    ============================

    Idea:
    - Generate every rotation
    - For each rotation, calculate:
        F(k) = 0 * arr[0] + 1 * arr[1] + ... + (n-1) * arr[n-1]
    - Track maximum value

    TC: O(n^2)
    SC: O(1)

    public int maxRotateFunction(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int k = 0 ; k < n ; k++){

            int value = 0;

            for(int i = 0 ; i < n ; i++){
                int index = (i + k) % n;
                value += i * nums[index];
            }

            max = Math.max(max, value);
        }

        return max;
    }
    */


    /*
    ============================
    Approach 2: Optimized Formula (FINAL)
    ============================

    Idea:
    - First calculate:
        sum = nums[0] + nums[1] + ... + nums[n-1]
        prev = F(0)

    - Relation between rotations:
        F(k) = F(k-1) + sum - n * nums[n-k]

    - This helps calculate next rotation in O(1)

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int maxRotateFunction(int[] nums) {

        int n = nums.length;

        int sum = 0, prev = 0;

        // Calculate total sum and F(0)
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            prev += i * nums[i];
        }

        int max = prev;

        // Calculate F(1), F(2), ... using formula
        for(int i = 1 ; i < n ; i++){

            int curr = prev + sum - n * nums[n - i];

            max = Math.max(max, curr);

            prev = curr;
        }

        return max;
    }
}