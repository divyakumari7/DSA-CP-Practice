package LeetCode.Daily_potd.Year26.July;

import java.util.ArrayList;
import java.util.List;

public class Day13SequentialDigits {

    public static void main(String[] args) {

        Day13SequentialDigits sol =
                new Day13SequentialDigits();

        // ============================
        // Test Case 1
        // ============================
        int low1 = 100;
        int high1 = 300;

        System.out.println("Input: low = 100, high = 300");
        System.out.println("Output: " + sol.sequentialDigits(low1, high1));
        System.out.println("Expected: [123, 234]\n");

        // ============================
        // Test Case 2
        // ============================
        int low2 = 1000;
        int high2 = 13000;

        System.out.println("Input: low = 1000, high = 13000");
        System.out.println("Output: " + sol.sequentialDigits(low2, high2));
        System.out.println("Expected: [1234,2345,3456,4567,5678,6789,12345]");
    }

    /*
    ============================
    POTD 13 July
    Sequential Digits
    ============================

    Problem:

    A sequential digit number is a number
    in which every digit is exactly one
    greater than the previous digit.

    Examples:

    123
    4567
    6789

    Given:

    low and high

    Return all sequential digit numbers
    in the range [low, high].
    */


    /*
    ============================
    Approach: Precomputation
    ============================

    Idea:

    There are only 36 sequential-digit
    numbers possible.

    Precompute all of them once using
    a static block.

    Start with digits:

    1,2,3,...,9

    For every number:

    lastDigit = number % 10

    If lastDigit < 9

    append (lastDigit + 1)

    Example:

    12 -> 123

    456 -> 4567

    After precomputation,
    simply iterate through all numbers
    and collect those lying in
    [low, high].

    TC: O(1)

    SC: O(1)
    */


    // ============================
    // Precomputed Sequential Digits
    // ============================

    static final int[] all = new int[45];

    static {

        int n = 0;

        // Single-digit numbers
        for(int i = 1; i < 10; i++) {
            all[n++] = i;
        }

        // Generate larger sequential numbers
        for(int i = 0; i < n; i++) {

            int lastDigit = all[i] % 10;

            if(lastDigit < 9) {
                all[n++] =
                        all[i] * 10 + lastDigit + 1;
            }
        }
    }


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();

        for(int num : all) {

            if(num >= low && num <= high) {
                result.add(num);
            }
        }

        return result;
    }
}


/*
============================
Dry Run
============================

Input:

low = 100
high = 300

Precomputed numbers:

1
2
...
12
23
34
...
123
234
345
...

Check range:

123 ✓

234 ✓

345 ✗

Answer:

[123, 234]


============================
Complexities
============================

Time Complexity:

O(1)

(Only 45 precomputed numbers are checked.)

Space Complexity:

O(1)


============================
Pattern Used
============================

1. Precomputation
2. Simulation
3. Array Traversal

Best Approach:

Precompute all sequential-digit
numbers once and answer every
query in constant time.
*/
