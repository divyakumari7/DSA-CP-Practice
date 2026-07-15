package LeetCode.Daily_potd.Year26.July;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day12RankTransformOfAnArray {

    public static void main(String[] args) {

        Day12RankTransformOfAnArray sol =
                new Day12RankTransformOfAnArray();

        // ============================
        // Test Case 1
        // ============================
        int[] arr1 = {40, 10, 20, 30};

        System.out.println("Input: [40,10,20,30]");
        System.out.println("Output: " +
                Arrays.toString(sol.arrayRankTransform(arr1)));
        System.out.println("Expected: [4,1,2,3]\n");

        // ============================
        // Test Case 2
        // ============================
        int[] arr2 = {100, 100, 100};

        System.out.println("Input: [100,100,100]");
        System.out.println("Output: " +
                Arrays.toString(sol.arrayRankTransform(arr2)));
        System.out.println("Expected: [1,1,1]\n");

        // ============================
        // Test Case 3
        // ============================
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};

        System.out.println("Input: [37,12,28,9,100,56,80,5,12]");
        System.out.println("Output: " +
                Arrays.toString(sol.arrayRankTransform(arr3)));
        System.out.println("Expected: [5,3,4,2,8,6,7,1,3]");
    }


    /*
    ============================
    POTD 12 July
    Rank Transform of an Array
    ============================

    Problem:

    Given an integer array arr.

    Replace each element with its rank.

    Rules:

    - Rank starts from 1.
    - Larger number → larger rank.
    - Equal numbers have the same rank.
    - Rank should be as small as possible.
    */


    /*
    ============================
    Approach: Sorting + HashMap
    ============================

    Idea:

    1. Copy the original array.
    2. Sort the copied array.
    3. Assign ranks to unique elements.
    4. Replace every original element
       with its assigned rank.

    Example:

    arr = [40,10,20,30]

    Sorted:

    [10,20,30,40]

    Map:

    10 -> 1
    20 -> 2
    30 -> 3
    40 -> 4

    Result:

    [4,1,2,3]

    TC: O(n log n)

    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        int[] sorted = Arrays.copyOf(arr, n);

        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap =
                new HashMap<>();

        for(int i = 0; i < n; i++) {

            rankMap.putIfAbsent(
                    sorted[i],
                    rankMap.size() + 1
            );
        }

        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {

            answer[i] =
                    rankMap.get(arr[i]);
        }

        return answer;
    }
}


/*
============================
Dry Run
============================

Input:

arr = [40,10,20,30]

Step 1:

Copy array

[40,10,20,30]

Step 2:

Sort copy

[10,20,30,40]

Step 3:

Assign ranks

10 -> 1

20 -> 2

30 -> 3

40 -> 4

Step 4:

Replace elements

40 -> 4

10 -> 1

20 -> 2

30 -> 3

Answer:

[4,1,2,3]


============================
Complexities
============================

Time Complexity:

O(n log n)

Sorting dominates the complexity.

Space Complexity:

O(n)

For copied array and HashMap.


============================
Pattern Used
============================

1. Sorting
2. HashMap
3. Coordinate Compression
4. Array Traversal

Best Approach:

Sort unique values, assign ranks
using a HashMap, then transform
the original array.
*/