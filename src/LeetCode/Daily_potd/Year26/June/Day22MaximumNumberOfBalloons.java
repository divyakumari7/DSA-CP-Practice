package LeetCode.Daily_potd.Year26.June;

public class Day22MaximumNumberOfBalloons {

    public static void main(String[] args) {

        Day22MaximumNumberOfBalloons sol =
                new Day22MaximumNumberOfBalloons();

        // ============================
        // Test Case 1
        // ============================
        String text1 = "nlaebolko";

        System.out.println("Input: \"nlaebolko\"");
        System.out.println("Output: " + sol.maxNumberOfBalloons(text1));
        System.out.println("Expected: 1\n");

        // ============================
        // Test Case 2
        // ============================
        String text2 = "loonbalxballpoon";

        System.out.println("Input: \"loonbalxballpoon\"");
        System.out.println("Output: " + sol.maxNumberOfBalloons(text2));
        System.out.println("Expected: 2\n");

        // ============================
        // Test Case 3
        // ============================
        String text3 = "leetcode";

        System.out.println("Input: \"leetcode\"");
        System.out.println("Output: " + sol.maxNumberOfBalloons(text3));
        System.out.println("Expected: 0");
    }

    /*
    ============================
    POTD 22 June
    Maximum Number of Balloons
    ============================

    Problem:

    Given a string text.

    We need to form the word:

    "balloon"

    as many times as possible.

    Each character can be used only once.

    Return the maximum number of times
    we can form "balloon".
    */


    /*
    ============================
    Approach: Character Counting
    ============================

    Idea:

    Count occurrences of:

    b, a, l, o, n

    balloon contains:

    b -> 1
    a -> 1
    l -> 2
    o -> 2
    n -> 1

    Therefore:

    answer =
    minimum of

    b
    a
    l / 2
    o / 2
    n

    TC: O(n)

    SC: O(1)
    */

    public int maxNumberOfBalloons(String text) {

        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        for(char ch : text.toCharArray()) {

            if(ch == 'b') b++;
            if(ch == 'a') a++;
            if(ch == 'l') l++;
            if(ch == 'o') o++;
            if(ch == 'n') n++;
        }

        return Math.min(
                a,
                Math.min(
                        n,
                        Math.min(
                                b,
                                Math.min(l / 2, o / 2)
                        )
                )
        );
    }
}


/*
============================
Dry Run
============================

Input:

text = "loonbalxballpoon"

Counts:

b = 2
a = 2
l = 4
o = 4
n = 2

Required:

b = 2
a = 2
l/2 = 2
o/2 = 2
n = 2

Answer:

min(2,2,2,2,2) = 2


============================
Complexities
============================

Time Complexity:
O(n)

Space Complexity:
O(1)


============================
Pattern Used
============================

1. Character Frequency Counting
2. String Traversal
3. Greedy Observation

Best Approach:
Count required characters and
find the limiting frequency.
*/