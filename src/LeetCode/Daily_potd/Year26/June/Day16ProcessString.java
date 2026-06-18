package LeetCode.Daily_potd.Year26.June;

public class Day16ProcessString {

    public static void main(String[] args) {

        Day16ProcessString sol = new Day16ProcessString();

        // ============================
        // Test Case 1
        // ============================
        String s1 = "abc*";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.processStr(s1));
        System.out.println("Expected: ab\n");

        // ============================
        // Test Case 2
        // ============================
        String s2 = "ab#";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.processStr(s2));
        System.out.println("Expected: abab\n");

        // ============================
        // Test Case 3
        // ============================
        String s3 = "abc%";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + sol.processStr(s3));
        System.out.println("Expected: cba\n");

        // ============================
        // Test Case 4
        // ============================
        String s4 = "a#b%*";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + sol.processStr(s4));
    }


    /*
    ============================
    POTD Day 16 June
    Process String
    ============================

    Given:
    - Normal characters
    - '*'
    - '#'
    - '%'

    Operations:

    '*' :
    Remove last character
    (if string is non-empty)

    '#' :
    Duplicate current string

    '%' :
    Reverse current string

    Return final processed string.

    ------------------------------------------------
    Approach 1: Simulation using StringBuilder
    ------------------------------------------------

    Idea:

    We process characters one by one.

    If normal character:
    -> append it

    If '*':
    -> delete last character

    If '#':
    -> duplicate current string

    If '%':
    -> reverse current string

    StringBuilder allows all these operations directly.

    ------------------------------------------------
    TC:
    ------------------------------------------------

    Let n = length of input string

    append()      -> O(1)

    delete last   -> O(1)

    reverse()     -> O(current length)

    duplicate(#)  -> O(current length)

    Worst Case:
    String size may grow exponentially because of '#'

    TC: O(final string length)

    ------------------------------------------------
    SC:
    ------------------------------------------------

    O(final string length)
    */


    /*
    ============================
    Alternative Approach
    ============================

    Using Stack<Character>

    Idea:
    - Push normal chars
    - Pop for '*'
    - For '#', copy entire stack
    - For '%', reverse stack

    But:

    - Reverse becomes costly
    - Duplication becomes harder

    Therefore StringBuilder is cleaner
    and more efficient.

    TC: O(final string length)
    SC: O(final string length)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public String processStr(String s) {

        StringBuilder r = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++) {

            char ch = s.charAt(i);

            // Remove last character
            if(ch == '*') {

                if(r.length() > 0) {
                    r.deleteCharAt(r.length() - 1);
                }
            }

            // Duplicate current string
            else if(ch == '#') {

                r.append(r.toString());
            }

            // Reverse string
            else if(ch == '%') {

                r.reverse();
            }

            // Normal character
            else {

                r.append(ch);
            }
        }

        return r.toString();
    }
}