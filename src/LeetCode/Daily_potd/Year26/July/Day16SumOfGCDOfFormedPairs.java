package LeetCode.Daily_potd.Year26.July;

import java.util.*;

public class Day16SumOfGCDOfFormedPairs {

    public static void main(String[] args) {

        Day16SumOfGCDOfFormedPairs sol =
                new Day16SumOfGCDOfFormedPairs();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {2, 4, 6, 8};

        System.out.println("Input: [2,4,6,8]");
        System.out.println("Output: " + sol.gcdSum(nums1));
        System.out.println("Expected: 4\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {3, 6, 9, 12, 15, 18};

        System.out.println("Input: [3,6,9,12,15,18]");
        System.out.println("Output: " + sol.gcdSum(nums2));
        System.out.println("Expected: Depends on formed pairs\n");

        // ============================
        // Test Case 3
        // ============================
        int[] nums3 = {5, 10};

        System.out.println("Input: [5,10]");
        System.out.println("Output: " + sol.gcdSum(nums3));
    }


    /*
    ============================
    POTD 16 July
    Sum of GCD of Formed Pairs
    ============================

    Problem:

    Given an integer array nums.

    Step 1:

    Construct a new array where

    prefixGcd[i]

    = gcd(max element seen so far,
          nums[i])

    Step 2:

    Sort the new array.

    Step 3:

    Pair

    smallest with largest,

    second smallest with
    second largest,

    and so on.

    Return the sum of the
    GCD of every formed pair.
    */


    /*
    ============================
    Approach:
    Prefix GCD + Sorting
    ============================

    Idea:

    Maintain the maximum element
    encountered so far.

    For every element,

    compute

    gcd(maxSoFar, nums[i])

    Store these values in a
    new array.

    Sort the array.

    Use two pointers

    left -> smallest

    right -> largest

    Compute GCD of every pair
    and add to the answer.

    TC:

    O(n log n)

    SC:

    O(n)
    */


    // ============================
    // Euclid's Algorithm
    // ============================

    public long gcd(long a, long b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public long gcdSum(int[] nums) {

        int n = nums.length;

        long max = 0;

        long[] prefixGcd = new long[n];

        for (int i = 0; i < n; i++) {

            max = Math.max(max, nums[i]);

            prefixGcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {

            sum += gcd(prefixGcd[left],
                    prefixGcd[right]);

            left++;
            right--;
        }

        return sum;
    }
}


/*
============================
Dry Run
============================

Input

nums = [2,4,6,8]

Step 1

Maximum seen so far

2

4

6

8

prefixGcd

gcd(2,2) = 2

gcd(4,4) = 4

gcd(6,6) = 6

gcd(8,8) = 8

Array

[2,4,6,8]

After Sorting

[2,4,6,8]

Form Pairs

(2,8)

gcd = 2

(4,6)

gcd = 2

Answer

2 + 2 = 4


============================
Complexities
============================

Time Complexity

Building prefix array

O(n)

Sorting

O(n log n)

Pairing

O(n)

Overall

O(n log n)


Space Complexity

O(n)


============================
Pattern Used
============================

1. Mathematics

2. Euclid's Algorithm (GCD)

3. Prefix Processing

4. Sorting

5. Two Pointers


Best Approach:

Construct the prefix GCD array,
sort it,
and use two pointers to
form optimal pairs.
 */