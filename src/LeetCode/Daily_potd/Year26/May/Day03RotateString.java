package LeetCode.Daily_potd.Year26.May;

public class Day03RotateString {

    public static void main(String[] args) {

        Day03RotateString sol = new Day03RotateString();

        // ============================
        // Test Case 1
        // ============================
        String s1 = "abcde", goal1 = "cdeab";
        System.out.println("Input: s = abcde, goal = cdeab");
        System.out.println("Output: " + sol.rotateString(s1, goal1));
        System.out.println("Expected: true\n");

        // ============================
        // Test Case 2
        // ============================
        String s2 = "abcde", goal2 = "abced";
        System.out.println("Input: s = abcde, goal = abced");
        System.out.println("Output: " + sol.rotateString(s2, goal2));
        System.out.println("Expected: false");
    }


    /*
    ============================
    Approach 1: Brute Force Rotation
    ============================

    Idea:
    - Rotate string one by one
    - Check each rotation with goal

    TC: O(n^2)
    SC: O(1)

    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) return false;

        for(int i = 0 ; i < s.length() ; i++){

            String rotated = s.substring(i) + s.substring(0, i);

            if(rotated.equals(goal)) return true;
        }

        return false;
    }
    */


    /*
    ============================
    Approach 2: Optimized (String Trick)
    ============================

    Idea:
    - If goal is rotation of s,
      then it must be substring of (s + s)

    Example:
        s = "abcde"
        s+s = "abcdeabcde"
        goal = "cdeab" → exists in s+s

    TC: O(n)
    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) return false;

        String join = s + s;

        if(join.contains(goal)) return true;

        return false;
    }
}