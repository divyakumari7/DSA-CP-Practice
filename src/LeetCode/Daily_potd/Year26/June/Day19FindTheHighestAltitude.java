package LeetCode.Daily_potd.Year26.June;

public class Day19FindTheHighestAltitude {

    public static void main(String[] args) {

        Day19FindTheHighestAltitude sol =
                new Day19FindTheHighestAltitude();

        // ============================
        // Test Case 1
        // ============================
        int[] gain1 = {-5, 1, 5, 0, -7};

        System.out.println("Input: [-5,1,5,0,-7]");
        System.out.println("Output: " + sol.largestAltitude(gain1));
        System.out.println("Expected: 1\n");

        // ============================
        // Test Case 2
        // ============================
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};

        System.out.println("Input: [-4,-3,-2,-1,4,3,2]");
        System.out.println("Output: " + sol.largestAltitude(gain2));
        System.out.println("Expected: 0");
    }


    /*
    ============================
    POTD Day 19 June
    Find the Highest Altitude
    ============================

    Given:
    - gain[i] represents altitude change
      between point i and i + 1

    Initial Altitude:
    0

    Task:
    Return the highest altitude reached.

    Example:

    gain = [-5,1,5,0,-7]

    Altitudes:

    0
    -5
    -4
    1
    1
    -6

    Highest Altitude = 1
    */


    /*
    ============================
    Approach 1: Prefix Sum Array
    ============================

    Idea:

    Build altitude at every point.

    altitude[i]
    = altitude[i - 1] + gain[i - 1]

    Keep track of maximum altitude.

    TC: O(n)

    SC: O(n)
    */

    /*
    public int largestAltitude(int[] gain) {

        int n = gain.length;

        int[] altitude = new int[n + 1];

        int maxAltitude = 0;

        for(int i = 1 ; i <= n ; i++){

            altitude[i] =
                    altitude[i - 1] + gain[i - 1];

            maxAltitude =
                    Math.max(maxAltitude, altitude[i]);
        }

        return maxAltitude;
    }
    */


    /*
    ============================
    Approach 2: Space Optimized
    ============================

    Idea:

    We only need:

    - Current altitude
    - Maximum altitude

    No need to store entire prefix array.

    TC: O(n)

    SC: O(1)

    Preferred Approach
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int largestAltitude(int[] gain) {

        int n = gain.length;

        int currentAltitude = 0;
        int maxAltitude = 0;

        for(int i = 0 ; i < n ; i++) {

            currentAltitude += gain[i];

            maxAltitude =
                    Math.max(maxAltitude,
                            currentAltitude);
        }

        return maxAltitude;
    }
}


/*
============================
Dry Run
============================

Input:

gain = [-5,1,5,0,-7]

Initial:

currentAltitude = 0
maxAltitude = 0

--------------------------------

gain = -5

currentAltitude = -5

maxAltitude = 0

--------------------------------

gain = 1

currentAltitude = -4

maxAltitude = 0

--------------------------------

gain = 5

currentAltitude = 1

maxAltitude = 1

--------------------------------

gain = 0

currentAltitude = 1

maxAltitude = 1

--------------------------------

gain = -7

currentAltitude = -6

maxAltitude = 1

--------------------------------

Answer:

1


============================
Complexities
============================

Approach 1
(Prefix Sum Array)

TC: O(n)

SC: O(n)


Approach 2
(Space Optimized)

TC: O(n)

SC: O(1)


============================
Pattern Used
============================

1. Prefix Sum

2. Running Sum

3. Array Traversal

4. Space Optimization


Best Approach:
Space Optimized Prefix Sum
*/