package LeetCode.Daily_potd.Year26.April;

public class Day25FurthestDistanceFromOrigin {

    public static void main(String[] args) {

        Day25FurthestDistanceFromOrigin sol = new Day25FurthestDistanceFromOrigin();

        // ============================
        // Test Case 1
        // ============================
        String moves1 = "L_RL__R";
        System.out.println("Input: moves = L_RL__R");
        System.out.println("Output: " + sol.furthestDistanceFromOrigin(moves1));
        System.out.println("Expected: 3\n");

        // ============================
        // Test Case 2
        // ============================
        String moves2 = "_R__L";
        System.out.println("Input: moves = _R__L");
        System.out.println("Output: " + sol.furthestDistanceFromOrigin(moves2));
        System.out.println("Expected: 4");
    }


    /*
    ============================
    Approach: Greedy Counting
    ============================

    Idea:
    - 'L' → move left
    - 'R' → move right
    - '_' → can be either L or R (flexible)

    Goal:
    - Maximize distance from origin

    Strategy:
    - Count:
        a → number of L
        b → number of R
        c → number of '_'

    - Convert '_' in such a way that it increases distance

    - Final position:
        position = a + b   (b is negative)

    - Max distance:
        = |a + b| + c

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int furthestDistanceFromOrigin(String moves) {

        int n = moves.length();

        int a = 0; // count of L
        int b = 0; // count of R (stored negative)
        int c = 0; // count of '_'

        for(int i = 0 ; i < n ; i++){

            if(moves.charAt(i) == 'L') a++;

            else if(moves.charAt(i) == 'R') b--;

            else c++;
        }

        if(a > Math.abs(b)){
            return a + b + c;
        }
        else return - b - a + c;
    }
}