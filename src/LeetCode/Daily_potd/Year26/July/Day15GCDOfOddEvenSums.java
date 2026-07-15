package LeetCode.Daily_potd.Year26.July;

public class Day15GCDOfOddEvenSums {

    public static void main(String[] args) {

        Day15GCDOfOddEvenSums sol =
                new Day15GCDOfOddEvenSums();

        // ============================
        // Test Case 1
        // ============================
        int n1 = 1;

        System.out.println("Input: n = 1");
        System.out.println("Output: " + sol.gcdOfOddEvenSums(n1));
        System.out.println("Expected: 1\n");

        // ============================
        // Test Case 2
        // ============================
        int n2 = 2;

        System.out.println("Input: n = 2");
        System.out.println("Output: " + sol.gcdOfOddEvenSums(n2));
        System.out.println("Expected: 2\n");

        // ============================
        // Test Case 3
        // ============================
        int n3 = 5;

        System.out.println("Input: n = 5");
        System.out.println("Output: " + sol.gcdOfOddEvenSums(n3));
        System.out.println("Expected: 5");
    }


    /*
    ============================
    POTD 15 July
    GCD of Odd and Even Sums
    ============================

    Problem:

    Given an integer n.

    Consider:

    - Sum of first n odd numbers.
    - Sum of first n even numbers.

    Return the GCD of these two sums.


    Observation:

    Sum of first n odd numbers

    = n²

    Sum of first n even numbers

    = n(n + 1)

    Therefore,

    Find:

    gcd(n², n(n + 1))
    */


    /*
    ============================
    Approach: Mathematical Formula
    ============================

    Idea:

    Compute:

    sumOdd = n²

    sumEven = n² + n

    Then apply Euclid's Algorithm
    to compute their GCD.

    Euclid's Algorithm:

    gcd(a, b)

    = gcd(b, a % b)

    until b becomes 0.

    TC: O(log n)

    SC: O(log n)
    (recursive stack)
    */


    // ============================
    // Euclid's Algorithm
    // ============================

    public static int gcd(int a, int b) {

        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int gcdOfOddEvenSums(int n) {

        int sumOdd = n * n;

        int sumEven = n * n + n;

        return gcd(sumOdd, sumEven);
    }
}


/*
============================
Dry Run
============================

Input:

n = 5

Sum of first 5 odd numbers

= 1 + 3 + 5 + 7 + 9

= 25

Sum of first 5 even numbers

= 2 + 4 + 6 + 8 + 10

= 30

Find:

gcd(25, 30)

30 % 25 = 5

25 % 5 = 0

Answer:

5


============================
Complexities
============================

Time Complexity:

O(log n)

Euclid's Algorithm takes
logarithmic time.

Space Complexity:

O(log n)

Recursive call stack.


============================
Pattern Used
============================

1. Mathematics
2. Formula Derivation
3. Euclid's Algorithm (GCD)
4. Recursion

Best Approach:

Use mathematical formulas for
odd/even sums and compute GCD
using Euclid's Algorithm.
*/