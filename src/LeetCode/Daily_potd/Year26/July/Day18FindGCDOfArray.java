package LeetCode.Daily_potd.Year26.July;

public class Day18FindGCDOfArray {

    public static void main(String[] args) {

        Day18FindGCDOfArray sol =
                new Day18FindGCDOfArray();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {2, 5, 6, 9, 10};

        System.out.println("Input: [2,5,6,9,10]");
        System.out.println("Output: " + sol.findGCD(nums1));
        System.out.println("Expected: 2\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {7, 5, 6, 8, 3};

        System.out.println("Input: [7,5,6,8,3]");
        System.out.println("Output: " + sol.findGCD(nums2));
        System.out.println("Expected: 1\n");

        // ============================
        // Test Case 3
        // ============================
        int[] nums3 = {3, 3};

        System.out.println("Input: [3,3]");
        System.out.println("Output: " + sol.findGCD(nums3));
        System.out.println("Expected: 3");
    }


    /*
    ============================
    POTD 18 July
    Find Greatest Common Divisor
    of Array
    ============================

    Problem:

    Given an integer array nums.

    Find

    - Minimum element
    - Maximum element

    Return the Greatest Common
    Divisor (GCD) of these
    two numbers.
    */


    /*
    ============================
    Approach 1:
    Brute Force
    ============================

    Idea:

    Find the minimum and
    maximum element.

    Check every number from

    2 to maximum.

    If a number divides both,

    update the answer.

    The last valid divisor
    will be the GCD.

    TC:

    O(n + maxElement)

    SC:

    O(1)
    */


    /*
    public int findGCD(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        for(int num : nums){

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int gcd = 0;

        for(int i = 2 ; i <= max ; i++){

            if(min % i == 0 &&
               max % i == 0){

                gcd = i;
            }
        }

        if(gcd == 0)
            return 1;

        return gcd;
    }
    */


    /*
    ============================
    Approach 2:
    Euclid's Algorithm
    ============================

    Idea:

    First find

    minimum

    and

    maximum.

    Then compute

    gcd(min, max)

    using Euclid's Algorithm.

    Euclid's Algorithm:

    gcd(a, b)

    = gcd(b, a % b)

    until b becomes 0.

    TC:

    O(n + log(max))

    SC:

    O(log(max))
    (Recursive Stack)
    */


    // ============================
    // Euclid's Algorithm
    // ============================

    public int gcd(int a, int b){

        if(b == 0)
            return a;

        return gcd(b, a % b);
    }


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int findGCD(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        for(int num : nums){

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return gcd(max, min);
    }
}


/*
============================
Dry Run
============================

Input

nums = [2,5,6,9,10]

Minimum

2

Maximum

10

Find

gcd(10,2)

10 % 2 = 0

Answer

2


============================
Complexities
============================

Brute Force

TC:

O(n + maxElement)

SC:

O(1)


Euclid's Algorithm

TC:

O(n + log(max))

SC:

O(log(max))


============================
Pattern Used
============================

1. Mathematics

2. Euclid's Algorithm

3. Array Traversal

4. Simulation


Best Approach:

Find the minimum and
maximum element, then
apply Euclid's Algorithm
to compute the GCD.

 */