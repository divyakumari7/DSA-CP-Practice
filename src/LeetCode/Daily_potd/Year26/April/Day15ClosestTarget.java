package LeetCode.Daily_potd.Year26.April;

public class Day15ClosestTarget {

    public static void main(String[] args) {

        Day15ClosestTarget sol = new Day15ClosestTarget();

        // ============================
        // Test Case 1
        // ============================
        String[] words1 = {"hello","i","am","leetcode","hello"};
        String target1 = "hello";
        int start1 = 1;
        System.out.println("Input: words=[hello,i,am,leetcode,hello], target=hello, startIndex=1");
        System.out.println("Output: " + sol.closestTarget(words1, target1, start1));
        System.out.println("Expected: 1\n");

        // ============================
        // Test Case 2
        // ============================
        String[] words2 = {"a","b","leetcode"};
        String target2 = "leetcode";
        int start2 = 0;
        System.out.println("Input: words=[a,b,leetcode], target=leetcode, startIndex=0");
        System.out.println("Output: " + sol.closestTarget(words2, target2, start2));
        System.out.println("Expected: 1");
    }


    /*
    ============================
    Approach: Circular Two-Side Search
    ============================

    Idea:
    - Start from startIndex
    - Expand both directions:
        → right (forward)
        → left (backward)
    - Use modulo for circular array

    - At distance d:
        check:
            (startIndex + d) % n
            (startIndex - d + n) % n

    - First match gives minimum distance

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int closestTarget(String[] words, String target, int startIndex) {

        int n = words.length;

        for(int dist = 0 ; dist < n ; dist++){

            int left = (startIndex + dist) % n;
            int right = (startIndex - dist + n) % n;

            if(words[left].equals(target) || words[right].equals(target)){
                return dist;
            }
        }

        return -1;
    }
}