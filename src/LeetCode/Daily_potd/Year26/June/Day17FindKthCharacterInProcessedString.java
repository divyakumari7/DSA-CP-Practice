package LeetCode.Daily_potd.Year26.June;

public class Day17FindKthCharacterInProcessedString {

    public static void main(String[] args) {

        Day17FindKthCharacterInProcessedString sol =
                new Day17FindKthCharacterInProcessedString();

        // ============================
        // Test Case 1
        // ============================
        String s1 = "ab#";
        long k1 = 3;

        System.out.println("Input: s = \"ab#\", k = 3");
        System.out.println("Output: " + sol.processStr(s1, k1));
        System.out.println("Expected: b\n");

        // Process:
        // "ab" -> "abab"
        // index: 0 1 2 3
        // chars: a b a b

        // ============================
        // Test Case 2
        // ============================
        String s2 = "abc%";
        long k2 = 0;

        System.out.println("Input: s = \"abc%\", k = 0");
        System.out.println("Output: " + sol.processStr(s2, k2));
        System.out.println("Expected: c");
    }

    /*
    ============================
    POTD Day 17 (June)
    Problem:
    Find K-th Character in Processed String
    ============================

    Operations:

    '*' → delete last character
    '#' → duplicate entire string
    '%' → reverse string
    letter → append character

    Goal:
    Return character at index k
    without actually building the string.

    --------------------------------------------------
    Why Not Build String?
    --------------------------------------------------

    Length can become extremely large because of '#'.

    Example:

    "abc################"

    Length doubles repeatedly.

    Building final string would cause:
    - Huge memory usage
    - TLE/MLE

    So we only track length.

    ==================================================
    Approach 1: Brute Force (Build Entire String)
    ==================================================

    Idea:
    - Simulate every operation
    - Generate final string
    - Return s.charAt(k)

    TC: O(Final String Length)
    SC: O(Final String Length)

    Not feasible for large constraints.
    */

    /*
    public char processStr(String s, long k) {

        StringBuilder r = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){

            char ch = s.charAt(i);

            if(ch == '*'){
                if(r.length() > 0){
                    r.deleteCharAt(r.length() - 1);
                }
            }
            else if(ch == '#'){
                r.append(r.toString());
            }
            else if(ch == '%'){
                r.reverse();
            }
            else{
                r.append(ch);
            }
        }

        if(k >= r.length()) return '.';

        return r.charAt((int)k);
    }
    */


    /*
    ==================================================
    Approach 2: Reverse Simulation (Optimized)
    ==================================================

    Key Observation:

    We don't need the entire string.

    Step 1:
    Compute final length only.

    Step 2:
    Traverse operations backwards.

    Reverse Handling:

    --------------------------------------------------
    Letter
    --------------------------------------------------

    Character was added at position len-1.

    If k == len-1
    => answer found.

    Otherwise remove that character.

    len--

    --------------------------------------------------
    '#'
    --------------------------------------------------

    Before duplication:

    Original length = len/2

    After duplication:

    [original][original]

    If k lies in second half:

    k = k - len/2

    Then shrink:

    len /= 2

    --------------------------------------------------
    '%'
    --------------------------------------------------

    Reverse operation.

    Index mapping:

    k = len - 1 - k

    --------------------------------------------------
    '*'
    --------------------------------------------------

    One character was deleted earlier.

    Going backwards means:

    length increases by 1

    len++

    --------------------------------------------------

    TC: O(n)
    SC: O(1)
    */

    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public char processStr(String s, long k) {

        int n = s.length();

        long len = 0;

        // Step 1: Calculate final length
        for(int i = 0; i < n ; i++){

            char ch = s.charAt(i);

            if(ch == '*'){
                if(len > 0) len--;
            }
            else if(ch == '#'){
                len *= 2;
            }
            else if(ch != '%'){
                len++;
            }
        }

        // Invalid index
        if(k >= len) return '.';

        // Step 2: Reverse simulation
        for(int i = n - 1 ; i >= 0 ; i--){

            char ch = s.charAt(i);

            if(ch == '*'){

                len++;
            }

            else if(ch == '#'){

                if(k >= (len / 2)){
                    k = k - (len / 2);
                }

                len /= 2;
            }

            else if(ch == '%'){

                k = len - 1 - k;
            }

            else{

                if(len - 1 == k){
                    return ch;
                }

                len--;
            }
        }

        return '.';
    }
}